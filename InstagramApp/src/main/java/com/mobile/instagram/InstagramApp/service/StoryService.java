package com.mobile.instagram.InstagramApp.service;

import com.mobile.instagram.InstagramApp.entity.Image;
import com.mobile.instagram.InstagramApp.entity.Story;
import com.mobile.instagram.InstagramApp.entity.User;
import com.mobile.instagram.InstagramApp.entity.ViewStory;
import com.mobile.instagram.InstagramApp.mapper.UserMapper;
import com.mobile.instagram.InstagramApp.model.StoryDTO;
import com.mobile.instagram.InstagramApp.model.StoryResponse;
import com.mobile.instagram.InstagramApp.model.ViewStoryDTO;
import com.mobile.instagram.InstagramApp.repository.StoryRepository;
import com.mobile.instagram.InstagramApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoryService {
    private final StoryRepository storyRepository;
    private final UserRepository userRepository;

    @Value("${pathImage}")
    private String pathImage;

    public List<StoryResponse> getAll(Long userId) {
        List<User> users = userRepository.findAll();

        List<StoryResponse> list = new ArrayList<>();

        for(User user: users) {
            List<Story> listStory = storyRepository.getAllByUser(user);

            List<StoryDTO> dtoListStory = listStory.stream().map((story -> {
                return StoryDTO.builder()
                        .id(story.getId())
                        .imageUri(story.getImage().getImageUri())
                        .postedTime(toPostedTime(story.getCreatedAt()))
                        .stateStory(checkStateStory(userId, story.getViewStories()))
                        .build();
            })).collect(Collectors.toList());

            list.add(new StoryResponse(UserMapper.userToUserDTO(user), dtoListStory));
        }

        return list;
    }

    private boolean checkStateStory(Long userId, List<ViewStory> viewStories) {
        for(ViewStory vs: viewStories){
            if(vs.getUser().getId()==userId) return true;
        };

        return false;
    }

    private String toPostedTime(LocalDateTime pastDateTime) {
        LocalDateTime now = LocalDateTime.now();

        // Tính khoảng thời gian
        Duration duration = Duration.between(pastDateTime, now);

        // Nếu thời gian nhỏ hơn 60 phút, trả về số phút
        if (duration.toMinutes() < 60) {
            return duration.toMinutes() + " m";
        } else {
            // Nếu thời gian lớn hơn 60 phút, làm tròn số giờ
            long hours = duration.toHours();
            return hours + " h";
        }
    }

    private List<ViewStoryDTO> toViewStoryDTO(List<ViewStory> viewStories) {
        List<ViewStoryDTO> list = viewStories.stream().map((viewStory -> {
            return ViewStoryDTO.builder()
                    .id(viewStory.getId())
                    .user(UserMapper.userToUserDTO(viewStory.getUser()))
                    .numberViews(viewStory.getNumberViews() != null ? viewStory.getNumberViews() : 0)
                    .build();
        }
        )).collect(Collectors.toList());

        return list;
    }

    public void create(Long userId, MultipartFile image) throws IOException {
        User user = userRepository.findById(userId).orElseThrow(()->{
            throw new RuntimeException("User is not found!");
        });

        Image newImage = new Image();
        newImage.setImageUri(pathImage + ImageService.saveImage("images/", image));

        Story story = Story.builder()
                .user(user)
                .image(newImage)
                .createdAt(LocalDateTime.now())
                .viewStories(new ArrayList<>())
                .build();

        storyRepository.save(story);
    }
}

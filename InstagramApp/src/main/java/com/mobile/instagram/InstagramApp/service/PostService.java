package com.mobile.instagram.InstagramApp.service;

import com.mobile.instagram.InstagramApp.entity.Comment;
import com.mobile.instagram.InstagramApp.entity.Image;
import com.mobile.instagram.InstagramApp.entity.Post;
import com.mobile.instagram.InstagramApp.entity.User;
import com.mobile.instagram.InstagramApp.mapper.UserMapper;
import com.mobile.instagram.InstagramApp.model.CommentDTO;
import com.mobile.instagram.InstagramApp.model.CommentRequest;
import com.mobile.instagram.InstagramApp.model.PostResponse;
import com.mobile.instagram.InstagramApp.model.UserDTO;
import com.mobile.instagram.InstagramApp.repository.PostRepository;
import com.mobile.instagram.InstagramApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Value("${pathImage}")
    private String pathImage;

    public List<PostResponse> getAll() {
        List<Post> list = postRepository.findAllOrderByCreatedAtDesc();

        List<PostResponse> postResponses = list.stream().map((post)->{
            UserDTO userDTO = UserMapper.userToUserDTO(post.getUser());
//            System.out.println(post.getImages());
            List<String> images = post.getImages().stream().map((image)->{
                return image.getImageUri();
            }).toList();

            List<CommentDTO> comments = post.getComments().stream().map((comment)-> {
                return CommentDTO.builder()
                        .id(comment.getId())
                        .user(UserMapper.userToUserDTO(comment.getUser()))
                        .createdAt(comment.getCreatedAt())
                        .content(comment.getContent())
                        .build();
            }).collect(Collectors.toList());

            return PostResponse.builder()
                    .id(post.getId())
                    .user(userDTO)
                    .createdAt(post.getCreatedAt())
                    .captions(post.getContent())
                    .likes(post.getLikes())
                    .images(images)
                    .comments(comments)
                    .build();
        }).collect(Collectors.toList());

        return postResponses;
    }

    public List<CommentDTO> addComment(CommentRequest request) {
        if(request.getPostId()==null || request.getUserId()==null || request.getContent()==null) {
            throw new RuntimeException("Please input full info");
        }

        Post post = postRepository.findById(request.getPostId()).orElseThrow(()->{
            throw new RuntimeException("Post is not found!");
        });

        User user = userRepository.findById(request.getUserId()).orElseThrow(()->{
            throw new RuntimeException("User is not found!");
        });

        Comment comment = Comment.builder()
                .post(post)
                .user(user)
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        List<Comment> comments = null;
        if(post.getComments()==null) {
            comments = new ArrayList<>();
            comments.add(comment);
        } else {
            comments = post.getComments();
            comments.add(comment);
        }

        post.setComments(comments);

        Post updatePost = postRepository.save(post);

        return updatePost.getComments().stream().map((c)-> {
            return CommentDTO.builder()
                    .id(c.getId())
                    .user(UserMapper.userToUserDTO(c.getUser()))
                    .createdAt(c.getCreatedAt())
                    .content(c.getContent())
                    .build();
        }).collect(Collectors.toList());
    }

    public void createPost(Long userId, String content, MultipartFile image) throws IOException {
        if(userId==null || content==null || image==null) {
            throw new RuntimeException("Please input full info!");
        }

        User user = userRepository.findById(userId).orElseThrow(()->{
            throw new RuntimeException("User is not found!");
        });

        Post post = Post.builder()
                .user(user)
                .createdAt(LocalDateTime.now())
                .content(content)
                .likes(12311)
//                .images(List.of(newImage))
                .comments(new ArrayList<>())
                .build();

        String uriImage = ImageService.saveImage("images/", image);
        Image newImage = new Image();
        newImage.setImageUri(pathImage+uriImage);
        newImage.setPost(post);

        post.setImages(List.of(newImage));

        postRepository.save(post);
    }

    public PostResponse getDetail(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()->{
            throw new RuntimeException("Post is not found!");
        });

        List<CommentDTO> comments = post.getComments().stream().map((comment)-> {
            return CommentDTO.builder()
                    .id(comment.getId())
                    .user(UserMapper.userToUserDTO(comment.getUser()))
                    .createdAt(comment.getCreatedAt())
                    .content(comment.getContent())
                    .build();
        }).collect(Collectors.toList());

        PostResponse postResponse = PostResponse.builder()
                .id(post.getId())
                .user(UserMapper.userToUserDTO(post.getUser()))
                .createdAt(post.getCreatedAt())
                .captions(post.getContent())
                .likes(post.getLikes())
                .images(post.getImages().stream().map((image -> image.getImageUri())).collect(Collectors.toList()))
                .comments(comments)
                .build();

        return postResponse;
    }
}

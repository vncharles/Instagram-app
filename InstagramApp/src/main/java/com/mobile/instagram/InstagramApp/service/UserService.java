package com.mobile.instagram.InstagramApp.service;

import com.mobile.instagram.InstagramApp.entity.User;
import com.mobile.instagram.InstagramApp.mapper.UserMapper;
import com.mobile.instagram.InstagramApp.model.LoginRequest;
import com.mobile.instagram.InstagramApp.model.RegisterRequest;
import com.mobile.instagram.InstagramApp.model.UserDTO;
import com.mobile.instagram.InstagramApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    @Value("pathImage")
    private String pathImage;

    public void register(RegisterRequest request, MultipartFile avatar) throws IOException {
        if(null == request.getPhone() ||
            null == request.getName() ||
            null == request.getFullName() ||
            null == request.getPassword())  {
            throw new RuntimeException("please input full info");
        }

        User user = User.builder()
                .phone(request.getPhone())
                .name(request.getName())
                .fullName(request.getFullName())
                .password(request.getPassword())
//                .imageUri(pathImage + ImageService.saveImage("images/", avatar))
                .follower(25012)
                .following(23)
                .build();

        try {
            userRepository.saveAndFlush(user);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    public UserDTO login(LoginRequest request) {
        if(null == request.getPhone() || null == request.getPassword()) {
            throw new RuntimeException("Phone and password is require");
        }

        User user = userRepository.findUserByPhoneAndPassword(request.getPhone(), request.getPassword()).orElseThrow(()-> {
            throw new RuntimeException("User is not found");
        });

        return UserMapper.userToUserDTO(user);
    }
}

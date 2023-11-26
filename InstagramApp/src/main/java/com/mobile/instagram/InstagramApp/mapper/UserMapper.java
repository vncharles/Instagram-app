package com.mobile.instagram.InstagramApp.mapper;

import com.mobile.instagram.InstagramApp.entity.User;
import com.mobile.instagram.InstagramApp.model.UserDTO;

public class UserMapper {
    public static UserDTO userToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .phone(user.getPhone())
                .image(user.getImageUri())
                .name(user.getName())
                .follower(user.getFollower())
                .following(user.getFollowing())
                .fullName(user.getFullName())
                .build();
    }

}

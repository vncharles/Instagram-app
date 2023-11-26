package com.mobile.instagram.InstagramApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class UserDTO {
    private Long id;
    private String phone;
    private String image;
    private String name;
    private Integer follower;
    private Integer following;
    private String fullName;
}

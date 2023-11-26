package com.mobile.instagram.InstagramApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RegisterRequest {
    private String phone;
    private String name;
    private String fullName;
    private String password;
}

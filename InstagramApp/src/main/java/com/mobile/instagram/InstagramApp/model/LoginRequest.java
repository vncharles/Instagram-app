package com.mobile.instagram.InstagramApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class LoginRequest {
    private String phone;
    private String password;
}

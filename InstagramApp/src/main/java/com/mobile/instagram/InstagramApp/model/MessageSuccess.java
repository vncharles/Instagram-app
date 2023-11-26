package com.mobile.instagram.InstagramApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class MessageSuccess {
    private int status;
    private String message;

    public MessageSuccess(String message) {
        this.status = 200;
        this.message = message;
    }
}

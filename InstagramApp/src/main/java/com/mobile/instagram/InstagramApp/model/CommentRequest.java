package com.mobile.instagram.InstagramApp.model;

import lombok.Data;

@Data
public class CommentRequest {
    private Long postId;
    private Long userId;
    private String content;
}

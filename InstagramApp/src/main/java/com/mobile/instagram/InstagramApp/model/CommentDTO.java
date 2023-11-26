package com.mobile.instagram.InstagramApp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommentDTO {
    private Long id;
    private UserDTO user;
    private LocalDateTime createdAt;
    private String content;
}

package com.mobile.instagram.InstagramApp.model;

import com.mobile.instagram.InstagramApp.entity.Comment;
import com.mobile.instagram.InstagramApp.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data @Builder
public class PostResponse {
    private Long id;
    private UserDTO user;
    private LocalDateTime createdAt;
    private String captions;
    private Integer likes;
    private List<String> images;
    private List<CommentDTO> comments;
}

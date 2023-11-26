package com.mobile.instagram.InstagramApp.model;

import com.mobile.instagram.InstagramApp.entity.Story;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data @Builder @AllArgsConstructor
public class StoryResponse {
    private UserDTO user;
    private List<StoryDTO> stories;
}

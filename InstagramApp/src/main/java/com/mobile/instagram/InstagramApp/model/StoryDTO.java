package com.mobile.instagram.InstagramApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoryDTO {
    private Long id;
    private String imageUri;
    private String postedTime;
    private boolean stateStory;

}

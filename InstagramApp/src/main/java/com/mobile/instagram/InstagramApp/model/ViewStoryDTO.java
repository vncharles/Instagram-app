package com.mobile.instagram.InstagramApp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViewStoryDTO {
    private Long id;
    private UserDTO user;
    private Integer numberViews;
}

package com.mobile.instagram.InstagramApp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class MessageWithUser {
    private Long id;
    private UserDTO userSend;
    private UserDTO userReceive;
    private String message;
    private LocalDateTime time;
}

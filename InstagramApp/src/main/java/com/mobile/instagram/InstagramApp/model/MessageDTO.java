package com.mobile.instagram.InstagramApp.model;

import com.mobile.instagram.InstagramApp.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class MessageDTO {
    private Long id;
    private UserDTO userSend;
    private UserDTO userReceive;
    private String message;
    private LocalDateTime time;
}

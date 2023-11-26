package com.mobile.instagram.InstagramApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity @Table(name = "t_message")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id_send")
    private User userSend;
    @ManyToOne
    @JoinColumn(name = "user_id_receive")
    private User userReceive;
    private String message;
    private LocalDateTime time;
}

package com.mobile.instagram.InstagramApp.model;

import lombok.Data;

@Data
public class NewMessage {
    private String message;
    private Long userSend;
    private Long userReceive;
}

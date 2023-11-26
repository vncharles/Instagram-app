package com.mobile.instagram.InstagramApp.model;

import com.mobile.instagram.InstagramApp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class UserListChatResponse {
    private UserDTO user;
    private List<MessageWithUser> chatData;
}

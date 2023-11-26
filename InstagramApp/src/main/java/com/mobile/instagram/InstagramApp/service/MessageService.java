package com.mobile.instagram.InstagramApp.service;

import com.mobile.instagram.InstagramApp.entity.Message;
import com.mobile.instagram.InstagramApp.entity.User;
import com.mobile.instagram.InstagramApp.mapper.UserMapper;
import com.mobile.instagram.InstagramApp.model.*;
import com.mobile.instagram.InstagramApp.repository.MessageRepository;
import com.mobile.instagram.InstagramApp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.RuntimeMBeanException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public List<UserDTO> getUserChat(Long userId) {
        List<User> listUser = userRepository.getAllWhereNotEqual(userId);

        return listUser.stream().map(user -> UserMapper.userToUserDTO(user)).collect(Collectors.toList());
    }

    public List<MessageWithUser> getMessageChat(Long userIdSend, Long userIdReceive) {
        List<Message> messageList = messageRepository.getAllByUserSend(userIdSend, userIdReceive);

        return messageList.stream().map(message -> MessageWithUser.builder()
                .id(message.getId())
                .userSend(UserMapper.userToUserDTO(message.getUserSend()))
                .userReceive(UserMapper.userToUserDTO(message.getUserReceive()))
                .message(message.getMessage())
                .time(message.getTime())
                .build()).collect(Collectors.toList());
    }

    public MessageDTO sendMessage(NewMessage newMessage) {
        if(newMessage.getMessage()==null || newMessage.getUserSend()==null || newMessage.getUserReceive()==null) {
            throw new RuntimeException("Please input full info");
        }

        User userSend = userRepository.findById(newMessage.getUserSend()).orElseThrow(()->{
            throw new RuntimeException("User send is not found!");
        });

        User userReceive = userRepository.findById(newMessage.getUserReceive()).orElseThrow(()->{
            throw new RuntimeException("User send is not found!");
        });

        Message message = Message.builder()
                .message(newMessage.getMessage())
                .userSend(userSend)
                .userReceive(userReceive)
                .time(LocalDateTime.now())
                .build();

        Message saveMessage = messageRepository.save(message);

        return MessageDTO.builder()
                .id(saveMessage.getId())
                .message(saveMessage.getMessage())
                .userSend(UserMapper.userToUserDTO(saveMessage.getUserSend()))
                .userReceive(UserMapper.userToUserDTO(saveMessage.getUserReceive()))
                .time(saveMessage.getTime())
                .build();
    }
}

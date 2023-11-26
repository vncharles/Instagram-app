package com.mobile.instagram.InstagramApp.controller;

import com.mobile.instagram.InstagramApp.model.MessageDTO;
import com.mobile.instagram.InstagramApp.model.MessageWithUser;
import com.mobile.instagram.InstagramApp.model.NewMessage;
import com.mobile.instagram.InstagramApp.model.UserDTO;
import com.mobile.instagram.InstagramApp.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/{id}")
    public ResponseEntity<List<UserDTO>> getAllUserChat(@PathVariable("id") Long userId) {
        return ResponseEntity.ok(messageService.getUserChat(userId));
    }

    @GetMapping("/chat")
    public ResponseEntity<List<MessageWithUser>> getAllMessageChat(@RequestParam("userSend") Long userIdSend,
                                                                   @RequestParam("userReceive") Long userIdReceive) {
        return ResponseEntity.ok(messageService.getMessageChat(userIdSend, userIdReceive));
    }

    @PostMapping
    public ResponseEntity<MessageDTO> sendMessage(@RequestBody NewMessage newMessage) {
        return ResponseEntity.ok(messageService.sendMessage(newMessage));
    }
}

package com.mobile.instagram.InstagramApp.controller;

import com.mobile.instagram.InstagramApp.model.LoginRequest;
import com.mobile.instagram.InstagramApp.model.MessageSuccess;
import com.mobile.instagram.InstagramApp.model.RegisterRequest;
import com.mobile.instagram.InstagramApp.model.UserDTO;
import com.mobile.instagram.InstagramApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request,
                                      @RequestParam(required = false) MultipartFile avatar) throws IOException {
        userService.register(request, avatar);

        return ResponseEntity.ok(new MessageSuccess("Register is success"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        UserDTO user = userService.login(request);

        return ResponseEntity.ok(user);
    }
}

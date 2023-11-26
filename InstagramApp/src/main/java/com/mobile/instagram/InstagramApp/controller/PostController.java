package com.mobile.instagram.InstagramApp.controller;

import com.mobile.instagram.InstagramApp.model.CommentDTO;
import com.mobile.instagram.InstagramApp.model.CommentRequest;
import com.mobile.instagram.InstagramApp.model.MessageSuccess;
import com.mobile.instagram.InstagramApp.model.PostResponse;
import com.mobile.instagram.InstagramApp.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAll() {
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getDetail(@PathVariable("id")Long id) {
        return ResponseEntity.ok(postService.getDetail(id));
    }

    @PostMapping("/comment")
    public ResponseEntity<List<CommentDTO>> addComment(@RequestBody CommentRequest commentRequest) {
        List<CommentDTO> list = postService.addComment(commentRequest);

        return ResponseEntity.ok(list);
    }

    @PostMapping(value = "/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    public ResponseEntity<?> createPost(@PathVariable("userId")Long userId,
                                        @RequestParam(value = "content", required = false)String content,
                                        @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {

        System.out.println("UserID: " + userId);
        System.out.println("Content: " + content);
        System.out.println("Image: " + image);


        postService.createPost(userId, content, image);

        return ResponseEntity.ok(new MessageSuccess("Create post success"));
    }

}

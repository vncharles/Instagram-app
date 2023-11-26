package com.mobile.instagram.InstagramApp.controller;

import com.mobile.instagram.InstagramApp.model.MessageSuccess;
import com.mobile.instagram.InstagramApp.service.StoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/story")
@RequiredArgsConstructor
public class StoryController {
    private final StoryService storyService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAll(@PathVariable("id")Long id) {
        return ResponseEntity.ok(storyService.getAll(id));
//        return ResponseEntity.ok(new ArrayList<>());
    }

    @PostMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createStory(@PathVariable("id")Long userId, @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        System.out.println("User ID: " + userId);
        System.out.println("Image: " + image);

        storyService.create(userId, image);

        return ResponseEntity.ok(new MessageSuccess("Create story success"));
    }

    private BufferedImage convertByteArrayToImage(byte[] byteData) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(byteData);
            BufferedImage image = ImageIO.read(bis);
            bis.close();
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

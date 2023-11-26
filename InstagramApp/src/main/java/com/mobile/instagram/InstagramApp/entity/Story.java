package com.mobile.instagram.InstagramApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_story")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image image;

    private LocalDateTime createdAt;
    private boolean statusTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ViewStory> viewStories;
}

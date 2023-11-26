package com.mobile.instagram.InstagramApp.repository;

import com.mobile.instagram.InstagramApp.entity.Story;
import com.mobile.instagram.InstagramApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    @Query(nativeQuery = true, value = "select * from t_story  " +
            "where TIMESTAMPDIFF(HOUR, `created_at`, NOW()) < 24 and user_id=?1")
    List<Story> getAllStory(Long userId);

    List<Story> getAllByUser(User user);
}

package com.mobile.instagram.InstagramApp.repository;

import com.mobile.instagram.InstagramApp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM t_post order by created_at DESC;")
    List<Post> findAllOrderByCreatedAtDesc();
}

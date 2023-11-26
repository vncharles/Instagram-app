package com.mobile.instagram.InstagramApp.repository;

import com.mobile.instagram.InstagramApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByPhoneAndPassword(String phone, String password);

    @Query(nativeQuery = true, value = "SELECT DISTINCT u.id, u.phone, u.image_uri, u.name, u.follower, u.following, u.full_name, u.password FROM t_user u JOIN t_message m ON u.id = m.user_id_receive WHERE m.user_id_send = ?1")
    List<User> getAllUserChat(Long userId);

    @Query(nativeQuery = true, value = "SELECT * FROM t_user e WHERE id != ?1")
    List<User> getAllWhereNotEqual(Long id);
}

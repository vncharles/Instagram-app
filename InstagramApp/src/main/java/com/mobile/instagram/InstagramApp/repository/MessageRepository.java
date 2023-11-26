package com.mobile.instagram.InstagramApp.repository;

import com.mobile.instagram.InstagramApp.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM t_message where (user_id_send=?1 and user_id_receive=?2) or (user_id_send=?2 and user_id_receive=?1) order by time;")
    List<Message> getAllByUserSend(Long userIdSend, Long userIdReceive);
}

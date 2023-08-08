package com.mgmetehan.SocialPostHub.repository;

import com.mgmetehan.SocialPostHub.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> {
    @Query("SELECT u.firstName FROM Users u")
    List<String> findAllFirstNames();

    @Query("SELECT u.firstName FROM Users u WHERE DATE(u.createdAt) = CURRENT_DATE")
    List<String> findAllFirstNamesWithTodayCreatedAt();

    List<Users> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);
}

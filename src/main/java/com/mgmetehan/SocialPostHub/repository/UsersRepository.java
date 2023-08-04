package com.mgmetehan.SocialPostHub.repository;

import com.mgmetehan.SocialPostHub.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, String> {
}

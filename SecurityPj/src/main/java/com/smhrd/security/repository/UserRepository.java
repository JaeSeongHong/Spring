package com.smhrd.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.security.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);
}
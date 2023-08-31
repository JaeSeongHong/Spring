package com.smhrd.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smhrd.security.entity.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}

package com.smhrd.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smhrd.security.entity.User;
import com.smhrd.security.repository.UserRepository;
import com.smhrd.security.user.CustomUserDetails;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("조회 실패"));
                

        return new CustomUserDetails(user);
    }
}
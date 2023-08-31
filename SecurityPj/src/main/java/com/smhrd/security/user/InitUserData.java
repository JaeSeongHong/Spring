package com.smhrd.security.user;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import com.smhrd.security.entity.Authority;
import com.smhrd.security.entity.EncryptionAlgorithm;
import com.smhrd.security.entity.User;
import com.smhrd.security.repository.AuthorityRepository;
import com.smhrd.security.repository.UserRepository;

import jakarta.annotation.PostConstruct;



@Component
@RequiredArgsConstructor
public class InitUserData {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final UserDetailsService userDetailsService;

    @PostConstruct
    public void setInitUserData() {

        User user = new User();
        user.setUsername("hjs");
        user.setUsername("pjh");
        user.setPassword("$2a$10$8SltI0Jht3aZC.LNkfPZ1OeKh.iAAtVmnh.SkJpF1nqaH0RfIBOye"); // 1234
        user.setPassword("$2a$10$8SltI0Jht3aZC.LNkfPZ1OeKh.iAAtVmnh.SkJpF1nqaH0RfIBOye"); // 1234
        user.setAlgorithm(EncryptionAlgorithm.BCRYPT);

        Authority authority = new Authority();
        authority.setName("read");
        authority.setUser(user);

        userRepository.save(user);
        authorityRepository.save(authority);
        
        
    }
    
//    @PostConstruct
//    public void saveUsers() {
//        UserDetails userA = User.withUsername("jinseok")
//                .password("1234")
//                .authorities("WRITE", "READ", "UPDATE")
//                .build();
//
//        UserDetails userB = User.withUsername("suchon")
//                .password("1234")
//                .authorities("READ")
//                .build();
//
//        UserDetailsManager userDetailsService = (UserDetailsManager) this.userDetailsService;
//
//        userDetailsService.createUser(userA);
//        userDetailsService.createUser(userB);
//    }
}

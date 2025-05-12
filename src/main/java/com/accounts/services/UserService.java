package com.accounts.services;

import com.accounts.models.Role;
import com.accounts.models.User;
import com.accounts.repositories.RoleRepository;
import com.accounts.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("User already exists");
        }
        Role userRole = roleRepository.findByName("USER");
        return userRepository.save(User.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(Set.of(userRole))
                .build());
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}

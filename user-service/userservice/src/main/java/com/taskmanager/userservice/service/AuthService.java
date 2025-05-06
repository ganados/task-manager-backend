package com.taskmanager.userservice.service;

import com.taskmanager.model.User;
import com.taskmanager.userservice.dto.UserDto;
import com.taskmanager.userservice.repository.UserRepository;
import com.taskmanager.userservice.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public UUID register(User user) {
        UserDto userDto = UserDto.builder()
                .username(user.getUsername())
                .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                .build();
        UserDto savedUser = userRepository.save(userDto);
        return savedUser.getId();
    }

    public String login(User user) {
        UserDto userDto = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!new BCryptPasswordEncoder().matches(user.getPassword(), userDto.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtil.generateToken(user.getUsername());
    }
}

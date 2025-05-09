package com.taskmanager.userservice.service;

import com.taskmanager.model.User;
import com.taskmanager.userservice.dto.UserDto;
import com.taskmanager.userservice.mapper.UserMapper;
import com.taskmanager.userservice.repository.UserDetailsRepository;
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
    private final UserDetailsRepository userDetailsRepository;
    private final JwtUtil jwtUtil;

    public UUID register(User user) {
        UserDto savedUser = userRepository.save(UserMapper.toUserDto(user));
        userDetailsRepository.save(UserMapper.userDtoToUserDetailsDto(savedUser));
        return savedUser.getId();
    }

    public String login(User user) {
        UserDto userDto = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (!new BCryptPasswordEncoder().matches(user.getPassword(), userDto.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return jwtUtil.generateToken(user.getEmail());
    }
}

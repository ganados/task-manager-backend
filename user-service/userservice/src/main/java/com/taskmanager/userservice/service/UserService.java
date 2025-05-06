package com.taskmanager.userservice.service;

import com.taskmanager.model.User;
import com.taskmanager.model.UserDetails;
import com.taskmanager.userservice.dto.UserDto;
import com.taskmanager.userservice.mapper.UserMapper;
import com.taskmanager.userservice.repository.UserRepository;
import com.taskmanager.userservice.security.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDetails getUserDetails(String userId) {
        UserDto userDto = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.dtoToUserDetails(userDto);
    }
}

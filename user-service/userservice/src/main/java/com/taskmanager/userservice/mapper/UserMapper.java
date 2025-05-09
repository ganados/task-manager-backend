package com.taskmanager.userservice.mapper;

import com.taskmanager.model.User;
import com.taskmanager.model.UserDetails;
import com.taskmanager.userservice.dto.UserDetailsDto;
import com.taskmanager.userservice.dto.UserDto;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapper {

    public static UserDetails dtoToUserDetails(UserDetailsDto userDetailsDto) {
        return UserDetails.builder()
                .id(userDetailsDto.getId().toString())
                .email(userDetailsDto.getEmail())
                .name(userDetailsDto.getName())
                .surname(userDetailsDto.getSurname())
                // TODO: Update registration or add update user details endpoint
                .build();
    }

    public static UserDto toUserDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                .build();
    }

    public static UserDetailsDto userDtoToUserDetailsDto(UserDto userDto) {
        return UserDetailsDto.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .build();
    }
}

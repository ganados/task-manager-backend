package com.taskmanager.userservice.mapper;

import com.taskmanager.model.UserDetails;
import com.taskmanager.userservice.dto.UserDto;

public class UserMapper {

    public static UserDetails dtoToUserDetails(UserDto userDto) {
        return UserDetails.builder()
                .id(userDto.getId().toString())
                .username(userDto.getUsername())
                // TODO: Add rest of user details fields
                // TODO: Update registration or add update user details endpoint
                .build();
    }
}

package com.taskmanager.userservice.service;

import com.taskmanager.model.UserDetails;
import com.taskmanager.userservice.dto.UserDetailsDto;
import com.taskmanager.userservice.mapper.UserMapper;
import com.taskmanager.userservice.repository.UserDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private final UserDetailsRepository userDetailsRepository;

    public List<UserDetails> getUsers() {
        List<UserDetailsDto> userDetailsDtoList = userDetailsRepository.findAll();
        return userDetailsDtoList.stream().map(UserMapper::dtoToUserDetails).toList();
    }
}

package com.taskmanager.boardservice.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class UserDetailsDto {

    private UUID userId;
    private String username;
    private String email;
}

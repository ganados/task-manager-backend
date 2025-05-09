package com.taskmanager.boardservice.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

    @Data
    @Entity
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
public class BoardDetailsDto {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String boardName;
    private UUID ownerId;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<UUID> memberIds;

}



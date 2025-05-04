package com.taskmanager.taskservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatusDto {
    TODO("TODO"),
    DOING("DOING"),
    ON_HOLD("ON_HOLD"),
    DONE("DONE");

    private final String value;
}

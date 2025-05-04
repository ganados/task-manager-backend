package com.taskmanager.taskservice.mapper;


import com.taskmanager.model.Task;
import com.taskmanager.model.TaskDetails;
import com.taskmanager.model.TaskStatus;
import com.taskmanager.taskservice.dto.TaskDto;
import com.taskmanager.taskservice.dto.TaskStatusDto;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TaskMapper {

    public static TaskDto modelToTaskDto(Task task) {
        return TaskDto.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .taskStatus(TaskStatusDto.valueOf(task.getTaskStatus().getValue()))
                .reporterId(UUID.fromString(task.getReporterId()))
                .assigneeId(UUID.fromString(task.getAssigneeId()))
                .boardId(UUID.fromString(task.getBoardId()))
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .build();
    }

    public static TaskDto taskDetailsToTaskDto(TaskDetails task) {
        TaskDto taskDto = TaskDto.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .taskStatus(TaskStatusDto.valueOf(task.getTaskStatus().getValue()))
                .reporterId(UUID.fromString(task.getReporterId()))
                .assigneeId(UUID.fromString(task.getAssigneeId()))
                .boardId(UUID.fromString(task.getBoardId()))
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .build();
        if (!task.getId().isEmpty() && !task.getId().isBlank()) {
             taskDto.setId(UUID.fromString(task.getId()));
        }
        return taskDto;
    }

    public static TaskDetails dtoToTaskDetails(TaskDto taskDto) {
        return TaskDetails.builder()
                .id(taskDto.getId().toString())
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .taskStatus(TaskStatus.valueOf(taskDto.getTaskStatus().getValue()))
                .reporterId(taskDto.getReporterId().toString())
                .assigneeId(taskDto.getAssigneeId().toString())
                .boardId(taskDto.getBoardId().toString())
                .createdAt(OffsetDateTime.now())
                .updatedAt(OffsetDateTime.now())
                .build();
    }
}

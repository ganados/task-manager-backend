package com.taskmanager.taskservice.service;

import com.taskmanager.model.Task;
import com.taskmanager.model.TaskDetails;
import com.taskmanager.taskservice.dto.TaskDto;
import com.taskmanager.taskservice.mapper.TaskMapper;
import com.taskmanager.taskservice.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public UUID createTask(Task task) {
        TaskDto savedTask = taskRepository.save(TaskMapper.modelToTaskDto(task));
        return savedTask.getId();
    }

    public TaskDetails getTask(UUID id) {
        TaskDto taskDto = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return TaskMapper.dtoToTaskDetails(taskDto);
    }
}

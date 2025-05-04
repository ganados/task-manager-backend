package com.taskmanager.taskservice.service;

import com.taskmanager.model.Task;
import com.taskmanager.model.TaskDetails;
import com.taskmanager.taskservice.dto.TaskDto;
import com.taskmanager.taskservice.dto.TaskStatusDto;
import com.taskmanager.taskservice.mapper.TaskMapper;
import com.taskmanager.taskservice.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public UUID createTask(Task task) {
        TaskDto savedTask = taskRepository.save(TaskMapper.modelToTaskDto(task));
        return savedTask.getId();
    }

    public void patchTask(TaskDetails task) {
        Optional<TaskDto> savedTask = taskRepository.findById(UUID.fromString(task.getId()));
        if (savedTask.isPresent()) {
            patchTaskValues(savedTask.get(), task);
            taskRepository.save(savedTask.get());
        }
        else {
            throw new RuntimeException("Task not found");
        }
    }

    public TaskDetails getTask(UUID taskId) {
        TaskDto taskDto = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return TaskMapper.dtoToTaskDetails(taskDto);
    }

    public List<TaskDetails> getBoardTasks(UUID boardId) {
        Optional<List<TaskDto>> boardTasks = taskRepository.findAllByBoardId(boardId);
        return boardTasks.map(taskDtos -> taskDtos.stream()
                .map(TaskMapper::dtoToTaskDetails)
                .collect(Collectors.toList())).orElseGet(List::of);
    }

    public void deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
    }

    private static void patchTaskValues(TaskDto taskDto, TaskDetails taskDetails) {
        Optional.ofNullable(taskDetails.getTitle()).ifPresent(taskDto::setTitle);
        Optional.ofNullable(taskDetails.getDescription()).ifPresent(taskDto::setDescription);
        Optional.ofNullable(taskDetails.getTaskStatus())
                .ifPresent(taskStatus -> taskDto.setTaskStatus(TaskStatusDto.valueOf(taskStatus.getValue())));
        Optional.ofNullable(taskDetails.getReporterId())
                .ifPresent(reporterId -> taskDto.setReporterId(UUID.fromString(reporterId)));
        Optional.ofNullable(taskDetails.getAssigneeId())
                .ifPresent(assigneeId -> taskDto.setAssigneeId(UUID.fromString(assigneeId)));
        Optional.ofNullable(taskDetails.getBoardId())
                .ifPresent(boardId -> taskDto.setBoardId(UUID.fromString(boardId)));
        taskDto.setUpdatedAt(OffsetDateTime.now());
    }
}

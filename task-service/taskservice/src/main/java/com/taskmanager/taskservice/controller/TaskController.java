package com.taskmanager.taskservice.controller;

import com.taskmanager.model.Task;
import com.taskmanager.model.TaskDetails;
import com.taskmanager.taskservice.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    public final TaskService taskService;

    @PostMapping
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task).toString());
    }

    @PatchMapping
    public ResponseEntity<String> patchTask(@RequestBody TaskDetails task) {
        taskService.patchTask(task);
        return ResponseEntity.ok("Task " + task.getId() + " has been patched.");
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDetails> getTask(String taskId) {
        return ResponseEntity.ok(taskService.getTask(UUID.fromString(taskId)));
    }

    @GetMapping("/{boardId}/tasks")
    public ResponseEntity<List<TaskDetails>> getBoardTasks(String boardId) {
        return ResponseEntity.ok(taskService.getBoardTasks(UUID.fromString(boardId)));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<String> deleteTask(String taskId) {
        taskService.deleteTask(UUID.fromString(taskId));
        return ResponseEntity.ok("Task " + taskId + " has been deleted.");
    }

}

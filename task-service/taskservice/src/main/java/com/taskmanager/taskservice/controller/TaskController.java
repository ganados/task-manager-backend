package com.taskmanager.taskservice.controller;

import com.taskmanager.model.Task;
import com.taskmanager.model.TaskDetails;
import com.taskmanager.taskservice.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    public final TaskService taskService;

    @PostMapping()
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        UUID id = taskService.createTask(task);
        return ResponseEntity.ok(id.toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDetails> getTask(String id) {
        return ResponseEntity.ok(taskService.getTask(UUID.fromString(id)));
    }
}

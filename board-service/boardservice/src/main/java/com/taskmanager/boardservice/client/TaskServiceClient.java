package com.taskmanager.boardservice.client;

import com.taskmanager.model.TaskDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "taskservice")
public interface TaskServiceClient {

    @GetMapping("/tasks")
    List<TaskDetails> getBoardTasks(@RequestParam String boardId);
}
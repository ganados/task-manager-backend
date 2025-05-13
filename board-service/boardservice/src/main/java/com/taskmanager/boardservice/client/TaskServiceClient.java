package com.taskmanager.boardservice.client;

import com.taskmanager.boardservice.configuration.feign.FeignClientConfiguration;
import com.taskmanager.model.TaskDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "task-service", configuration = FeignClientConfiguration.class)
public interface TaskServiceClient {

    @GetMapping("/tasks")
    List<TaskDetails> getBoardTasks(@RequestParam String boardId);
}
package com.taskmanager.boardservice.client;

import com.taskmanager.model.TaskDetails;
import com.taskmanager.model.UserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "userservice")
public interface UserServiceClient {

    @PostMapping("/users")
    List<UserDetails> getUsersDetails(@RequestBody List<String> userIds);
}
package com.taskmanager.taskservice.client;

import com.taskmanager.model.UserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userservice")
public interface UserServiceClient {

    @GetMapping("/users/{userId}")
    UserDetails getUserDetails(@PathVariable String userId);
}

// TODO: remove
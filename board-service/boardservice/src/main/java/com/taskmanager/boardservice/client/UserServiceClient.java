package com.taskmanager.boardservice.client;

import com.taskmanager.boardservice.configuration.feign.FeignClientConfiguration;
import com.taskmanager.model.UserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user-service", configuration = FeignClientConfiguration.class)
public interface UserServiceClient {

    @PostMapping("/users")
    List<UserDetails> getUsersDetails(@RequestBody List<String> userIds);
}
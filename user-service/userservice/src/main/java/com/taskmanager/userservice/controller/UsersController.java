package com.taskmanager.userservice.controller;

import com.taskmanager.model.UserDetails;
import com.taskmanager.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    public final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetails> getUserDetails(@PathVariable String userId) {
        UserDetails userDetails = userService.getUserDetails(userId);
        return ResponseEntity.ok(userDetails);
    }
}

package com.taskmanager.userservice.controller;

import com.taskmanager.model.UserDetails;
import com.taskmanager.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    public final UserService userService;

    @PostMapping
    public ResponseEntity<List<UserDetails>> getUsersDetails(@RequestBody List<String> userIds) {
        return ResponseEntity.ok(userService.getUsersDetails(userIds));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetails> getUserDetails(@PathVariable String userId) {
        UserDetails userDetails = userService.getUserDetails(userId);
        return ResponseEntity.ok(userDetails);
    }

}

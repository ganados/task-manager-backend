package com.taskmanager.userservice.controller;

import com.taskmanager.model.UserDetails;
import com.taskmanager.userservice.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    public final AdminService adminService;

    @GetMapping
    public ResponseEntity<List<UserDetails>> getUsers() {
        return ResponseEntity.ok(adminService.getUsers());
    }

}

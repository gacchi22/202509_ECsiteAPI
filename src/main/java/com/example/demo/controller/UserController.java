package com.example.demo.controller;

import com.example.demo.dto.request.UserRegisterRequest;
import com.example.demo.service.UserService;
import com.example.demo.dto.response.UserResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 新規ユーザー登録
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }
}

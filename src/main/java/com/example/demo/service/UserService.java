package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.UserRegisterRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.DuplicateUsernameException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    // 新規登録
    public UserResponse registerUser(UserRegisterRequest request) {

        // ユーザ名の重複チェック
        User existingUser = userRepository.findByUsername(request.getUsername()).orElse(null);

        if (existingUser != null) {
            throw new DuplicateUsernameException("このユーザー名は既に使われています。");
        }

        // DTO → EntityはMapStructを使用
        User user = userMapper.toEntity(request);

        // パスワードはMapStructに任せず、Serviceでエンコードする
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new IllegalArgumentException("password is required");
        }

        // 役割を補正（任意）
        if (!user.getRole().startsWith("ROLE_")) {
            user.setRole("ROLE_" + user.getRole());
        }

        // 保存
        User saved = userRepository.save(user);

        // Entity → ResponseもMapStruct
        return userMapper.toResponse(saved);
    }
}

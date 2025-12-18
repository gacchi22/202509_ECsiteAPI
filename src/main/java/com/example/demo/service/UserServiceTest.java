package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dto.request.UserRegisterRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entity.User;
import com.example.demo.exception.DuplicateUsernameException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("正常系: 新規ユーザを登録できる")
    void registerUser_success() {
        // ===== Given（前提条件） =====
        UserRegisterRequest request = new UserRegisterRequest(
                "testuser",
                "rawpass",
                "USER");

        User entityBeforeSave = new User();
        entityBeforeSave.setUsername("testuser");
        entityBeforeSave.setPassword("rawpass");
        entityBeforeSave.setRoles("USER");

        User savedEntity = new User();
        savedEntity.setId(1L);
        savedEntity.setUsername("testuser");
        savedEntity.setPassword("encodedpass");
        savedEntity.setRoles("ROLE_USER");

        UserResponse response = new UserResponse(1L, "testuser", "ROLE_USER");

        when(userRepository.findByUsername("testuser"))
                .thenReturn(Optional.empty());

        when(userMapper.toEntity(request))
                .thenReturn(entityBeforeSave);

        when(passwordEncoder.encode("rawpass"))
                .thenReturn("encodedpass");

        when(userRepository.save(any(User.class)))
                .thenReturn(savedEntity);

        when(userMapper.toResponse(savedEntity))
                .thenReturn(response);

        // ===== When（実行） =====
        UserResponse result = userService.registerUser(request);

        // ===== Then（検証） =====
        assertNotNull(result);
        assertEquals("testuser", result.getUsername());
        assertEquals("ROLE_USER", result.getRole());

        verify(userRepository).findByUsername("testuser");
        verify(passwordEncoder).encode("rawpass");
        verify(userRepository).save(any(User.class));
    }
}

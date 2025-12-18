package com.example.demo.controller;

import com.example.demo.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    // ログインAPI
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        try {
            String username = request.get("username");
            String password = request.get("password");

            // 認証処理（Spring Securityの機構を使用）
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            // UserDetailsの取得
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            // 認証成功時にJWTを生成
            String token = jwtUtil.generateToken(userDetails);

            return Map.of(
                    "message", "ログイン成功",
                    "token", token);

        } catch (AuthenticationException e) {
            throw new RuntimeException("認証に失敗しました。ユーザー名またはパスワードが無効です。");
        }
    }
}
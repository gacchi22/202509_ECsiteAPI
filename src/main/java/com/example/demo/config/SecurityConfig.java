package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.http.HttpMethod;
import com.example.demo.service.CustomUserDetailsService;

// 以下はいらないかも
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

        // JWTAuthenticationFilterはフィールドインジェクションに変更
        private final CustomUserDetailsService customUserDetailsService;
        private final JwtUtil jwtUtil;

        // コンストラクタインジェクション
        public SecurityConfig(CustomUserDetailsService customUserDetailsService, JwtUtil jwtUtil) {
                this.customUserDetailsService = customUserDetailsService;
                this.jwtUtil = jwtUtil;
        }

        // パスワードエンコーダー定義
        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        // AuthenticationProvider 定義
        @Bean
        public AuthenticationProvider authenticationProvider() {
                DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
                provider.setUserDetailsService(customUserDetailsService);
                provider.setPasswordEncoder(passwordEncoder());
                return provider;
        }

        // AuthenticationManager 定義
        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
                return config.getAuthenticationManager();
        }

        // JwtAuthenticationFilter をここで直接生成（依存解消）
        @Bean
        public JwtAuthenticationFilter jwtAuthenticationFilter() {
                return new JwtAuthenticationFilter(jwtUtil, customUserDetailsService);
        }

        // セキュリティ設定本体
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                // CSRFは無効化（API向け）
                                .csrf(csrf -> csrf.disable())

                                // セッションを使わずJWTのみ利用
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                                // 認証が不要なURLの指定
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers(
                                                                "/api/auth/login", // ログインAPIなど認証不要
                                                                "/api/users/register",
                                                                "/v3/api-docs/**", // Swaggerの設定
                                                                "/swagger-ui/**")
                                                .permitAll()

                                                // DELETEのみADMINに制限
                                                .requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")

                                                // 読み取り系（GET等）はUSERもOK
                                                .requestMatchers("/api/products/**").hasAnyRole("ADMIN", "USER")

                                                // 認証済みユーザーならOK
                                                .anyRequest().authenticated() // それ以外は認証が必要
                                )

                                // フォームログイン無効化（JWT利用のため）
                                .formLogin(form -> form.disable())
                                .httpBasic(basic -> basic.disable())

                                .authenticationProvider(authenticationProvider())

                                // JWTフィルターをSpring Securityの認証フィルターの前に差し込む
                                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

                return http.build();
        }
}

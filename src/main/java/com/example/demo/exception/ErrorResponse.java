package com.example.demo.exception;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    @Schema(description = "エラー発生日時", example = "2025-11-20T16:30:10.442")
    private LocalDateTime timestamp;

    @Schema(description = "HTTPステータスコード", example = "404")
    private int status;

    @Schema(description = "HTTPステータス名", example = "Not Found")
    private String error;

    @Schema(description = "詳細エラーメッセージ", example = "User not found: user123")
    private String message;

    @Schema(description = "リクエストパス", example = "/api/users/user123")
    private String path;
}

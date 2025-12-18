package com.example.demo.exception;

import java.time.LocalDateTime;
import java.util.DuplicateFormatFlagsException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // ---- 共通エラーレスポンス作成 ----
    private ResponseEntity<ErrorResponse> buildResponse(
            HttpStatus status,
            String message,
            HttpServletRequest request) {

        ErrorResponse error = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    // ==== 各種例外処理 ====

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {

        return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        String msgs = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return buildResponse(HttpStatus.BAD_REQUEST, msgs, request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(
            MethodArgumentTypeMismatchException ex,
            HttpServletRequest request) {

        String msg = "Invalid value for parameter '" + ex.getName() + "'";
        return buildResponse(HttpStatus.BAD_REQUEST, msg, request);
    }

    // ログイン失敗（BadCredentialsException）
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleCredentialsException(BadCredentialsException ex,
            HttpServletRequest request) {

        return buildResponse(HttpStatus.UNAUTHORIZED, "Invalid username or password", request);
    }

    // NullPointerException
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNpe(NullPointerException ex, HttpServletRequest request) {

        log.error("NPE at {}: {}", request.getRequestURI(), ex.getMessage(), ex);
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected null value", request);
    }

    // IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException ex,
            HttpServletRequest request) {

        return buildResponse(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
    }

    // JSON異常
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidJson(
            HttpMessageNotReadableException ex, HttpServletRequest request) {

        return buildResponse(HttpStatus.BAD_REQUEST, "Malformed JSON request", request);
    }

    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateUsername(DuplicateUsernameException ex,
            HttpServletRequest request) {
        return buildResponse(HttpStatus.CONFLICT, ex.getMessage(), request);
        // return ResponseEntity.status(HttpStatus.CONFLICT)
        // .body(Map.of(
        // "error", "Duplicate username",
        // "message", ex.getMessage()));
    }

    // その他
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        log.error("Unexpected error at {}: {}", request.getRequestURI(), ex.getMessage(), ex);
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", request);
    }

    // // バリデーションエラー
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<Map<String, Object>>
    // handleValidationException(MethodArgumentNotValidException ex) {

    // Map<String, Object> errors = new HashMap<>();
    // ex.getBindingResult().getFieldErrors().forEach(error -> {
    // errors.put(error.getField(), error.getDefaultMessage());
    // });

    // Map<String, Object> response = new HashMap<>();
    // response.put("status", 400);
    // response.put("error", "Validation Error");
    // response.put("details", errors);

    // return ResponseEntity.badRequest().body(response);
    // }

    // // リソースが見つからない
    // @ExceptionHandler(ResourceNotFoundException.class)
    // public ResponseEntity<Map<String, Object>>
    // handleNotFound(ResourceNotFoundException ex) {

    // Map<String, Object> response = new HashMap<>();
    // response.put("status", 404);
    // response.put("error", ex.getMessage());

    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    // }

    // // 予期しないエラー（最後の砦）
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<Map<String, Object>> handleException(Exception ex) {

    // Map<String, Object> response = new HashMap<>();
    // response.put("status", 500);
    // response.put("error", "Internal Server Error");
    // response.put("message", ex.getMessage());

    // return
    // ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    // }

    // 商品が見つからない場合
    // @ExceptionHandler(ProductNotFoundException.class)

    // public ResponseEntity<String> handleProductNotFound(ProductNotFoundException
    // ex) {
    // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    // }

    // // バリデーションエラーなど
    // @ExceptionHandler(IllegalArgumentException.class)
    // public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException
    // ex) {
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    // }

    // // そのほか予期せぬ例外
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<String> handleException(Exception ex) {
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("サーバーエラー:
    // " + ex.getMessage());
    // }

    // // ResourceNotFoundException
    // @ExceptionHandler(ResourceNotFoundException.class)
    // public ResponseEntity<Map<String, Object>>
    // handleNotFound(ResourceNotFoundException ex) {
    // return buildResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    // }

    // // バリデーションエラー
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<Map<String, Object>>
    // handleValidation(MethodArgumentNotValidException ex) {
    // String message = ex.getBindingResult().getFieldError().getDefaultMessage();
    // return buildResponse(HttpStatus.BAD_REQUEST, message);
    // }

    // // パラメータ変換エラー
    // @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    // public ResponseEntity<Map<String, Object>>
    // handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
    // String message = String.format("Invalid value for parameter '%s'",
    // ex.getName());
    // return buildResponse(HttpStatus.BAD_REQUEST, message);
    // }

    // // その他の予期しないエラー
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
    // return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server
    // error");
    // }

    // // 共通レスポンス生成
    // private ResponseEntity<Map<String, Object>> buildResponse(HttpStatus status,
    // String message) {
    // Map<String, Object> body = new HashMap<>();
    // body.put("status", status.value());
    // body.put("error", message);

    // return ResponseEntity.status(status).body(body);
    // }
}

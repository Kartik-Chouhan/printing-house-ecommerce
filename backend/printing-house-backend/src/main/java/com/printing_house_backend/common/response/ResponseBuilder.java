package com.printing_house_backend.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public final class ResponseBuilder {

    private ResponseBuilder() {
    }

    public static <T> ResponseEntity<ApiResponse<T>> success(String message,
                                                             T data) {

        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<ApiResponse<Void>> success(String message) {

        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .success(true)
                .message(message)
                .data(null)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.ok(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> created(String message,
                                                             T data) {

        ApiResponse<T> response = ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

}
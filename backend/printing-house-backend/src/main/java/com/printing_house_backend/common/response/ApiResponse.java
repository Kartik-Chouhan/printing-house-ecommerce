package com.printing_house_backend.common.response;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record ApiResponse<T>(
        boolean success,
        String message,
        T data,
        LocalDateTime timestamp
) {
}

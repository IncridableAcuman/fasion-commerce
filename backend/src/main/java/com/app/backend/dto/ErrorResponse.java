package com.app.backend.dto;

import java.time.LocalDateTime;

public record ErrorResponse(
        String error,
        String message,
        int status,
        String path,
        LocalDateTime timeStamp
) {
}

package com.sms.schoolmanagementsystem.config.exception;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CustomErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;

    public CustomErrorResponse(int status, String error, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.path = path;
    }
    
}

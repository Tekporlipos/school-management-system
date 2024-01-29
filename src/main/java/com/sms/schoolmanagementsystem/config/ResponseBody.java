package com.sms.schoolmanagementsystem.config;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseBody<T> {
    private LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private T data;
    private String message ;

    public ResponseBody(T data) {
        this.data = data;
    }
}

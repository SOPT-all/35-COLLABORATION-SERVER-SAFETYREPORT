package com.safetyreport.safetyreport.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto<T> {
    private String status;
    private String message;
    private T data;

    public ResponseDto(String status, String message, T data) {
        this.data = data;
        this.message = message;
        this.status = status;
    }
}

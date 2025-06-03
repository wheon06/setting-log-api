package com.wheon.settinglogapi.api.support;

import com.wheon.settinglogapi.api.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private String code;
    private String message;

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(ExceptionCode exceptionCode) {
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }
}
package com.wheon.settinglogapi.api.support;

import com.wheon.settinglogapi.api.exception.ExceptionCode;
import lombok.Getter;

@Getter
public class ErrorResponse {

    final String code;
    final String message;

    public ErrorResponse(final String code, final String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(final ExceptionCode exceptionCode) {
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }
}
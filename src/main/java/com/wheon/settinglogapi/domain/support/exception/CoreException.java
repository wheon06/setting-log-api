package com.wheon.settinglogapi.domain.support.exception;

import lombok.Getter;

@Getter
public class CoreException extends RuntimeException {

    private String code;
    private String message;

    public CoreException(ExceptionCode exceptionCode) {
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }

}

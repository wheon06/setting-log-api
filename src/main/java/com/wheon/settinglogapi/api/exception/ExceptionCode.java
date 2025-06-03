package com.wheon.settinglogapi.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    INVALID_REQUEST("E1001", "요청이 잘못되었습니다."),
    INVALID_HTTP_METHOD("E1002", "HTTP Method가 잘못되었습니다."),

    INTERNAL_SERVER_ERROR("E9999", "서버 오류입니다.");

    private final String code;
    private final String message;

}

package com.wheon.settinglogapi.domain.support.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    INVALID_REQUEST("E1001", "요청이 잘못되었습니다."),
    INVALID_HTTP_METHOD("E1002", "HTTP Method가 잘못되었습니다."),
    NOT_FOUND_REQUEST("E1003", "존재하지 않는 URL입니다."),

    DUPLICATED_CENTER_NAME("E2001", "중복된 센터 이름입니다."),

    INTERNAL_SERVER_ERROR("E9999", "서버 오류입니다.");

    private final String code;
    private final String message;

}

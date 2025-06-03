package com.wheon.settinglogapi.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    INVALID_REQUEST("E1001", "요청이 잘못 되었습니다.");

    private final String code;
    private final String message;

}

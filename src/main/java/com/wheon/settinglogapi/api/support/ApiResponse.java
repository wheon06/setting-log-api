package com.wheon.settinglogapi.api.support;

import com.wheon.settinglogapi.api.exception.ExceptionCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

    private final ResultType resultType;
    private final ExceptionCode error;
    private final T success;

    public static <T> ApiResponse<T> success(final T data) {
        return new ApiResponse<>(ResultType.SUCCESS, null, data);
    }

    public static <T> ApiResponse<T> error(final ExceptionCode exceptionCode) {
        return new ApiResponse<>(ResultType.ERROR, exceptionCode, null);
    }

}

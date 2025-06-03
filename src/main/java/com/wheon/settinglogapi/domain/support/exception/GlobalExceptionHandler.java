package com.wheon.settinglogapi.domain.support.exception;

import lombok.extern.slf4j.Slf4j;
import com.wheon.settinglogapi.api.support.ApiResponse;
import com.wheon.settinglogapi.api.support.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CoreException.class)
    public ApiResponse<ErrorResponse> handleCoreException(CoreException e) {
        log.warn(e.getMessage());
        return ApiResponse.error(new ErrorResponse(e.getCode(), e.getMessage()));
    }

    // @Valid 에서 검증이 실패되었을 때
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException e,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        log.warn(e.getMessage());

        String errorMessage = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return ResponseEntity.ok(ApiResponse.error(
                new ErrorResponse(ExceptionCode.INVALID_REQUEST.getCode(), errorMessage))
        );
    }

    // Post 요청에서 본문이 없을 때
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException e,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        log.warn(e.getMessage());
        return ResponseEntity.ok(ApiResponse.error(new ErrorResponse(ExceptionCode.INVALID_REQUEST)));
    }

    // 요청 HTTP 메서드 불일치 시
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException e,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        log.warn(e.getMessage());
        return ResponseEntity.ok(ApiResponse.error(new ErrorResponse(ExceptionCode.INVALID_HTTP_METHOD)));
    }

    @Override
    protected ResponseEntity<Object> handleNoResourceFoundException(
            NoResourceFoundException e,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        log.warn(e.getMessage());
        return ResponseEntity.ok(ApiResponse.error(new ErrorResponse(ExceptionCode.NOT_FOUND_REQUEST)));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception e,
            Object body,
            HttpHeaders headers,
            HttpStatusCode statusCode,
            WebRequest request
    ) {
        log.error(e.getMessage(), e);
        return ResponseEntity.ok(ApiResponse.error(new ErrorResponse(ExceptionCode.INTERNAL_SERVER_ERROR)));
    }
}

package com.wheon.settinglogapi.api.exception;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import com.wheon.settinglogapi.api.support.ApiResponse;
import com.wheon.settinglogapi.api.support.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.wheon.settinglogapi.api.exception.ExceptionCode.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // @Valid 에서 검증이 실패되었을 때
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException e,
            final HttpHeaders headers,
            final HttpStatusCode status,
            final WebRequest request
    ) {
        log.warn(e.getMessage());

        final String errorMessage = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return ResponseEntity.ok(ApiResponse.error(
                new ErrorResponse(INVALID_REQUEST.getCode(), errorMessage))
        );
    }

    // Post 요청에서 본문이 없을 때
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            final HttpMessageNotReadableException e,
            final HttpHeaders headers,
            final HttpStatusCode status,
            final WebRequest request
    ) {
        log.warn(e.getMessage());
        return ResponseEntity.ok(ApiResponse.error(new ErrorResponse(INVALID_REQUEST)));
    }

    // 요청 HTTP 메서드 불일치 시
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            final HttpRequestMethodNotSupportedException e,
            final HttpHeaders headers,
            final HttpStatusCode status,
            final WebRequest request
    ) {
        log.warn(e.getMessage());
        return ResponseEntity.ok(ApiResponse.error(new ErrorResponse(INVALID_HTTP_METHOD)));
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            final Exception e,
            final Object body,
            final HttpHeaders headers,
            final HttpStatusCode statusCode,
            final WebRequest request
    ) {
        log.error(e.getMessage(), e);
        return ResponseEntity.ok(ApiResponse.error(new ErrorResponse(INTERNAL_SERVER_ERROR)));
    }
}

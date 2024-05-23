package com.coin.portfolio.portfolio.ApiResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public ApiResponse<String> handleApiException(ApiException ex) {
        return new ApiResponse<>(ex.getStatusCode(), ex.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponse<String> handleException(Exception ex) {
        return new ApiResponse<>(500, ex.getMessage(), null);
    }
}

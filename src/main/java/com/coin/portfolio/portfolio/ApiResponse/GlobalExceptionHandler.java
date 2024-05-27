package com.coin.portfolio.portfolio.ApiResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.coin.portfolio.portfolio.Error.PortfolioExeption;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PortfolioExeption.class)
    public ApiResponse<String> handleApiException(PortfolioExeption ex) {
        return new ApiResponse<>(ex.getStatusCode(), ex.getMessage(), null);
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse<String> handleException(Exception ex) {
        return new ApiResponse<>(500, ex.getMessage(), null);
    }
}

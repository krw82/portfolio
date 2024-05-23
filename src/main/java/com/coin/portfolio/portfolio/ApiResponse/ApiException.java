package com.coin.portfolio.portfolio.ApiResponse;

public class ApiException extends RuntimeException {
    private int statusCode;

    public ApiException(int statusCode, String message) {
        // super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}

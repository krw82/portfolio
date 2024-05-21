package com.coin.portfolio.portfolio.Error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND("PORT_001", "유저가 없습니다."),
    INVALID_PASSWORD("PORT_002", "Invalid password"),
    USERNAME_ALREADY_EXISTS("PORT_003", "Username already exists");

    private final String errCode;
    private final String message;

    ErrorCode(String errCode, String message) {
        this.message = message;
        this.errCode = errCode;
    }

}

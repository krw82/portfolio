package com.coin.portfolio.portfolio.Error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND("유저가 없습니다."),
    INVALID_PASSWORD("Invalid password"),
    USERNAME_ALREADY_EXISTS("Username already exists");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

}

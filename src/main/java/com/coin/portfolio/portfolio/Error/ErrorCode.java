package com.coin.portfolio.portfolio.Error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND(404, "유저가 없습니다."),
    INVALID_PASSWORD(406, "Invalid password"),
    USERNAME_ALREADY_EXISTS(400, "Username already exists");

    private final int errCode;
    private final String message;

    ErrorCode(int errCode, String message) {
        this.message = message;
        this.errCode = errCode;
    }

}

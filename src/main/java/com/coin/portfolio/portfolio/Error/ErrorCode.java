package com.coin.portfolio.portfolio.Error;

import lombok.Getter;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND(404, "유저가 없습니다."),
    INVALID_PASSWORD(406, "Invalid password"),
    USERNAME_ALREADY_EXISTS(400, "Username already exists"),
    NO_DATA_TABLE(404, "데이터가 존재하지않습니다.");

    private final int errCode;
    private final String message;

    ErrorCode(int errCode, String message) {
        this.message = message;
        this.errCode = errCode;
    }

}

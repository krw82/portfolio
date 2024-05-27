package com.coin.portfolio.portfolio.Error;

public class PortfolioExeption extends RuntimeException {

    private final ErrorCode errorCode;

    public PortfolioExeption(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public int getStatusCode() {
        return errorCode.getErrCode();
    }
}

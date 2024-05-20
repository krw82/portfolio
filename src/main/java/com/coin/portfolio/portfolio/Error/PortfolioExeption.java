package com.coin.portfolio.portfolio.Error;

public class PortfolioExeption extends RuntimeException {

    public PortfolioExeption(ErrorCode errorCode) {
        super(errorCode.getMessage());
    }

}

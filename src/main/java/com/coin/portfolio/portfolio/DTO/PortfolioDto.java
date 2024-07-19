package com.coin.portfolio.portfolio.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioDto {
    private Long id;
    private Long count;
    private Long flatPrice;
    private String assetSymbol;
    private String userId;
}

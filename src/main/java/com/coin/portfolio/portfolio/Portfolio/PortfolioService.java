package com.coin.portfolio.portfolio.Portfolio;

import java.util.List;

public interface PortfolioService {
    Portfolio createPortfolio(Portfolio portfolio);

    Portfolio getPortfolioById(Long id);

    List<Portfolio> getUserPortfolios(String id);

    void updatePortfolio(Long id, Portfolio portfolioDetails);

    void deletePortfolio(Long id);

    Portfolio optimizeAssetAllocation(String id);
}

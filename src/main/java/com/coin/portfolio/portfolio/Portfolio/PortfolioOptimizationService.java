package com.coin.portfolio.portfolio.Portfolio;

import java.util.List;

import com.coin.portfolio.portfolio.Entity.Portfolio;

public interface PortfolioOptimizationService {
    Portfolio optimizeAssetAllocation(List<Portfolio> portfolio);
}

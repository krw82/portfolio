package com.coin.portfolio.portfolio.Portfolio;

import java.util.List;

public interface PortfolioOptimizationService {
    Portfolio optimizeAssetAllocation(List<Portfolio> portfolio);
}

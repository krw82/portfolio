package com.coin.portfolio.portfolio.Portfolio.Impl;

import java.util.List;

import com.coin.portfolio.portfolio.Entity.Portfolio;
import com.coin.portfolio.portfolio.Portfolio.PortfolioOptimizationService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PortfolioOptimizationServiceImpl implements PortfolioOptimizationService {

    @Override
    public Portfolio optimizeAssetAllocation(List<Portfolio> portfolio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'optimizeAssetAllocation'");
    }

}

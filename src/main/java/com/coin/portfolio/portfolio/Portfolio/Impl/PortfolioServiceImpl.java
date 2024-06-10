package com.coin.portfolio.portfolio.Portfolio.Impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.Portfolio.Portfolio;
import com.coin.portfolio.portfolio.Portfolio.PortfolioOptimizationService;
import com.coin.portfolio.portfolio.Portfolio.PortfolioRepository;
import com.coin.portfolio.portfolio.Portfolio.PortfolioService;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final PortfolioOptimizationService portfolioOptimizationService;

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElseThrow(() -> new PortfolioExeption(ErrorCode.NO_DATA_TABLE));
    }

    @Override
    public List<Portfolio> getUserPortfolios(String User) {
        throw new PortfolioExeption(ErrorCode.NO_DATA_TABLE);
        // return portfolioRepository.findByUser(User);
    }

    @Override
    public void updatePortfolio(Long id, Portfolio portfolioDetails) {
        Portfolio portfolio = this.getPortfolioById(id);
        portfolio.setCount(portfolioDetails.getCount());
        portfolio.setName(portfolioDetails.getName());
        portfolioRepository.save(portfolio);
    }

    @Override
    public void deletePortfolio(Long id) {
        Portfolio portfolio = this.getPortfolioById(id);
        portfolioRepository.delete(portfolio);
    }

    @Override
    public Portfolio optimizeAssetAllocation(String User) {
        List<Portfolio> portfolios = this.getUserPortfolios(User);
        return portfolioOptimizationService.optimizeAssetAllocation(portfolios);
    }

}

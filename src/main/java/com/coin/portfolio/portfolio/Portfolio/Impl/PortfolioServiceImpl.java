package com.coin.portfolio.portfolio.Portfolio.Impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.coin.portfolio.portfolio.Error.ErrorCode;
import com.coin.portfolio.portfolio.Error.PortfolioExeption;
import com.coin.portfolio.portfolio.Portfolio.Portfolio;
import com.coin.portfolio.portfolio.Portfolio.PortfolioRepository;
import com.coin.portfolio.portfolio.Portfolio.PortfolioService;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioRepository portfolioRepository;

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio getPortfolioById(Long id) {
        return portfolioRepository.findById(id).orElseThrow(() -> new PortfolioExeption(ErrorCode.NO_DATA_TABLE));
    }

    @Override
    public List<Portfolio> getUserPortfolios(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPortfolios'");
    }

    @Override
    public Portfolio updatePortfolio(Long id, Portfolio portfolioDetails) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePortfolio'");
    }

    @Override
    public void deletePortfolio(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePortfolio'");
    }

    @Override
    public void optimizeAssetAllocation(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'optimizeAssetAllocation'");
    }

}

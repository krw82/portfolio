package com.coin.portfolio.portfolio.Portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coin.portfolio.portfolio.Entity.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    // List<Portfolio> findByUser(String user);
}

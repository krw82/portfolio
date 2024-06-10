package com.coin.portfolio.portfolio.Portfolio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    // List<Portfolio> findByUser(String user);
}

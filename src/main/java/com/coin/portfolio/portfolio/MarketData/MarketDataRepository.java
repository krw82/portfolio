package com.coin.portfolio.portfolio.MarketData;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketDataRepository extends JpaRepository<MarketData, Long> {
    List<MarketData> findByTicker(String ticker);
}

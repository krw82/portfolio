package com.coin.portfolio.portfolio.MarketData;

import java.util.List;

public interface MarketDataService {
    MarketData insertMarketData(MarketData marketData);

    List<MarketData> getMarketDataByTicker(String ticker);
}

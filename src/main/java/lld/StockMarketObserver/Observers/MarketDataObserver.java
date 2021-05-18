package lld.StockMarketObserver.Observers;

import lld.StockMarketObserver.MarketData;

public interface MarketDataObserver {
    void handleMarketData(MarketData marketData);
}

package lld.StockMarketObserver.Observables;

import lld.StockMarketObserver.MarketData;
import lld.StockMarketObserver.Observers.MarketDataObserver;

public interface MarketDataObservable {
    void subscribe(MarketDataObserver marketDataObserver);
    void handleMarketData(MarketData marketData);
    void unsubscribe(MarketDataObserver marketDataObserver);
}

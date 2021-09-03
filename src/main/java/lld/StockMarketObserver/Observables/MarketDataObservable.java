package lld.StockMarketObserver.Observables;

import lld.StockMarketObserver.MarketData;
import lld.StockMarketObserver.Observers.MarketDataObserver;

public interface MarketDataObservable {
    void subscribe(MarketDataObserver marketDataObserver);
    void publishMarketData(MarketData marketData);
    void unsubscribe(MarketDataObserver marketDataObserver);
}

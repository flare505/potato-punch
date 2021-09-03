package lld.StockMarketObserver;

import lld.StockMarketObserver.Observables.StockMarketPublisher;
import lld.StockMarketObserver.Observers.LatestTradePriceObserver;
import lld.StockMarketObserver.Observers.MarketDataObserver;
import lld.StockMarketObserver.Observers.PercentChangeObserver;

public class App {

    // Medium blog:: https://medium.com/swlh/observer-design-pattern-explained-in-five-minutes-c01113666318

    public static void main(String[] args) {
        MarketDataObserver latestTradePriceObserver = new LatestTradePriceObserver();
        MarketDataObserver percentChangeObserver = new PercentChangeObserver();

        //subscribe observers before handling market data
        StockMarketPublisher stockMarketPublisher = new StockMarketPublisher();
        stockMarketPublisher.subscribe(latestTradePriceObserver);
        stockMarketPublisher.subscribe(percentChangeObserver);

        stockMarketPublisher.publishMarketData(new MarketData("SBIN", 20.3, 100));

        // unsubscribe observers
        stockMarketPublisher.unsubscribe(percentChangeObserver);
        stockMarketPublisher.publishMarketData(new MarketData("SBIN", 20.5, 100));
    }
}

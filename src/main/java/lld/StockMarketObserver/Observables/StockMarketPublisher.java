package lld.StockMarketObserver.Observables;

import lld.StockMarketObserver.MarketData;
import lld.StockMarketObserver.Observers.MarketDataObserver;

import java.util.ArrayList;
import java.util.List;

public class StockMarketPublisher implements MarketDataObservable{
    private List<MarketDataObserver> subscriptions = new ArrayList<>();

    @Override
    public void subscribe(MarketDataObserver marketDataObserver) {
        this.subscriptions.add(marketDataObserver);
        System.out.println("Subscribed class:: " + marketDataObserver.getClass().getSimpleName());
    }

    @Override
    public void handleMarketData(MarketData marketData) {
        this.subscriptions.forEach(marketDataObserver -> {
            marketDataObserver.handleMarketData(marketData);
        });
    }

    @Override
    public void unsubscribe(MarketDataObserver marketDataObserver) {
        if(subscriptions.contains(marketDataObserver)) {
            this.subscriptions.remove(marketDataObserver);
            System.out.println("Unsubscribed class:: " + marketDataObserver.getClass().getSimpleName());
        }
    }
}

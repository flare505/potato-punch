package lld.StockMarketObserver.Observers;

import lld.StockMarketObserver.MarketData;

public class PercentChangeObserver implements MarketDataObserver {
    private double previousClose = 20;

    @Override
    public void handleMarketData(MarketData marketData) {
        //System.out.println(marketData.getSymbol() + " ::Pclose:: " + this.previousClose);
        System.out.println(marketData.getSymbol() + " ::CHNG:: " + (marketData.getLastPrice() - previousClose) / previousClose * 100);
        this.previousClose = marketData.getLastPrice();
    }
}


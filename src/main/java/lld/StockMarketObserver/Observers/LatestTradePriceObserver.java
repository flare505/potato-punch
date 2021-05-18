package lld.StockMarketObserver.Observers;

import lld.StockMarketObserver.MarketData;
import lld.StockMarketObserver.Observers.MarketDataObserver;

public class LatestTradePriceObserver implements MarketDataObserver {

    @Override
    public void handleMarketData(MarketData marketData) {
        System.out.println(marketData.getSymbol() + " ::LTP:: " + marketData.getLastPrice());
    }
}

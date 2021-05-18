package lld.StockMarketObserver;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MarketData {
    private String symbol;
    private double lastPrice;
    private int quantity;
}

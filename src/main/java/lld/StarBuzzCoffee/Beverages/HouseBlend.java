package lld.StarBuzzCoffee.Beverages;

import lld.StarBuzzCoffee.Beverages.Beverage;
import lombok.Data;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "house-blend";
    }

    @Override
    public double cost() {
        return 1.09;
    }
}

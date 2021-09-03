package lld.StarBuzzCoffee.Decorators;

import lld.StarBuzzCoffee.Beverages.Beverage;

public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " and whip";
    }

    @Override
    public double cost() {
        return beverage.cost() + .15;
    }
}

package lld.StarBuzzCoffee.Decorators;

import lld.StarBuzzCoffee.Beverages.Beverage;

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " and mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + .22;
    }
}

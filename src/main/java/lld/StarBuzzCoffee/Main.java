package lld.StarBuzzCoffee;

import lld.StarBuzzCoffee.Beverages.Beverage;
import lld.StarBuzzCoffee.Beverages.Espresso;
import lld.StarBuzzCoffee.Decorators.Mocha;
import lld.StarBuzzCoffee.Decorators.Whip;

public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);

        System.out.println(beverage.getDescription() + " -> cost:: " + beverage.cost());
    }
}

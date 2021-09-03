package lld.StarBuzzCoffee.Beverages;

public class Espresso extends Beverage {
    public Espresso() {
        this.setDescription("espresso");
    }

    @Override
    public double cost() {
        return 0.99;
    }
}

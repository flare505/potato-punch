package lld.StarBuzzCoffee.Beverages;

public abstract class Beverage {
    String description = "unknown bevarage";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double cost();
}

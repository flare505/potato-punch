package lld.VendingMachine;

import lld.VendingMachine.States.Ready;
import lld.VendingMachine.States.State;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    private State state;
    private int collectedCash;
    private Map<String, Item> catalog;

    VendingMachine() {
        this.state = new Ready(this);
        this.collectedCash = 0;
        this.catalog = new HashMap<>();
        catalog.put("101", new Item("101", "Munch nuts", 30));
        catalog.put("102", new Item("102", "Mars Bar", 60));
        catalog.put("103", new Item("103", "Raw Pressyr", 70));
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

    public void addCollectedCash(int cash) {
        collectedCash += cash;
    }

    public void dispenseChange(Item item) {

    }

    public void dispenseItem(Item item) {
        if (collectedCash >= item.price) {
            System.out.println("dispensing Item :: " + item.name);
        }
    }

}

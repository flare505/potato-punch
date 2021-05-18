package lld.VendingMachine.States;

import lld.VendingMachine.Item;
import lld.VendingMachine.VendingMachine;

public class Cancelled implements State {

    private VendingMachine vendingMachine;

    public Cancelled(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {

    }

    @Override
    public void dispenseChange(String itemId) {

    }

    @Override
    public void dispenseItem(String itemId) {

    }

    @Override
    public void cancelTransaction() {

    }
}

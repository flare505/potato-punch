package lld.VendingMachine.States;

import lld.VendingMachine.Item;
import lld.VendingMachine.VendingMachine;

public class CashCollected implements State {
    private VendingMachine vendingMachine;

    public CashCollected(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        throw new RuntimeException("Exception");
    }

    @Override
    public void dispenseChange(String itemId) {
        throw new RuntimeException("Exception");
    }

    @Override
    public void dispenseItem(String itemId) {
        throw new RuntimeException("Exception");
    }

    @Override
    public void cancelTransaction() {
        throw new RuntimeException("Exception");
    }
}

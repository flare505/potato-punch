package lld.VendingMachine.States;

import lld.VendingMachine.Item;
import lld.VendingMachine.VendingMachine;

public class Ready implements State {
    private VendingMachine vendingMachine;

    public Ready(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void collectCash(int cash) {
        this.vendingMachine.addCollectedCash(cash);
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

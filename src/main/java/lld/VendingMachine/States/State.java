package lld.VendingMachine.States;

import lld.VendingMachine.Item;

public interface State {
    void collectCash(int cash);
    void dispenseChange(String itemId);
    void dispenseItem(String itemId);
    void cancelTransaction();
}

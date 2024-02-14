package lld.VendingMachine.States;

public interface State {
    void collectCash(int cash);
    void dispenseChange(String itemId);
    void dispenseItem(String itemId);
    void cancelTransaction();
}

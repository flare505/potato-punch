package splitWiseLLD.Commands;

import splitWiseLLD.manager.ExpenseManager;

public interface ICommand {
    boolean validate(String[] params);
    void execute(ExpenseManager expenseManager);
}

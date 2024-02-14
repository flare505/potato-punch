package splitWiseLLD.Commands;

import lombok.NoArgsConstructor;
import splitWiseLLD.manager.ExpenseManager;

@NoArgsConstructor
public class ShowCommand implements ICommand {
    private String userId;

    @Override
    public boolean validate(String[] params) {
        if (params.length != 1) {
            this.userId = params[1];
        }
        return true;
    }

    @Override
    public void execute(ExpenseManager expenseManager) {
        if (this.userId == null) {
            expenseManager.showAllExpenses();
        } else {
            expenseManager.showExpenseByUser(userId);
        }
    }
}

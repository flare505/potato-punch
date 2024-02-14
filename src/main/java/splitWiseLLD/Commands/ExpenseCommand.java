package splitWiseLLD.Commands;

import lombok.NoArgsConstructor;
import splitWiseLLD.manager.ExpenseManager;
import splitWiseLLD.model.SplitType;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ExpenseCommand implements ICommand {
    private String createdBy;
    private Integer totalAmount;
    private List<String> usersInvoled;
    private List<Integer> individualAmounts;
    private SplitType splitType;

    @Override
    public boolean validate(String[] params) {
        this.createdBy = params[1];
        this.totalAmount = Integer.parseInt(params[2]);
        int n = Integer.parseInt(params[3]);
        this.usersInvoled = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            usersInvoled.add(params[4 + i]);
        }
        switch (params[5 + n - 1]) {
            case "EQUAL" : this.splitType = SplitType.EQUAL;
            break;
            case "EXACT" : this.splitType = SplitType.EXACT;
            break;
            case "PERCENT" : this.splitType = SplitType.PERCENT;
            break;
        }
        return true;
    }

    @Override
    public void execute(ExpenseManager expenseManager) {
        expenseManager.createExpense(this.splitType, this.createdBy, this.totalAmount, this.usersInvoled, this.individualAmounts);
    }
}

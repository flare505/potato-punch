package splitWiseLLD.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class User {
    private String userId;
    private List<Expense> expenses;

    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }
}

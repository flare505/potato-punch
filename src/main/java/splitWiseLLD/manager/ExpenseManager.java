package splitWiseLLD.manager;

import splitWiseLLD.SplitStrategies.EqualSplitStrategy;
import splitWiseLLD.SplitStrategies.ExactSplitStrategy;
import splitWiseLLD.SplitStrategies.ISplitStrategy;
import splitWiseLLD.SplitStrategies.PercentSplitStrategy;
import splitWiseLLD.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class ExpenseManager {

    UserManager userManager;
    Map<String, Expense> expenseMap;
    ISplitStrategy splitStrategy;

    public ExpenseManager(UserManager userManager) {
        this.userManager = userManager;
        this.expenseMap = new HashMap<>();
    }

    public void createExpense(SplitType splitType, String createdBy, Integer amount, List<String> userIds, List<Integer> amounts) {
        if (splitType.name().equalsIgnoreCase("EXACT")) {
            splitStrategy = new ExactSplitStrategy();
        } else if (splitType.name().equalsIgnoreCase("EQUAL")) {
            splitStrategy = new EqualSplitStrategy();
        } else if (splitType.name().equalsIgnoreCase("PERCENT")) {
            splitStrategy = new PercentSplitStrategy();
        }

        Expense expense = Expense.builder()
                .expenseId(UUID.randomUUID())
                .totalAmount(amount)
                .createdBy(createdBy)
                .splits(splitStrategy.createSplits(createdBy, amount, userIds, amounts))
                .build();

        userManager.getUser(createdBy).addExpense(expense);
        for (String id : userIds) {
            if (id.equalsIgnoreCase(createdBy)) {
                continue;
            }
            userManager.getUser(id).addExpense(expense);
        }

        System.out.println(expense);
        expenseMap.put(expense.getExpenseId().toString(), expense);
    }

    public int settleExpenseByUser(String userId, String expenseId) {
        User user = userManager.getUser(userId);
        Expense expense = user.getExpenses().stream().filter(expenseVal -> expenseVal.getExpenseId().equals(expenseId)).findFirst().orElse(null);
        List<Split> splits = expense.getSplits().stream().filter(split -> {
            return (split.getFrom().equalsIgnoreCase(userId) && Integer.parseInt(split.getValue()) > 0 ) || (split.getTo().equalsIgnoreCase(userId) && Integer.parseInt(split.getValue()) < 0 ) && split.getSplitStatus().equals(SplitStatus.pending);
        }).collect(Collectors.toList());
        splits.forEach(split -> {split.setSplitStatus(SplitStatus.settled);});
        return splits.stream().mapToInt(split -> Integer.parseInt(split.getValue())).sum();
    }

    public void showAllExpenses() {
        Map<String, String[]> response = new HashMap<>();
        for (Map.Entry<String, Expense> entry : expenseMap.entrySet()) {
            Expense expense = entry.getValue();
            List<Split> splits = expense.getSplits().stream().filter(split -> SplitStatus.pending.equals(split.getSplitStatus())).collect(Collectors.toList());
            for(Split split : splits) {
                response.put(split.getFrom(), new String[] {split.getTo(), split.getValue()});
            }
        }
        if (response.size() == 0) {
            System.out.println("No Expense");
        } else {
            for (Map.Entry<String, String[]> entry : response.entrySet()) {
                if (Integer.parseInt(entry.getValue()[1]) > 0) {
                    System.out.printf("USER %s owes USER %s amount %s\n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
                } else if (Integer.parseInt(entry.getValue()[1]) < 0) {
                    System.out.printf("USER %s owes USER %s amount %s\n", entry.getValue()[0], entry.getKey(), String.valueOf(-1*Integer.parseInt(entry.getValue()[1])));
                }
            }
        }
    }

    public void showExpenseByUser(String userId) {
        Map<String, String[]> response = new HashMap<>();
        for (Expense expense : userManager.getUser(userId).getExpenses()) {
            List<Split> splits = expense.getSplits().stream().filter(split -> {
            return (split.getFrom().equalsIgnoreCase(userId) && Integer.parseInt(split.getValue()) > 0 ) || (split.getTo().equalsIgnoreCase(userId) && Integer.parseInt(split.getValue()) < 0 ) && split.getSplitStatus().equals(SplitStatus.pending);
        }).collect(Collectors.toList());

            for(Split split : splits) {
                if (response.get(split.getFrom()) != null) {
                    String[] val = response.get(split.getFrom());
                    val[1] += split.getValue();
                    response.put(split.getFrom(), new String[] {split.getTo(), split.getValue()});
                } else {
                    response.put(split.getFrom(), new String[] {split.getTo(), split.getValue()});
                }
            }
        }

        if (response.size() == 0) {
            System.out.println("No Expense");
        }
        else {
            for (Map.Entry<String, String[]> entry : response.entrySet()) {
                if (Integer.parseInt(entry.getValue()[1]) > 0) {
                    System.out.printf("USER %s owes USER %s amount %s\n", entry.getKey(), entry.getValue()[0], entry.getValue()[1]);
                } else if (Integer.parseInt(entry.getValue()[1]) < 0) {
                    System.out.printf("USER %s owes USER %s amount %s\n", entry.getValue()[0], entry.getKey(), String.valueOf(-1*Integer.parseInt(entry.getValue()[1])));
                }
            }
        }

    }
}

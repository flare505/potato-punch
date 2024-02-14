package splitWiseLLD.Commands;

public class CommandFactory {
    public static ICommand getInstance(String[] params) {
        switch (params[0]) {
            case "SHOW" : return new ShowCommand();
            case "EXPENSE" : return new ExpenseCommand();
            default: return null;
        }
    }
}

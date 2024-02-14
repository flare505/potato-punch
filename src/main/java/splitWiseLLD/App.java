package splitWiseLLD;

import splitWiseLLD.Commands.CommandFactory;
import splitWiseLLD.Commands.ICommand;
import splitWiseLLD.manager.ExpenseManager;
import splitWiseLLD.manager.UserManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        userManager.createUser("u1");
        userManager.createUser("u2");
        userManager.createUser("u3");
        userManager.createUser("u4");
        userManager.createUser("u5");

        ExpenseManager expenseManager = new ExpenseManager(userManager);

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/splitWiseLLD/input.txt"));
            String input = br.readLine();
            while (input != null) {
                System.out.println(input);
                String[] params = input.split(" ");
                ICommand command = CommandFactory.getInstance(params);
                if (command != null && command.validate(params)) {
                    command.execute(expenseManager);
                }
                input = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

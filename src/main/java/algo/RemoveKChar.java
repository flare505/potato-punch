package algo;
import java.util.Stack;

public class RemoveKChar {
    public static void main(String[] args) {
        String str = "jackie";
        char[] strChars = str.toCharArray();
        int k = 2;

        Stack<Character> stack = new Stack<>();
        stack.push(strChars[0]);

        for (int i = 1; i < strChars.length; i++) {
            if (k == 0) {
                stack.push(strChars[i]);
                continue;
            }
            while (k != 0 && Character.compare(strChars[i], stack.peek()) > 0) {
                stack.pop();
                k--;
            }
            stack.push(strChars[i]);
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        System.out.println(ans.reverse());
    }
}

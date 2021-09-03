package algo;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given string str of length N and an integer K, the task is to return the largest string in Dictionary Order by erasing K characters from that string.
 */
public class RemoveKChar {
    public static void main(String[] args) {
        String str = "dcba";
        char[] strChars = str.toCharArray();
        int k = 2;
        int substrLength = str.length() - k;

        Deque<Character> stack = new ArrayDeque<>(str.length() - k); // numelement in deque is just declaration, not initialization
        stack.push(strChars[0]);

        for (int i = 1; i < strChars.length; i++) {
            System.out.println(stack.toString());
            if (k == 0) {
                stack.push(strChars[i]);
                continue;
            }
            // condition of empty stack, otherwise fails for "abcd"
            while (k != 0 && !stack.isEmpty() && strChars[i] > stack.peek()) {
                stack.pop();
                k--;
            }
            // condition of sized stack, otherwise fails for "dcba"
            if (stack.size() != substrLength) {
                stack.push(strChars[i]);
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        System.out.println(ans.reverse());
    }
}

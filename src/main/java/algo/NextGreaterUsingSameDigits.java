package algo;


import java.util.Arrays;

//Given a number n, find the smallest number that has same set of digits as n and is greater than n. If n is the greatest possible number with its set of digits, then print “not possible”.
//
//        Examples:
//        For simplicity of implementation, we have considered input number as a string.
//
//        Input:  n = "218765"
//        Output: "251678"
//
//        Input:  n = "1234"
//        Output: "1243"
//
//        Input: n = "4321"
//        Output: "Not Possible"
//
//        Input: n = "534976"
//        Output: "536479"

public class NextGreaterUsingSameDigits {
    private static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    public static void findNextGreater(String num) {
        char[] digits = num.toCharArray();

        int i;
        for(i = digits.length - 1; i > 0; i--) {
            if (digits[i] > digits[i-1]) {
                break;
            }
        }

        if (i == 0) {
            System.out.println("not possible");
        }
        else {
            System.out.println(i);
            System.out.println("===");
            swap(digits, i - 1, digits.length - 1);
            Arrays.sort(digits, i, digits.length - 1);
            System.out.println(digits);
        }
    }

    public static void main(String[] args) {
        String num = "218765";
        findNextGreater(num);
    }
}

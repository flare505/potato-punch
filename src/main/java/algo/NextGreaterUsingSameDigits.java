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

    public static void findNextGreater(String num) {
//        List<Integer> digits = Arrays.stream(num.split("")).map(Integer::parseInt).collect(Collectors.toList());
        //TODO try to use list and java 8 functional programming to achieve this

        char[] digits = num.toCharArray();
        int i;
        for(i = digits.length - 1; i > 0; i--) {
            if (digits[i] > digits[i-1]) {
                break;
            }
        }
        System.out.println(i + "\n=====");
        if (i == 0) {
            System.out.println("NP");
        }
        else {
            int j = i;
            for (int k = i; k < digits.length; k++) {
                if (digits[i-1] < digits[k]) {
                    j = digits[j] < digits[k] ? j : k;
                }
            }
            swap(digits, i-1, j);
            Arrays.sort(digits, i, digits.length);
            System.out.println(String.valueOf(digits));
        }
    }

    private static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    public static void main(String[] args) {
        String num = "218765";
        findNextGreater(num);
    }
}

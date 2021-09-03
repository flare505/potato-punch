package algo;

public class AllPermutations {
    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    static String reset;

    public static void printAllPermutations(char[] str, int i, int j) {
//        str = reset.toCharArray();
//        if (i == str.length) {
//            return;
//        }
//        else if (j == str.length) {
//            j = i + 1;
//            i++;
//        }
//        swap(str, i, j);
//        System.out.println(str);
//        printAllPermutations(str, i, j + 1);
        //FIXME
    }

    public static void main(String[] args) {
        String str = "ABC";
        reset = str;
        printAllPermutations(str.toCharArray(), 0, str.length() - 1);
    }
}

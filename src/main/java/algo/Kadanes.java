package algo;

public class Kadanes {

    public static void main(String[] args) {
        //int[] arr = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        //int[] arr = new int[] {1, 2, 3, 4};
        int[] arr = new int[] {-1, -2, -3, -4};

        int maxSoFar = Integer.MIN_VALUE; // answer
        int sum = 0;
        for (int i : arr) {
            sum += i;
            maxSoFar = Integer.max(sum, maxSoFar);
            sum = Integer.max(sum, 0);
        }

        System.out.println(maxSoFar);
    }
}

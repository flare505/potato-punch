
package algo;

public class AlternatingSum {
    public static void main(String[] args) {

        //int[] arr = {3, -1, 1, 2};
        //int[] arr = {2, 2, 2, 2, 2};
        //int[] arr = {-1};
        int[] arr = {-2, -2, -3};

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxSoFar = Integer.MIN_VALUE;
        boolean flag = true;

        for (int i = 0; i < arr.length; i++) {
            if (flag) {
                currentSum += arr[i];
            } else {
                currentSum -= arr[i];
            }
            flag = !flag;
            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            } else {
                flag = true;
                currentSum = 0;
                maxSoFar = Integer.MIN_VALUE;
            }
            maxSum = Math.max(maxSum, maxSoFar);
        }

        System.out.println(maxSum);
    }


}

package algo;

import java.util.Arrays;

public class Play {
//    public int findPeakElement(int[] nums) {
////        int low = 0;
////        int high = nums.length - 1;
////        while(low <= high) {
////            int mid = (low + high) / 2;
////            long i = mid == 0 ? Long.MIN_VALUE : nums[mid - 1];
////            long j = nums[mid];
////            long k = mid == nums.length - 1? Long.MIN_VALUE : nums[mid + 1];
////            if (j > i && j > k) {
////                return mid;
////            }
////            else if (j > i) {
////                low = mid + 1;
////            }
////            else {
////                high = mid - 1;
////            }
////        }
////        return nums[low];
////    }

    public static boolean predicate(int[] piles, int mid, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil(pile / (double) mid);
        }
        System.out.println("hrs:: " + hours);
        return hours <= h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("mid:: " + mid);
            if (predicate(piles, mid, h)) {
                ans = Integer.min(ans, mid);
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] piles = new int[] {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
}

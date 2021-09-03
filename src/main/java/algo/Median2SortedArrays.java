package algo;

// note for equal sizes simply, sort individually and swap to have all small half in first and large half in second,
// then sort individually again to return last of first and first of second array by 2
public class Median2SortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int low = 0;
        int high = n;
        while (low <= high) {
            int amid = (low + high) / 2;
            int amidVal = nums1[amid];

            int bmid = Integer.max(0, (n + m) / 2 - (amid + 1));
            int bmidVal = nums2[bmid];
            int bmidPlus1Val = bmid >= m-1 ? Integer.MAX_VALUE : nums2[bmid + 1];
            System.out.println(amid + " -> " + bmid);

            if (amidVal >= bmidVal && amidVal <= bmidPlus1Val) {
                if ((n + m) % 2 == 0) {
                    return (amidVal + bmidVal) / 2.0;
                } else {
                    return amidVal;
                }
            }
            else if (amidVal >= bmidVal && amidVal >= bmidPlus1Val) {
                high = amid;
            }
            else {
                low = amid + 1;
            }
        }
        return 0;
    }

    public static double findMedianSortedArraysUtil(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n >= m) {
            return findMedianSortedArrays(nums1, nums2);
        } else {
            return findMedianSortedArrays(nums2, nums1);
        }
    }


    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,4};
        int[] nums2 = new int[] {5,6,7};

        int[] nums3 = new int[] {1,3,5,7};
        int[] nums4 = new int[] {2,4,6};

        System.out.println(findMedianSortedArraysUtil(nums1, nums2));
    }
}

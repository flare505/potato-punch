package algo;

import java.util.*;

public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);
                map.putIfAbsent(nums[i] + nums[j], new ArrayList<>());
                map.get(nums[i] + nums[j]).add(pair);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<List<Integer>>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            int key = entry.getKey();
            if (map.get(target - key) != null) {
                List<List<Integer>> list1 = entry.getValue();
                List<List<Integer>> list2 = map.get(target - key);
                for (List<Integer> pair1 : list1) {
                    for (List<Integer> pair2 : list2) {
                        if (pair1.get(0) != pair2.get(0) && pair1.get(0) != pair2.get(1) && pair1.get(1) != pair2.get(0) && pair1.get(1) != pair2.get(1)) {
                            List<Integer> quad = new ArrayList<>();
                            quad.add(nums[pair1.get(0)]);
                            quad.add(nums[pair1.get(1)]);
                            quad.add(nums[pair2.get(0)]);
                            quad.add(nums[pair2.get(1)]);
                            result.add(quad);
                        }
                    }
                }
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        result.forEach( l -> {
            l.sort(Comparator.naturalOrder());
            set.add(l);
        });
        return new ArrayList<>(set);
    }

    public static class Solution {
        public static  int[] twoSum(int[] nums, int target) {
            Arrays.sort(nums);
            int j = nums.length - 1;
            for (int i = 0; i < j; ) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j++;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        //int[] arr = {2,2,2,2,2};

        System.out.println(fourSum(arr, 0));
    }
}

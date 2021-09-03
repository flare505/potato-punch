package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertInterval {
    public static class Pair{
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
//    static int[][] func(int[][] intervals, int[] newInterval) {
//        int n = intervals.length;
//        ArrayDeque<Pair> deque = new ArrayDeque<>();
//        if (n == 0) {
//            deque.add(new Pair(newInterval[0], newInterval[1]));
//        }
//
//        int i;
//        for (i = 0; i < n; ++i) {
//            if (intervals[i][0] > newInterval[0]) {
//                // first check with previous value
//                if (deque.isEmpty()) {
//                    deque.add(new Pair(newInterval[0], newInterval[1]));
//                } else {
//                    if (deque.getLast().b < newInterval[0]) {
//                        deque.add(new Pair(newInterval[0], newInterval[1]));
//                    } else {
//                        Pair top = deque.removeLast();
//                        deque.add(new Pair(top.a, newInterval[1]));
//                    }
//                }
//                break;
//            }
//            deque.add(new Pair(intervals[i][0], intervals[i][1]));
//        }
//        //System.out.println("i= " + i);
//        for( ; i < n; i++) {
//            // second check of current val with top of deque after merging intervals
//            if (deque.getLast().b < intervals[i][0]) {
//                deque.add(new Pair(intervals[i][0], intervals[i][1]));
//            } else {
//                Pair top = deque.removeLast();
//                deque.add(new Pair(top.a, Integer.max(top.b, intervals[i][1])));
//            }
//        }
//
//        int k = deque.size();
//        int[][] ans = new int[k][2];
//        for(int j = 0; j < k; j++) {
//            Pair ansInterval = deque.remove();
//            ans[j][0] = ansInterval.a;
//            ans[j][1] = ansInterval.b;
//        }
//        return ans;
//    }

    static int[][] func(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<Pair> list = new ArrayList<>();
        if (n == 0) {
            list.add(new Pair(newInterval[0], newInterval[1]));
        }
        // sorted intervals
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] > newInterval[0]) {
                list.add(new Pair(newInterval[0], newInterval[1]));
                flag = false;
            }
            list.add(new Pair(intervals[i][0], intervals[i][1]));
        }
        if (flag) {
            list.add(new Pair(newInterval[0], newInterval[1]));
        }

        // using merge overlapping algorithm;
        int low = list.get(0).a;
        int high = list.get(0).b;
        List<Pair> ans = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            Pair pair = list.get(i);
            if (pair.a <= high) {
                high = Integer.max(high, pair.b);
            } else {
                ans.add(new Pair(low, high));
                low = pair.a;
                high = pair.b;
            }
        }
        ans.add(new Pair(low, high));

        int k = ans.size();
        int[][] ret = new int[k][2];
        for(int j = 0; j < k; j++) {
            Pair ansInterval = ans.get(j);
            ret[j][0] = ansInterval.a;
            ret[j][1] = ansInterval.b;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int[] interval = new int[2];
        interval[0] = sc.nextInt();
        interval[1] = sc.nextInt();
        System.out.println("Answer:::");
        int[][] ans = func(arr, interval);
        for (int i = 0 ; i < ans.length; i++) {
            System.out.println(ans[i][0] +  "," + ans[i][1]);
        }
    }
}

package algo;

import java.util.*;

public class DegreeOfArray {
    public static class Node implements Comparable<Node>{
        int freq;
        int firstInd;
        int lastInd;

        public Node() {
            this.freq = 0;
            this.firstInd = 0;
            this.lastInd = 0;
        }

        public void incfreq(int i) {
            if (this.freq == 0) {
                this.firstInd = i;
                this.lastInd = i;
            } else {
                this.lastInd = i;
            }
            this.freq += 1;
        }

        @Override
        public int compareTo(Node o) {
            if (this.freq < o.freq) {
                return -1;
            } else if (this.freq == o.freq) {
                int thislength = this.lastInd - this.firstInd;
                int olength = o.lastInd - o.firstInd;
                if (thislength > olength) {
                    return -1;
                }
                return 1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "freq=" + freq +
                    ", firstInd=" + firstInd +
                    ", lastInd=" + lastInd +
                    '}';
        }
    }
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Node> mp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (mp.get(nums[i]) == null) {
                Node val = new Node();
                val.incfreq(i);
                mp.put(nums[i], val);
            }
            else {
                Node val = mp.get(nums[i]);
                val.incfreq(i);
                mp.put(nums[i], val);
            }
        }

        Set<Map.Entry<Integer, Node>> entrySetSorted = new TreeSet<Map.Entry<Integer, Node>>(new Comparator<Map.Entry<Integer, Node>>() {
            @Override
            public int compare(Map.Entry<Integer, Node> o1, Map.Entry<Integer, Node> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        entrySetSorted.addAll(mp.entrySet());
        //entrySetSorted.stream().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue().toString()));
        Map.Entry<Integer, Node> topEntry = entrySetSorted.stream().findFirst().orElse(null);
        return topEntry == null ? 0 : topEntry.getValue().lastInd - topEntry.getValue().firstInd + 1;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[] {1, 2, 2, 3, 1}));
    }
}

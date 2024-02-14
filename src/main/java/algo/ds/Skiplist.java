package algo.ds;

import java.util.Arrays;
import java.util.Random;

class Skiplist {

    private static final int LEVEL = 5;
    private static final Random coin = new Random();

    private static class SkipNode {
        int data;
        SkipNode[] nextStack = new SkipNode[LEVEL];

        public SkipNode(int data) {
            this.data = data;
            Arrays.fill(this.nextStack, null);
        }
    }

    private boolean flipCoin() {
        return coin.nextBoolean();
    }

    public Skiplist() {
        SkipNode sentinal = new SkipNode(Integer.MIN_VALUE);
    }

    public boolean search(int target) {
        return false;
    }

    public void add(int num) {

    }

    public boolean erase(int num) {
        return false;
    }
}

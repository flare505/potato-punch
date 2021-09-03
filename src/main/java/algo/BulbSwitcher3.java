package algo;


public class BulbSwitcher3 {
    public static int numTimesAllBlue(int[] light) {
        int n = light.length;
        int diff = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            diff += (light[i] - i - 1);
            if (diff == 0) {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(numTimesAllBlue(new int[]{2,1,3,5,4}));
    }
}

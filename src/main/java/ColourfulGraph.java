import java.util.Arrays;
import java.util.Scanner;

class DSU {
    private int[] parent;
    public DSU(int n) {
        parent = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }
    }

    private int root(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public void union(int i, int j){
        int rooti = root(i);
        int rootj = root(j);

        parent[rooti] = rootj;
    }

    public boolean find(int i, int j) {
        return root(i) == root(j);
    }

    @Override
    public String toString() {
        return "DSU{" +
                "parent=" + Arrays.toString(parent) +
                '}';
    }
}

public class ColourfulGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        DSU[] dsus = new DSU[m+1];
        for (int i = 0; i <= m; i++) {
            dsus[i] = new DSU(n);
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            dsus[c].union(a, b);
        }

        //Arrays.stream(dsus).forEach(System.out::println);

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = 0;
            for (int j = 1; j <= m; j++) {
                if (dsus[j].find(a, b)) {
                    ans += 1;
                }
            }
            System.out.println(ans);
        }
    }
}

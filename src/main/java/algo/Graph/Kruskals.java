package algo.Graph;

import lombok.AllArgsConstructor;

import java.util.*;
import java.util.stream.IntStream;

@AllArgsConstructor
class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    @Override
    public int compareTo(Edge o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost == o.cost) {
            return 0;
        }
        return 1;
    }
}

public class Kruskals {
    static int[] parent;
    public static void init(int n) {
        parent = new int[n+1];
        IntStream.range(0, n+1).forEach(i -> {
            parent[i] = i;
        });
    }

    public static int root(int i) {
        while(parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public static void union(int i, int j) {
        int rooti = root(i);
        int rootj = root(j);
        parent[rooti] = rootj;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edgeSet = new ArrayList<>();
        for(int i = 0; i < m; i++ ) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            edgeSet.add(new Edge(a, b, c));
        }

        Collections.sort(edgeSet);
        edgeSet.forEach(edge -> System.out.println(edge.v1 + "->" + edge.v2 + "::" + edge.cost));

        init(n);
        int ans = 0;
        for(Edge e : edgeSet) {
            if (root(e.v1) != root(e.v2)) {
                ans += e.cost;
                union(e.v1, e.v2);
            }
        }
        System.out.println(ans);
    }
}

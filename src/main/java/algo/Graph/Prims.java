package algo.Graph;

import java.util.*;

class Pair implements Comparable<Pair> {
    int cost;
    int vertex;

    Pair(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.cost < o.cost) {
            return -1;
        }
        else if (this.cost == o.cost) {
            return 0;
        }
        return 1;
    }
}
public class Prims {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Map<Integer, List<Pair>> adj = new HashMap<>();

        for(int i = 0; i < m; i++ ) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(adj.get(a) == null) {
                List<Pair> val = new ArrayList<>();
                val.add(new Pair(b, c));
                adj.put(a, val);
            } else {
                List<Pair> val = adj.get(a);
                val.add(new Pair(b, c));
                adj.put(a, val);
            }

            if(adj.get(b) == null) {
                List<Pair> val = new ArrayList<>();
                val.add(new Pair(a, c));
                adj.put(b, val);
            } else {
                List<Pair> val = adj.get(b);
                val.add(new Pair(a, c));
                adj.put(b, val);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(1, 0));

        boolean[] visited = new boolean[n+1];

        int ans = 0;
        while(!pq.isEmpty()) {
            Pair pair = pq.poll();
            if(!visited[pair.vertex]) {
                visited[pair.vertex] = true;
                ans += pair.cost;
            }

            for(Pair node : adj.get(pair.vertex)) {
                if (!visited[node.vertex]) {
                    pq.add(node);
                }
            }
        }
        System.out.println(ans);
    }
}

package algo.Graph;

import java.util.*;

public class DijkstraShortest {
    public static int[] path = new int[1000];
    public static class Node implements Comparable<Node> {
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cost < o.cost) {
                return -1;
            }
            else if (this.cost > o.cost) {
                return 1;
            }
            return 0;
        }
    }

    public static void dijkstra(Map<Integer, List<Node>> adj) {
        int source = 0;
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < adj.size(); i++) {
            visited.put(i, 0);
            path[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(source, 0));
        path[source] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            visited.put(curr.id, 1);
            for (Node child : adj.get(curr.id)) {
                if (visited.get(child.id) == 0 && path[child.id] > path[curr.id] + child.cost) {
                    path[child.id] = path[curr.id] + child.cost;
                    pq.add(new Node(child.id, path[child.id]));
                }
            }
        }
        Arrays.stream(path, 0, adj.size()).forEach(System.out::println);
    }

    public static void main(String[] args) {
        int V = 5;
        Map<Integer, List<Node>> adj = new HashMap();

        for (int i = 0; i < V; i++) {
            adj.put(i, new ArrayList<>());
        }

        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));

        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));

        dijkstra(adj);
    }
}

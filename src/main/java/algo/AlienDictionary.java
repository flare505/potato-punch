package algo;

import java.util.*;
import java.util.stream.Collectors;

//There is a new alien language which uses the latin alphabet. However, the order among letters is unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
//
//        Input: ["wrt", "wrf", "er", "ett", "rftt"]
//        Output: "wertf"
//        Input: ["z","x","z"]
//        Output: "" # No valid ordering

public class AlienDictionary {

    public static void main(String[] args) {
        List<String> alienDictionary = Arrays.asList("wrt", "wrf", "er", "ett", "rftt");
        List<String> alienDictionary2 = Arrays.asList("x", "y", "x");

        // create graph of letters
        // topological sort
        System.out.println(topologicalSort(createGraph(alienDictionary)));
    }

    private static String topologicalSort(Map<String, Set<String>> graph) {
        Map<String, Integer> indegree = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
            indegree.merge(entry.getKey(), 0, Integer::sum);
            entry.getValue().forEach(x -> indegree.merge(x, 1, Integer::sum));
        }
        indegree.entrySet().stream().filter(e -> e.getValue().equals(0)).forEach(e -> queue.add(e.getKey()));

        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()) {
            String top = queue.poll();
            ans.append(top);

            if(graph.get(top) == null) {
                break;
            }
            for (String s : graph.get(top)) {
                if(indegree.get(s) != null && indegree.get(s) - 1 == 0) {
                    queue.add(s);
                }
                indegree.put(s, indegree.get(s) - 1);
            }
        }
        long count = indegree.entrySet().stream().filter(e -> !e.getValue().equals(0)).count();
        if (count != 0) {
            ans = new StringBuilder("NOT POSSIBLE");
        }
        return ans.toString();
    }

    private static Map<String, Set<String>> createGraph(List<String> alienDictionary) {
        Map<String, Set<String>> graph = new LinkedHashMap<>();
        for (int i = 0; i < alienDictionary.size() - 1; i++) {
            List<String> c1 = alienDictionary.get(i).chars().mapToObj(x -> (char)x).map(String::valueOf).collect(Collectors.toList());
            List<String> c2 = alienDictionary.get(i+1).chars().mapToObj(x -> (char)x).map(String::valueOf).collect(Collectors.toList());

            int n = Math.min(c1.size(), c2.size());
            for(int j = 0; j < n; j++) {
                String a = c1.get(j);
                String b = c2.get(j);
                if (!a.equals(b)) {
                    if (graph.get(a) == null) {
                        Set<String> adjacency = new HashSet<>();
                        adjacency.add(b);
                        graph.put(a, adjacency);
                    }
                    else {
                        graph.get(a).add(b);
                    }
                }
            }
        }
        graph.forEach((k, v) -> System.out.println(k + " -> " + v.toString()));
        return graph;
    }
}

import java.util.*;


public class KefaAndPark {
    static int ans;
    static int[] arr;
    static Map<Integer, List<Integer>> adj;
    static int k;

    public static void dfs(int vertex, int cats) {
        if(cats > k) {
            return;
        }
        if(adj.get(vertex) == null) {
            ans +=1;
        } else {
            List<Integer> val = adj.get(vertex);
            for(Integer i : val) {
                if (arr[i - 1] == 0) {
                    dfs(i, 0);
                } else {
                    dfs(i, cats + 1);
                }
            }
        }
    }

    public static int func(Map<Integer, List<Integer>> tree, int m) {
        int n = arr.length;
        adj = tree;
        k = m;
        ans = 0;
//        Arrays.stream(arr).forEach(x -> System.out.printf("%d ", x));
//        for(Map.Entry<Integer, List<Integer>> entry : adj.entrySet()) {
//            int key = entry.getKey();
//            List<Integer> value = entry.getValue();
//            System.out.println(key  + " -> " + value.toString());
//        }
        if (arr[0] == 0) {
            dfs(1, 0);
        } else {
            dfs(1, 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Map<Integer, List<Integer>> tree = new HashMap<>();
        for(int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (tree.get(a) == null) {
                List<Integer> val = new ArrayList<>();
                val.add(b);
                tree.put(a, val);
            }
            else {
                List<Integer> val = tree.get(a);
                val.add(b);
                tree.put(a, val);
            }
        }

        System.out.print(func(tree, m));
     }
}

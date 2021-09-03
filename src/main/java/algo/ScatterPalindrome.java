package algo;

import java.util.HashMap;
import java.util.Map;

public class ScatterPalindrome {
    private static long method3(String s){
        int n = s.length();
        int answer = 0;
        Map<Integer, Integer> m = new HashMap<>();
        m.put(0,1);

        int x = 0;
        for (char c : s.toCharArray()) {
            int d = c - 'a';
            x ^= 1 << d;
            answer =answer+ m.getOrDefault(x,0);
            for (int i = 0; i < 26; ++i) {
                answer += m.getOrDefault(x ^ (1 << i),0);
            }
            m.put(x,m.getOrDefault(x,0)+1);
            m.forEach((key, value) -> System.out.println(key + " -> " + value));
            System.out.println();
        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(method3("aabbcc"));
    }
}

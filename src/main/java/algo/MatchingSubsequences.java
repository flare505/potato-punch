package algo;

import java.util.*;

/**
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 *
 *
 * Example 1:
 *
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 */

//Correct but TLE
public class MatchingSubsequences {
    public static int func(String s, String[] words) {
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.merge(word, 1, Integer::sum);
        }

        Map<Character, TreeSet<Integer>> hashMap = new HashMap<>();
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (hashMap.get(letters[i]) == null) {
                TreeSet<Integer> value = new TreeSet<>();
                value.add(i);
                hashMap.put(letters[i], value);
            }
            else {
                TreeSet<Integer> value = hashMap.get(letters[i]);
                value.add(i);
                hashMap.put(letters[i], value);
            }
        }

        //hashMap.forEach((k, v) -> System.out.println(k + " -> " + v));

        int ans = 0;
        List<String> solution = new ArrayList<>();

        for(Map.Entry<String, Integer> wordEntry : wordFreq.entrySet()) {
            String word = wordEntry.getKey();
            Map<Character, TreeSet<Integer>> copyMap = new HashMap<>();
            hashMap.forEach((k, v) -> {
                TreeSet<Integer> treeSetVal = new TreeSet<>();
                treeSetVal.addAll(v);
                copyMap.put(k, treeSetVal);
            });

            int comp = -1;
            for (Character ch : word.toCharArray()) {
                // char not found
                if (copyMap.get(ch) == null) {
                    comp = -1;
                    break;
                }
                else {
                    TreeSet<Integer> indexes = copyMap.get(ch);
                    // similar no more char found
                    if (indexes.isEmpty()) {
                        comp = -1;
                        break;
                    }
                    // char found
                    else {
                        int currIndex = indexes.pollFirst();
                        while(!indexes.isEmpty() && comp >= currIndex) {
                            currIndex = indexes.pollFirst();
                        }
                        if (comp >= currIndex) {
                            comp = -1;
                            break;
                        }
                        else {
                            comp = currIndex;
                        }
                    }
                }
            }
            if (comp != -1) {
                ans += wordEntry.getValue();
                //solution.add(word);
            }
        }
        //solution.forEach(System.out::println);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s = "abcde";
//        String[] words = new String[]{"a","bb","acd","ace"};
        //"ahjpjau",
        String s = "dsahjpjauf";
        String[] words = new String[]{"ahjpjau", "ja","ahbwzgqnuk","tnmlanowax"};
        System.out.println(func(s, words));
    }
}

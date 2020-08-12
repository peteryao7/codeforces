import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/2/A
     * 
     * 248 ms / 3792 KB
     * 
     * Do as the question says. Find the scores for everyone at the end of the
     * game, go through everyone's scores to find the highest score, and store
     * the names of those with the max score in a set. Go through all the
     * rounds again until one of the winners manages to reach or surpass the
     * max score.
     * 
     * TC/SC - O(n)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        Map<String, Integer> map = new HashMap<>();
        Set<String> winners = new HashSet<>();
        String[] names = new String[n];
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            String name = s.next();
            int score = s.nextInt();
            names[i] = name;
            scores[i] = score;
            map.put(name, map.getOrDefault(name, 0) + score);
        }

        int max = 0;

        for (int score : map.values())
            max = Math.max(max, score);

        for (String name : map.keySet()) {
            if (map.get(name) == max)
                winners.add(name);
        }

        map.clear();

        // tie
        for (int i = 0; i < n; i++) {
            map.put(names[i], map.getOrDefault(names[i], 0) + scores[i]);
            if (map.get(names[i]) >= max && winners.contains(names[i])) {
                System.out.println(names[i]);
                break;
            }
        }

        s.close();
    }
}
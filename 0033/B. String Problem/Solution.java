import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/33/problem/B
     * 
     * 466 ms / 0 KB
     * 
     * This problem is basically finding the shortest path of going from s to
     * t or vice versa with the given costs (weights). Construct an adjacency
     * matrix with the minimum weights and use Floyd-Warshall on it to
     * find the shortest path of conversions. 
     * 
     * TC/SC - O(n)/O(1) (26x26 array)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        if (s.length() != t.length()) {
            System.out.println(-1);
            sc.close();
            return;
        }
        int n = sc.nextInt();
        int[][] dist = new int[26][26];
        for (int[] row : dist)
            Arrays.fill(row, -1);
        for (int i = 0; i < n; i++) {
            int ch1 = sc.next().charAt(0) - 'a';
            int ch2 = sc.next().charAt(0) - 'a';
            int cost = sc.nextInt();
            if (dist[ch1][ch2] == -1 || dist[ch1][ch2] > cost)
            dist[ch1][ch2] = cost;
        }

        for (int i = 0; i < 26; i++) {
            dist[i][i] = 0;
        }
        // Floyd-Warshall
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (dist[i][k] != -1 && dist[j][i] != -1 && (dist[j][k] == -1 || dist[j][k] > dist[j][i] + dist[i][k]))
                        dist[j][k] = dist[j][i] + dist[i][k];
                }
            }
        }

        int cost = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (cost == -1) {
                break;
            }
            else {
                int curCost = -1;
                int sCost = s.charAt(i) - 'a';
                int tCost = t.charAt(i) - 'a';
                char c = 0;
                for (int j = 0; j < 26; j++) {
                    if (dist[sCost][j] != -1 && dist[tCost][j] != -1 && (curCost == -1 || curCost > dist[sCost][j] + dist[tCost][j])) {
                        c = (char) (j + 'a');
                        curCost = dist[sCost][j] + dist[tCost][j];
                    }
                }

                if (curCost == -1) {
                    cost = -1;
                }
                else {
                    cost += curCost;
                    sb.append(c);
                }
            }
        }

        System.out.println(cost);
        if (cost != -1)
            System.out.println(sb);

        sc.close();
    }
}
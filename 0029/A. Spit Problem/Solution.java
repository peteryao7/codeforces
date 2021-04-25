import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/29/problem/A
     * 
     * 280 ms / 0 KB
     * 
     * Brute force. Go through each camel and check whether the camel it spits
     * to will spit back.
     * 
     * TC/SC - O(n^2)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] camels = new int[n];
        int[] dir = new int[n];

        for (int i = 0; i < n; i++) {
            camels[i] = s.nextInt();
            dir[i] = s.nextInt();
        }

        boolean matched = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (camels[i] == camels[j] + dir[j] && camels[j] == camels[i] + dir[i])
                    matched = true;
            }
        }

        System.out.println(matched ? "YES" : "NO");
        s.close();
    }
}
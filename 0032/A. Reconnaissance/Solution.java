import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/32/problem/A
     * 
     * 280 ms / 0 KB
     * 
     * Check every single pair of soldiers and compare the absolute value of
     * the difference of their heights. Because we're considering ordered
     * pairs, a valid pair counts as 2 pairs.
     * 
     * TC/SC - O(n^2)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int d = s.nextInt();

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = s.nextInt();
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (d >= Math.abs(x[i] - x[j]))
                    res += 2;
            }
        }

        System.out.println(res);
        s.close();
    }
}
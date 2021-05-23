import java.util.*;

public class Solution1 {
    /*
     * https://codeforces.com/problemset/problem/31/A
     * 
     * 280 ms / 0 KB
     * 
     * Brute force two sum with every worm acting as the target value.
     * 
     * TC/SC - O(n^3)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] a = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = s.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i != j && i != k && j != k && a[i] == a[j] + a[k]) {
                        System.out.println(i + " " + j + " " + k);
                        s.close();
                        return;
                    }
                }
            }
        }

        System.out.println(-1);

        s.close();
    }
}
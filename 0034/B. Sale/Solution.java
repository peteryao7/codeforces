import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/34/problem/B
     * 
     * 404 ms / 0 KB
     * 
     * We want the lowest negative values, so sort the array, add the first m
     * TV values, and negate it to get Bob's profit.
     * 
     * TC/SC - O(n)/O(n)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        int mc = 0;
        int res = 0;
        for (int i = 0; i < n && mc < m; i++) {
            if (a[i] < 0) {
                res += a[i];
                mc++;
            }
            else {
                break;
            }
        }

        System.out.println(-res);

        sc.close();
    }
}
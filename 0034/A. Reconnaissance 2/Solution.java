import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/34/problem/B
     * 
     * 466 ms / 0 KB
     * 
     * Self explanatory, make sure to check the endpoints. You can do this in
     * constant space by storing the first value but I didn't bother lol.
     * 
     * TC/SC - O(n)/O(n)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int diff = Math.abs(a[n - 1] - a[0]);
        int s1 = 1, s2 = n;

        for (int i = 1; i < n; i++) {
            if (Math.abs(a[i] - a[i - 1]) < diff) {
                diff = Math.abs(a[i] - a[i - 1]);
                s1 = i;
                s2 = i + 1;
            }
        }

        System.out.println(s1 + " " + s2);

        sc.close();
    }
}
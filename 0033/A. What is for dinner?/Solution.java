import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/33/problem/A
     * 
     * 434 ms / 0 KB
     * 
     * Use a map to store the minimum number of crucians that can be eaten for
     * each row of teeth. Then add up every value for each row and check
     * whether it's larger than k.
     * 
     * TC/SC - O(n)/O(m)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();

        int[] map = new int[m];
        Arrays.fill(map, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r - 1] = Math.min(map[r - 1], c);
        }

        int res = 0;
        for (int r : map)
            res += r;

        System.out.println(Math.min(k, res));

        sc.close();
    }
}
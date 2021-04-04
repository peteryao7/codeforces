import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/25/B
     * 
     * 248 ms / 0 KB
     * 
     * Greedily add hyphens for every 2 digits until the last step. We can
     * check for that by verifying whether the index is less than 2 away from
     * n.
     * 
     * TC/SC - O(n)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        String str = s.next();

        for (int i = 0; i < n; i++) {
            if (i > 0 && (i & 1) == 0 && n - i >= 2)
                System.out.print('-');
            System.out.print(str.charAt(i));
        }

        s.close();
    }
}
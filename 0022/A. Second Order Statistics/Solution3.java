import java.util.*;

public class Solution3 {
    /*
     * https://codeforces.com/problemset/problem/22/A
     * 
     * 280 ms / 0 KB
     * 
     * One pass - Do the second and third passes from Solution 2 in the same
     * pass. Keeping an array of all the elements isn't necessary.
     * 
     * TC/SC - O(n)/O(1)
     * 
     * Inserting every element into an array and doing the above as the second
     * pass results in 248 ms / 0 KB.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int min = 101;
        int min2 = 101;

        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            if (min > x) {
                min2 = min;
                min = x;
            }
            else if (min != x && x < min2) {
                min2 = x;
            }
        }

        System.out.println(min2 == 101 ? "NO" : min2);

        s.close();
    }
}
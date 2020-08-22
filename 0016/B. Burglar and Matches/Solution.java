import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/16/problem/B
     * 
     * 248 ms / 25960 KB
     * 
     * There are only 10 possible values for b_i, so we can create a 10-element
     * bucket that stores the number of containers with i number of matches.
     * 
     * To get the most matches possible, employ a greedy approach and always
     * opt for the boxes with the most matches. Therefore, start from the end,
     * take all the boxes you can that have 10 matches, then move on to the 9
     * match boxes, until you have n boxes.
     * 
     * TC/SC - O(m)/O(b)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int res = 0;

        // count of a_i (element) boxes with b_i (index) matches
        int[] matches = new int[11];

        for (int i = 0; i < m; i++) {
            int containers = s.nextInt();
            int numMatches = s.nextInt();
            matches[numMatches] += containers;
        }
        
        for (int i = matches.length - 1; i > 0; i--) {
            if (n > 0) {
                // use smaller number of matchboxes to take
                // to account for last remaining space
                int cur = Math.min(n, matches[i]);
                res += cur * i;
                n -= cur;
            }
        }

        System.out.println(res);
        s.close();
    }
}
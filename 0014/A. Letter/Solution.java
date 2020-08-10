import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/14/problem/A
     * 
     * 218 ms / 26008 KB
     * 
     * Do as the question says. Keep track of the earliest and latest
     * occurrences of the * character in both dimensions and make sure your
     * variable names don't confuse you.
     * 
     * TC/SC - O(nm)/O(nm)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        String[] grid = new String[n];

        int i_min = Integer.MAX_VALUE; // left boundary
        int i_max = Integer.MIN_VALUE; // right boundary
        int j_min = Integer.MAX_VALUE; // top boundary
        int j_max = Integer.MIN_VALUE; // bottom boundary

        for (int i = 0; i < n; i++) {
            grid[i] = s.next();
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '*') {
                    i_min = Math.min(i_min, j); // left boundary
                    i_max = Math.max(i_max, j); // right boundary
                    j_min = Math.min(j_min, i); // top boundary
                    j_max = Math.max(j_max, i); // bottom boundary
                }
            }
        }

        for (int i = j_min; i <= j_max; i++) {
            for (int j = i_min; j <= i_max; j++) {
                System.out.print(grid[i].charAt(j));
            }

            System.out.println();
        }

        s.close();
    }
}
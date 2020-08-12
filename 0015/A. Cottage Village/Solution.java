import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/15/problem/A
     * 
     * 310 ms / 4048 KB
     * 
     * We're given the center of each house and the lengths of each house,
     * but what we're interested in is the non-overlapping intervals of these
     * houses and whether those gaps can fit in our house.
     * 
     * Sort the houses by their x values. None of those houses should overlap,
     * so we should be able to go through each house in order.
     * 
     * To get the length of each gap, take the current house's starting point
     * and subtract the previous house's end point. If that gap is larger
     * than t, then we can fit 2 houses there. If it's equal to t, then we
     * can only fit one house there. Also, start the result counter at 2 
     * because we can also put a house at the very start or very end of all the
     * houses.
     * 
     * TC/SC - O(nlog(n))/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int t = s.nextInt();

        int[][] p = new int[n][2];

        for (int i = 0; i < n; i++) {
            p[i][0] = s.nextInt();
            p[i][1] = s.nextInt();
        }

        Arrays.sort(p, (a,b) -> a[0] - b[0]);

        int res = 2; // leftmost and rightmost pos

        for (int i = 1; i < n; i++) {
            // compare gap from current start pt - previous end pt
            if (p[i][0] - (double) p[i][1] / 2 - (p[i - 1][0] + (double) p[i - 1][1] / 2) == t)
                res++;
            else if (p[i][0] - (double) p[i][1] / 2 - (p[i - 1][0] + (double) p[i - 1][1] / 2) > t)
                res += 2; 
        }

        System.out.println(res);

        s.close();
    }
}
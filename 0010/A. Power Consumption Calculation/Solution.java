import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/10/A
     * 
     * 280 ms / 20656 KB
     * 
     * Do as the question says. All the start and end intervals given will use
     * the p1 power, so we can go through each interval and add (end - start) * p1
     * to the result.
     * 
     * For the idle times in between each interval, we need to split them up
     * between normal, screensaver, and sleep modes between t1 and t2, which
     * is done by taking the minimum between the amount of idle time and the
     * time it takes to switch. Then we can do dt1 * p1, dt2 * p2, and the
     * time left * p3.
     * 
     * TC/SC - O(n)/O(n) for n = number of intervals passed in
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int p1 = s.nextInt();
        int p2 = s.nextInt();
        int p3 = s.nextInt();
        int t1 = s.nextInt();
        int t2 = s.nextInt();
        // start intervals
        int[] l = new int[n];
        // end intervals
        int[] r = new int[n];

        int res = 0;

        // get power consumed while using laptop
        for (int i = 0; i < n; i++) {
            l[i] = s.nextInt();
            r[i] = s.nextInt();
            res += (r[i] - l[i]) * p1;
        }

        // get power consumed during downtime between intervals
        for (int i = 1; i < n; i++) {
            int t = l[i] - r[i - 1];
            int dt1 = Math.min(t, t1);
            res += dt1 * p1;
            t -= dt1;

            int dt2 = Math.min(t, t2);
            res += dt2 * p2;
            t -= dt2;

            res += t * p3;
        }

        System.out.println(res);

        s.close();
    }
}
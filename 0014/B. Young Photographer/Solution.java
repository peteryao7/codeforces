import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/14/problem/B
     * 
     * 218 ms / 25968 KB
     * 
     * We only care about a common interval shared with every single interval.
     * Therefore, it is bound on the left by the farthest right starting point,
     * and bound on the right by the earliest ending point. Because the
     * interval (a,b) may be defined where a > b, we assume the runner will
     * backtrack, so b will the be start interval here.
     * 
     * If, after making the supposed common overlapping interval, the start
     * ends up happening after end, then the interval is invalid and we print
     * -1. Otherwise, if x is outside the interval, move Bob such that he goes
     * onto the border of the interval. Otherwise, he's already in the interval
     * and doesn't need to move.
     * 
     * TC/SC - O(n)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int x = s.nextInt();
        int a, b;
        int left = -1, right = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            a = s.nextInt();
            b = s.nextInt();

            // make the smallest common interval
            // comprised of rightmost left interval
            // and leftmost right interval
            left = Math.max(left, Math.min(a,b));
            right = Math.min(right, Math.max(a,b));
        }

        // invalid, no common interval exists
        if (left > right)
            System.out.println(-1);
        // x is outside of interval on left
        else if (x < left)
            System.out.println(left - x);
        // x is outside of interval on right
        else if (x > right)
            System.out.println(x - right);
        // x is already in the interval
        else
            System.out.println(0);

        s.close();
    }
}
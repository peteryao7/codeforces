import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/16/problem/C
     * 
     * 109 ms / 25956 KB
     * 
     * The area is bound by the side that will have the smaller ratio of a/x
     * and b/y. First however, to avoid dealing with roundoff error from
     * integer division, take the GCD of x and y so a/x and b/y will be as
     * close to evenly dividing as possible, then divide x and y by gcd(x,y).
     * 
     * Next, find which ratio among a/x and b/y is smaller. This side will
     * restrict the other more, so multiply the smaller of the two with x and
     * y in the result to get the new resolution, where x <= a and y <= b.
     * 
     * TC/SC - O(log(max(a,b)))/O(log(max(a,b))) for GCD
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();

        // get GCD so we deal with the lowest factors possible
        int d = gcd(x, y);

        x = x/d;
        y = y/d;

        // bound by the smaller side after accounting for ratio
        int c = Math.min(a/x, b/y);

        System.out.println((c * x) + " " + (c * y));
        s.close();
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
}
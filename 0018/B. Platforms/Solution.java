import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/18/problem/B
     * 
     * 248 ms / 3724 KB
     * 
     * Instead of looking at the platforms themselves, we can look at the gaps
     * between the platforms. It's guaranteed there will be gaps since l < m.
     * For index k, the gap between platform [km, km + l] and [(k+1)m, (k+1)m + l]
     * is [km + l, (k+1)m].
     * 
     * We also don't want to move the grasshopper by only d units in every
     * iteration. Instead, we need to shift the jump to the moment the
     * grasshopper reaches the left gap. We do that by doing left / d, then
     * adding 1 to make it jump once, then multiply that by d to make it reach
     * left.
     * 
     * If the jump lands inside the gap, we'd print where the grasshopper
     * jumped to and return that. Otherwise, keep going until you've looked at
     * all the gaps.
     * 
     * TC/SC - O(n/m)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // long needed for input close to 10^6
        long n = s.nextInt();
        long d = s.nextInt();
        long m = s.nextInt();
        long l = s.nextInt();

        // left and right of gap btwn platforms
        long left = 0;
        long right = 0;
        long jump = 0;

        for (int i = 0; i < n; i++) {
            left = i * m + l;
            right = (i + 1) * m;
            jump = (left / d + 1) * d;

            if (jump > left && jump < right) {
                System.out.println(jump);
                s.close();
                return;
            }
        }

        System.out.println(jump);

        s.close();
    }
}
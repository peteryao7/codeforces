import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/11/B
     *
     * 216 ms / 25936 KB
     *
     * This is identical to Q754 on LC.
     * 
     * Use a greedy approach. First, set the target position to be positive, so
     * we don't need to write a second case for the negative direction. The 
     * answer in both cases would be symmetric in that the signs would be
     * flipped, but the magnitudes are the same.
     * 
     * Now if the target is reached, then we can stop there. Otherwise, we
     * overshot and need to look at how far away we are, sum - target = delta.
     * If delta is even, then we can set any number of jumps we made to be
     * negative, and it will undo 2*i steps we took. 2*i will always be even,
     * so that will always be the case. We can also think of the steps we
     * revert must sum up to delta/2.
     * 
     * However, if delta is odd, then it's impossible because 2*i is never odd.
     * Therefore, we will need to take another step and check if delta is 
     * even again. This will only ever happen at most twice.
     * 
     * TC/SC - O(sqrt(n))/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // use abs WLOG since negative steps are symmetric to positive ones
        int x = Math.abs(s.nextInt());
        int sum = 0;
        int res = 0;

        while (sum < x) {
            res++;
            sum += res;
        }

        while ((sum - x) % 2 != 0) {
            res++;
            sum += res;
        }

        System.out.println(res);

        s.close();
    }
}
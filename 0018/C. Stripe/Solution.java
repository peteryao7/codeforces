import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/18/problem/C
     * 
     * 374 ms / 3808 KB
     * 
     * Taking the sum every time we split would take too long, so let's
     * precalculate all the sums along the way with a prefix sum array. 
     * sum[i] contains the sum of all elements from sum[0] to sum[i]. We can
     * build it by storing the first value in sum[0], then for each i, adding
     * the current number read to sum[i - 1] for sum[i].
     * 
     * Now we can cut the stripe at each valid point. Only cut up to sum[n - 2]
     * as cutting the very end of the stripe isn't valid. We want to compare
     * the sums of the left vs. right halves. As we defined before, sum[i]
     * will contain the sum of the left half, so to get the sum of the right
     * half, we want to take the sum of the entire stripe (sum[n - 1]) and
     * subtract the left half (sum[i]) from it. If both of them are equal,
     * then we found a way to cut the stripe and should add it to our result.
     * 
     * TC/SC - O(n)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] sum = new int[n];
        sum[0] = s.nextInt();

        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + s.nextInt();
        }

        int res = 0;

        // cutting off the end of the stripe isn't valid
        for (int i = 0; i < n - 1; i++) {
            if (sum[i] == sum[n - 1] - sum[i])
                res++;
        }

        System.out.println(res);
        s.close();
    }
}
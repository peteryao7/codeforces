import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/33/problem/C
     * 
     * 622 ms / 0 KB
     * 
     * The solution is based on this editorial by ---Grigor---:
     * https://codeforces.com/blog/entry/732
     * 
     * If the prefix and suffix intersect, then the intersection will just be
     * what the numbers originally were in the sequence. We can consider this
     * case to be where the prefix and suffix are disjoint.
     * 
     * For instance, in this example:
     * [-4, -3, -2, -1, 1, 2, 3, 4]
     * If the prefix ends at index 6 and the suffix starts at index 2, then
     * the array looks like this:
     * [4, -3, -2, -1, 1, 2, 3, -4]
     * which is the same as inversing the first and last elements.
     * 
     * Therefore, the goal is to find a subarray in the sequence that will
     * maximize the sum of the sequence. To get the sum, we'd invert the ends
     * and add the intersection/subarray.
     * 
     * To calculate this, first add up all the elements in the whole array and
     * set it to S. Let S1 be the sum of the inner subarray. The sum of the
     * ends is equal to -(S-S1) as it will be inversed, so the sum is now just
     * -(S-S1) + S1 = 2*S1 - S.
     * 
     * Because S will always be constant, we want to maximize S1 by finding
     * the subarray with the largest sum. This is ultimately the maximum
     * subarray problem, which we'll use as a subroutine.
     * 
     * TC/SC - O(n)/O(n)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        long S = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            S += a[i];
        }

        long S1 = 0;
        long max = 0;

        // maximum subarray
        for (int i = 0; i < n; i++) {
            max += a[i];
            if (max < 0)
                max = 0;
            S1 = Math.max(S1, max);
        }

        System.out.println(2 * S1 - S);
        sc.close();
    }
}
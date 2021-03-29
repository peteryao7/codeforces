import java.util.*;

public class Solution2 {
    /*
     * https://codeforces.com/problemset/problem/22/A
     * 
     * 280 ms / 0 KB
     * 
     * Three pass - The first pass puts every element into an array. The second
     * pass finds the minimum of the array. The third finds the second smallest
     * distinct element of the array using the min.
     * 
     * TC/SC - O(n)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

        int min = 101;
        for (int x : nums)
            if (min > x) min = x;

        int min2 = 101;
        for (int x : nums)
            if (x != min && x < min2) min2 = x;

        System.out.println(min2 == 101 ? "NO" : min2);

        s.close();
    }
}
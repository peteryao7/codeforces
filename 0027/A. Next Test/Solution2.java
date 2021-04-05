import java.util.*;

public class Solution2 {
    /*
     * https://codeforces.com/problemset/problem/27/A
     * 
     * 280 ms / 0 KB
     * 
     * Similar to LC Q41. Put each number where you would expect them to be,
     * where for index i, nums[i] = i. If it's out of place, swap it in with
     * the other value there. Then iterate through the array starting at i = 1
     * and find the first unexpected value.
     * 
     * Also, make sure there isn't a hidden value at i = 0, since we don't ever
     * swap anything into it. If nums[0] > k, then it's simply k, otherwise
     * nums[0] == k and print k + 1.
     * 
     * TC/SC - O(n)/O(1), but space is dependent on constraints
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int[n + 1];

        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

        int i = 0, len = nums.length;
        while (i < len) {
            if (nums[i] >= 0 && nums[i] < len && nums[nums[i]] != nums[i])
                swap(nums, i, nums[i]);
            else
                i++;
        }

        int k = 1;
        while (k < len && nums[k] == k)
            k++;

        if (k < n)
            System.out.println(k);
        else
            System.out.println(nums[0] == k ? k + 1 : k);

        s.close();
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
import java.util.*;

public class Solution1 {
    /*
     * https://codeforces.com/problemset/problem/27/A
     * 
     * 310 ms / 0 KB
     * 
     * Use a frequency array to track which numbers appear, then find the
     * first index starting at 1 whose frequency is 0. That is the next test
     * index, or smallest missing positive number.
     * 
     * TC/SC - O(n)/O(1), but space is dependent on constraints
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int[3002];
        for (int i = 0; i < n; i++)
            nums[s.nextInt()]++;

        for (int i = 1; i < 3002; i++) {
            if (nums[i] == 0) {
                System.out.println(i);
                break;
            }
        }

        s.close();
    }
}
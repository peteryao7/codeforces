import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/27/C
     * 
     * 530 ms / 0 KB
     * 
     * Another way to phrase the question is to find the shortest monotonic
     * subsequence. It will always be of length 0 or 3. Sequences of length 1
     * and 2 will always be monotonic, and any sequence of length 4 or more
     * can be reduced to one of length 3. Thus, all we need to do is find any
     * "mountain or valley" sequence of length 3.
     * 
     * To find a valid subsequence, we can compare every pair of consecutive
     * integers with the first one. We don't need to check further because
     * other sequences can still be madee using the first one, so it's
     * redundant. If you fail to find a subsequence of length 3, then it can't
     * exist since longer sequences can be reduced to length 3, so just print
     * 0.
     * 
     * TC/SC - O(n)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = s.nextInt();
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 3; i <= n; i++) {
            if ((nums[i] > nums[i - 1] && nums[i - 1] < nums[1]) || 
                (nums[i] < nums[i - 1] && nums[i - 1] > nums[1])) {
                res.add(1);
                res.add(i - 1);
                res.add(i);
                break;
            }
        }

        System.out.println(res.size());

        for (int i : res)
            System.out.print(i + " ");

        s.close();
    }
}
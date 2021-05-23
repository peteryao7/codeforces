import java.util.*;

public class Solution2 {
    /*
     * https://codeforces.com/problemset/problem/31/A
     * 
     * 248 ms / 0 KB
     * 
     * Use a map so we have O(1) access to any index given the value. This
     * lets us skip a nested loop to find the 3rd worm.
     * 
     * TC/SC - O(n^2)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] a = new int[n + 1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int val = s.nextInt();
            a[i] = val;
            map.put(val, i);
        }

        for (int i = 1; i <= n; i++) {
            int target = a[i];
            for (int j = 1; j <= n; j++) {
                int kval = target - a[j];
                Integer k = map.get(kval);
                if (k != null && k != i && k != j && target == kval + a[j]) {
                    System.out.println(i + " " + j + " " + k);
                    s.close();
                    return;
                }
            }
        }

        System.out.println(-1);

        s.close();
    }
}
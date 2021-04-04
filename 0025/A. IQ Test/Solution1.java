import java.util.*;

public class Solution1 {
    /*
     * https://codeforces.com/problemset/problem/25/A
     * 
     * 278 ms / 0 KB
     * 
     * Use two lists that store the indices of each number of that list's
     * parity. One list will have one number and the other will have the rest.
     * Return the former's only value.
     * 
     * TC/SC - O(n)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            int x = s.nextInt();
            if ((x & 1) == 0) even.add(i);
            else odd.add(i);
        }

        System.out.println(even.size() < odd.size() ? even.get(0) : odd.get(0));
        s.close();
    }
}
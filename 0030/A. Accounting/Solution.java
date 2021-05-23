import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/30/A
     * 
     * 280 ms / 0 KB
     * 
     * Brute force, go through all possible X until none satisfy the condition.
     * Like A and B, |X| <= 1000 to prevent overflow.
     * 
     * TC/SC - O(1)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int n = s.nextInt();

        for (int i = -1000; i <= 1000; i++) {
            if (a * (int) Math.pow(i, n) == b) {
                System.out.println(i);
                s.close();
                return;
            }
        }

        System.out.println("No solution");
        s.close();
    }
}
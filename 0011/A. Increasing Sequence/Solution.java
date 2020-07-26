import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/11/A
     * 
     * 218 ms / 26032 KB
     * 
     * A brute force solution of repeatedly adding d will result in a TLE,
     * but all we need to do if the next number isn't greater is to find
     * the difference between them, divide it by d, and add 1. This gives us
     * the number of times we'd need to add d to make it valid in the sequence,
     * and to make the new number, add d * that number to it to get the new
     * valid number.
     * 
     * Note that we want the difference to be positive so we can use integer
     * division. If the difference is negative, then it will round down, which
     * is not what we want.
     * 
     * TC/SC - O(n)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int d = s.nextInt();
        int[] A = new int[n];

        int res = 0;

        for (int i = 0; i < n; i++)
            A[i] = s.nextInt();

        for (int i = 1; i < n; i++) {
            int diff = A[i - 1] - A[i];

            if (diff >= 0) {
                res += diff / d + 1;
                A[i] += d * (diff / d + 1);
            }
        }

        System.out.println(res);

        s.close();
    }
}
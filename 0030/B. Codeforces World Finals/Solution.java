import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/30/B
     * 
     * 310 ms / 0 KB
     * 
     * Do as the problem says. The rule for whether a year is a leap year is
     * if it's divisible by 4 and 400, but not 100.
     * 
     * TC/SC - O(1)/O(1) 
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] a = s.next().split("\\.");
        String[] b = s.next().split("\\.");

        boolean isPossible = permute(a, b);
        System.out.println(isPossible ? "YES" : "NO");
        s.close();
    }

    public static boolean permute(String[] a, String[] b) {
        int dd = Integer.valueOf(a[0]);
        int mm = Integer.valueOf(a[1]);
        int yy = Integer.valueOf(a[2]);
        int bd = Integer.valueOf(b[0]);
        int bm = Integer.valueOf(b[1]);
        int by = Integer.valueOf(b[2]);

        return (check(dd, mm, yy, bd, bm, by) ||
            check(dd, mm, yy, bd, by, bm) ||
            check(dd, mm, yy, bm, bd, by) ||
            check(dd, mm, yy, bm, by, bd) ||
            check(dd, mm, yy, by, bd, bm) ||
            check(dd, mm, yy, by, bm, bd));
    }

    public static boolean check(int dd, int mm, int yy, int d, int m, int y) {
        if (m > 12) return false;
        if (d > 31) return false;
        if (m == 2 && d > 29) return false;

        boolean isLeapYear = false;
        if (y % 400 == 0)
            isLeapYear = true;
        else if (y % 100 == 0)
            isLeapYear = false;
        else if (y % 4 == 0)
            isLeapYear = true;

        if (m == 2 && d == 29 && !isLeapYear) return false;
        if (m == 4 && d > 30) return false;
        if (m == 6 && d > 30) return false;
        if (m == 9 && d > 30) return false;
        if (m == 11 && d > 30) return false;

        if (yy - y > 18)
            return true;
        else if (yy - y == 18) {
            if (mm > m)
                return true;
            else if (mm == m)
                return dd >= d;
            return false;
        }
        else
            return false;
    }
}
import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/13/problem/A
     * 
     * 248 ms / 25948 KB
     * 
     * To add up all the digits of a number in a certain base, we only need
     * to look at the last digit of A, add it to a rolling sum, and truncate it
     * with integer division. Store the original number in a temp variable so
     * we can reuse it.
     * 
     * To find the average as an unreduced fraction, we can take the sum and
     * divide it by the number of bases we looked at, which went from 2 to 
     * A - 1, so it would be A - 2. Then to reduce the fraction, we need to
     * take the gcd of both the sum and the denominator, then divide both
     * values by that gcd.
     * 
     * TC/SC - O(Alog(A))/O(1)
     * 
     * We go through A - 2 bases and take log(A) time to find all the digits
     * for each base.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int A = s.nextInt();

        int sum = 0;
        int denom = A - 2;

        for (int i = 2; i < A; i++) {
            int n = A;

            // get sum of digits for the current i
            while (n > 0) {
                sum += n % i;
                n /= i;
            }
        }

        int div = gcd(sum, denom);

        System.out.println((sum / div) + "/" + (denom / div));

        s.close();
    }

    private static int gcd(int m, int n) {
        while (n != 0) {
            int a = m % n;
            m = n;
            n = a;
        }

        return m;
    }
}
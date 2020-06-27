import java.util.*;

public class Solution2 {
    /*
     * https://codeforces.com/contest/9/problem/A
     * 
     * 248 ms / 25900 KB
     * 
     * Now take the case where Yakko and Wakko decide to roll their fancy
     * 60-sided die. You don't want to manually write hundreds of switch cases,
     * so what should we do?
     * 
     * Finding the reduced formula to print out is a matter of finding the
     * GCD between the 2 values rolled, then dividing the max value and the
     * number of sides on the die by the GCD. By definition, the GCD is the
     * largest divisor between both values, so it will divide both values to
     * get the other values that divide them and use them to form the most
     * reduced fraction.
     * 
     * TC/SC - O(1)/O(1)
     * 
     * TC/SC - O(1)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int max = Math.max(a, b);
        int c = 6 - max + 1;

        int gcd = gcd(c, 6);

        System.out.println(c / gcd + "/" + 6 / gcd);

        s.close();
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }
}
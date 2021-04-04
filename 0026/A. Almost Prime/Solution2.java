import java.util.*;

public class Solution2 {
    /*
     * https://codeforces.com/contest/26/problem/A
     * 
     * 278 ms / 0 KB
     * 
     * Use the sieve method to find prime numbers. Instead of setting a value
     * to be true/false for prime, add 1 to signify that number has the
     * current number as a prime factor.
     * 
     * TC/SC - O(nloglog(n))/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] primes = new int[n + 1];
        int res = 0;

        // sieve
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 0) {
                for (int j = i; j <= n; j += i)
                    primes[j]++;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i] == 2) res++;
        }

        System.out.println(res);
        s.close();
    }
}
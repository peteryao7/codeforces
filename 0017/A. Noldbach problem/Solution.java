import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/17/problem/A
     * 
     * 218 ms / 25932 KB
     * 
     * Do as the problem says. Find primes from 2 to n inclusive, add two
     * consecutive primes plus 1 in the range, see if the sum is prime and
     * <= n, then increment a counter if so. If the counter is at least k by
     * the end, return true.
     * 
     * The isPrime() function may not be the most efficient, but it works well
     * enough.
     * 
     * TC/SC - O(n*sqrt(n))/O(sqrt(n))
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int k = s.nextInt();

        int res = 0;

        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i))
                primes.add(i);
        }

        for (int i = 0; i < primes.size() - 1; i++) {
            int sum = primes.get(i) + primes.get(i + 1) + 1;
            if (isPrime(sum) && sum <= n)
                res++;
        }

        System.out.println(res >= k ? "YES" : "NO");

        s.close();
    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        
        int sqrt = (int) Math.sqrt(n);

        for (int i = 3; i <= sqrt; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
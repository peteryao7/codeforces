import java.util.*;

public class Solution1 {
    /*
     * https://codeforces.com/contest/26/problem/A
     * 
     * 280 ms / 0 KB
     * 
     * First, generate all prime numbers from 2 to n and store the result in
     * a boolean array. b[i] == true means i is prime. Then we can go from 3
     * to n and count the number of prime divisors.
     * 
     * TC/SC - O(n^2)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        boolean[] b = new boolean[n + 1];
        int res = 0;
        
        for (int i = 2; i <= n; i++)
            b[i] = isPrime(i);

        for (int i = 3; i <= n; i++) {
            int c = 0;
            for (int j = 2; j <= i; j++) {
                if (b[j] && i % j == 0) c++;
            }
            if (c == 2) res++;
        }

        System.out.println(res);
        s.close();
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
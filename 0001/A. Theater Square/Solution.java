import java.util.*;

/*
 * https://codeforces.com/contest/1/problem/A
 * 
 * 140 ms / 20600 KB
 * 
 * Fit all the a x a stones into a gridlike fashion so you fill up all
 * the in the n x m square. It's ok if the stones go out of the square,
 * so we can extend the range of the square from n x m to 
 * (n + (a - 1)) x (m + (a - 1)).
 * 
 * Then to find the number of stones to fill up each dimension, we perform
 * integer division so we get a whole number back for both, then multiply
 * them together to get the answer.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        long n = s.nextInt();
        long m = s.nextInt();
        long a = s.nextInt();

        System.out.println(((n + a - 1) / a) * ((m + a - 1) / a));

        s.close();
    }
}
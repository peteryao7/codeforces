import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/6/problem/C
     * 
     * 374 ms / 3800 KB
     * 
     * Do what the questions asks. Export the number of chocolates as an int
     * array, then use two pointers at both endpoints for Alice and Bob. If
     * Alice has more chocolates than Bob, then we can simulate them eating
     * chocolate by subtracting the amount of chocolate Bob has from Alice's,
     * then decrement Bob's pointer to emulate him eating all his chocolate.
     * If Bob has more chocolates than Alice, we can do the same, but
     * increment Alice's pointer. If both have the same amount of chocolate,
     * move both pointers 1 index.
     * 
     * Keep going until both pointers are within 1 index of each other. If
     * they meet up at the same index, let Alice eat the last chocolate, so
     * Bob will have 1 less chocolate in that case.
     * 
     * TC/SC - O(n)/O(n) for n = number of chocolates
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] c = new int[n]; // chocolates

        for (int i = 0; i < n; i++) {
            c[i] = s.nextInt();
        }

        int a = 0;
        int b = n - 1;

        // until the ptrs meet up
        while (b - a > 1) {
            // b has more chocolate, so let a eat all her chocolate and
            // advance her pointer
            if (c[a] < c[b]) {
                c[b] -= c[a];
                c[a] = 0;
                a++;
            }
            // a has more chocolate, so let b eat all his chocolate and
            // advance his pointer
            else if (c[a] > c[b]) {
                c[a] -= c[b];
                c[b] = 0;
                b--;
            }
            else {
                c[a] = 0;
                c[b] = 0;
                a++;
                b--;
            }
        }

        // if a == b, let a eat the last chocolate => b eats n - b - 1
        System.out.println((a + 1) + " " + (a == b ? n - b - 1 : n - b));

        s.close();
    }
}
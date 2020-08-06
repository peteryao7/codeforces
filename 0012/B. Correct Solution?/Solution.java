import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/12/problem/B
     * 
     * 278 ms / 20612 KB
     * 
     * To shuffle Alice's number into the smallest possible number, we need
     * to put the smallest digits at the front and the largest ones at the
     * end. That means sorting the digits in ascending order.
     * 
     * However, we can't have a leading 0, so we need to swap the next smallest
     * digit after the 0s with the leading 0. Once that's done, we can compare
     * it with Bob's number and see if it matches.
     * 
     * TC/SC - O(nlog(n))/O(n) for n = length of Alice's number
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char[] alice = s.nextLine().toCharArray();
        char[] bob = s.nextLine().toCharArray();

        if (alice.length != bob.length) {
            System.out.println("WRONG_ANSWER");
            return;
        }

        // sort by ascending order puts largest digits at the end
        Arrays.sort(alice);

        // find first digit after leading 0s
        // swap it with first 0
        if (alice[0] == '0') {
            for (int i = 0; i < alice.length; i++) {
                if (alice[i] != '0') {
                    alice[0] = alice[i];
                    alice[i] = '0';
                    break;
                }
            }
        }

        // check if it's equal to Bob's number
        for (int i = 0; i < alice.length; i++) {
            if (alice[i] != bob[i]) {
                System.out.println("WRONG_ANSWER");
                return;
            }
        }

        System.out.println("OK");

        s.close();
    }
}
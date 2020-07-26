import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/9/problem/C
     * 
     * 218 ms / 25900 KB
     * 
     * More or less, do as the question says and count all the binary numbers
     * from 1 to n in decimal form. We can use the built-in method
     * Integer.toBinaryString() to convert an integer into its binary
     * representation as a string, then convert it back to a decimal integer
     * with Integer.parseInt(). We want to compare the binary representation
     * to the decimal value of n.
     * 
     * TC/SC - O(log(n))/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.next());
        int dec = 1;
        String binary = Integer.toBinaryString(dec);
        int res = 0;

        while (Integer.parseInt(binary) <= n) {
            res++;
            dec++;
            binary = Integer.toBinaryString(dec);
        }

        System.out.println(res);

        s.close();
    }
}
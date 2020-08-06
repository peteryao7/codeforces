import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/12/A
     * 
     * 248 ms / 20632 KB
     * 
     * The input is extremely small, so we can check the relevant positions
     * manually. Given the positions:
     * 
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * 
     * Check if (1,9), (2,8), (3,7), and (4,6) are the same character,
     * regardless if they're 'X' or '.'.
     * 
     * TC/SC - O(1)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String s1 = s.nextLine();
        String s2 = s.nextLine();
        String s3 = s.nextLine();

        if (s1.charAt(0) != s3.charAt(2) || 
            s1.charAt(1) != s3.charAt(1) ||
            s1.charAt(2) != s3.charAt(0) ||
            s2.charAt(0) != s2.charAt(2))
            System.out.println("NO");
        else
            System.out.println("YES");

        s.close();
    }
}
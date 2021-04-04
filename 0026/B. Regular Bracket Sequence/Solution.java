import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/26/B
     * 
     * 404 ms / 0 KB
     * 
     * The question can be rephrased as "What's the longest valid parentheses
     * string we can make?" To do that, keep a counter of the number of
     * unmatched left parens, then match each ) to a ( if we can. If we match
     * a pair, increase the result by 2 as they're 2 chars.
     * 
     * TC/SC - O(n)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str = s.next();
        int left = 0, res = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                left++;
            else if (left > 0) {
                left--;
                res += 2;
            }
        }

        System.out.println(res);
        s.close();
    }
}
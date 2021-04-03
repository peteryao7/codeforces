import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/23/A
     * 
     * 280 ms / 0 KB
     * 
     * Start from the longest possible substrings and look for the same
     * substring after that one's index. Reduce the window length as you
     * search. Because we only want the max length, we can stop looking once 
     * we find that a substring occurs twice.
     * 
     * TC/SC - O(n^3)/O(n) for n = length of input
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int max = 0;
        
        for (int k = str.length(); k >= 0; k--) {
            for (int start = 0; start < str.length() - k; start++) {
                String substr = str.substring(start, start + k);
                if (str.substring(start + 1).contains(substr)) {
                    max = substr.length();
                    break;
                }
            }
            if (max != 0)
                break;
        }

        System.out.println(max);
        s.close();
    }
}
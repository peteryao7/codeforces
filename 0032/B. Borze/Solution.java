import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/32/problem/B
     * 
     * 278 ms / 0 KB
     * 
     * Take a greedy approach and just parse each character as you see it.
     * 
     * TC/SC - O(n)/O(n) for n = s.length()
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == '-') {
                if (s.charAt(i + 1) == '.')
                    sb.append('1');
                else
                    sb.append('2');
                i++;
            }
            else {
                sb.append('0');
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
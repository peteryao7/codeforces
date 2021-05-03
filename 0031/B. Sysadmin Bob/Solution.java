import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/31/B
     * 
     * 140 ms / 0 KB
     * 
     * Greedy - we only need 2 letters between 2 @s to split between them.
     * If there are more, use the first letter as the domain for address i,
     * then the rest of the letters until an @ becomes the username for address
     * i + 1.
     * 
     * One important edge case is that the username and domain can't be empty,
     * so a string is invalid if it starts or ends with @. Also, if it's less
     * than 3 chars or has no @, it's also invalid. Any string that doesn't
     * have at least 2 letters between every @ is also invalid.
     * 
     * TC/SC - O(n)/O(n) for n = s.length() (substring is linear time)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        if (s.charAt(0) == '@' || s.charAt(s.length() - 1) == '@' || s.length() < 3 || !s.contains("@")) {
            System.out.println("No solution");
            sc.close();
            return;
        }

        String[] str = s.split("@");
        int n = str.length;

        for (int i = 1; i < n - 1; i++) {
            if (str[i].length() < 2) {
                System.out.println("No solution");
                sc.close();
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(str[0]);
        for (int i = 1; i < n - 1; i++) {
            sb.append('@');
            sb.append(str[i].charAt(0));
            sb.append(',');
            sb.append(str[i].substring(1));
        }
        sb.append('@');
        sb.append(str[n - 1]);
        System.out.println(sb.toString());
        sc.close();
    }
}
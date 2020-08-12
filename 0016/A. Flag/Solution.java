import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/16/A
     * 
     * 248 ms / 3756 KB
     * 
     * The question is self-explanatory, just be careful of the bounds. When
     * checking if the stripe above or below is the same, make sure either
     * i > 0 or i < n - 1. Also, when checking if the stripe is all the same
     * number, make sure j > 0 or j < m - 1 when comparing adjacent pairs.
     * 
     * TC/SC - O(nm)/O(nm)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        String[] flag = new String[n];

        for (int i = 0; i < n; i++) {
            String st = s.next();
            flag[i] = st;
            
            for (int j = 1; j < st.length(); j++) {
                if (i > 0) {
                    if (st.charAt(0) == flag[i - 1].charAt(0)) {
                        System.out.println("NO");
                        return;
                    }
                }

                if (st.charAt(j) != st.charAt(j - 1)) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");

        s.close();
    }
}
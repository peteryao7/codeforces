import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/8
     * 
     * 248 ms / 3764 KB
     * 
     * For Peter to have seen pattern A and B in two different periods of time,
     * the stations have to be disjoint from each other. That means we can't
     * have the letters matching B appearing inside A or vice versa. What that
     * means is input such as:
     * 
     * bbb
     * bb
     * bb
     * 
     * would return "fantasy", even though both patterns can match the string.
     * That's because we'd need at least 4 b's in the string for it to print
     * "both".
     * 
     * TC/SC - O(n)/O(n) for n = length of the first string
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String st = s.nextLine();
        String a = s.nextLine();
        String b = s.nextLine();

        int i = st.indexOf(a);
        int j = st.lastIndexOf(b);
        // both exist in st
        // and a and b are disjoint
        boolean forward = i >= 0 && j >= 0 && j - i >= a.length();

        st = new StringBuilder(st).reverse().toString();

        i = st.indexOf(a);
        j = st.lastIndexOf(b);
        boolean backward = i >= 0 && j >= 0 && j - i >= a.length();

        if (forward && backward)
            System.out.println("both");
        else if (forward)
            System.out.println("forward");
        else if (backward)
            System.out.println("backward");
        else
            System.out.println("fantasy");

        s.close();
    }
}
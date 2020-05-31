import java.util.Scanner;

public class Solution {
    /*
     * https://codeforces.com/contest/4/problem/A
     * 
     * 186 ms / 3700 KB
     * 
     * The only way we can divide a watermelon such that both pieces are an
     * even weight is if the watermelon itself is an even weight. If it were
     * odd, then one of the pieces would have to be even.
     * 
     * Watch out for the edge case where the watermelon is 2 kg. We can't
     * have someone receive no watermelon.
     * 
     * TC/SC: O(1)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();

        if (a % 2 == 0 && a != 2)
            System.out.println("YES");
        else
            System.out.println("NO");

        s.close();
    }
}
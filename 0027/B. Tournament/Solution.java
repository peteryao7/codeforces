import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/27/B
     * 
     * 280 ms / 0 KB
     * 
     * Keep count of the number of times a participant wins and competes in a
     * tourney. The missing match will have 2 participants that showed up
     * n - 2 times instead of n - 1 like everyone else. The one who has more
     * wins will also be the winner of that match.
     * 
     * TC/SC - O(n^2)/O(n) to read input
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] won = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < (n * (n - 1)) / 2 - 1; i++) {
            int first = s.nextInt() - 1, second = s.nextInt() - 1;
            won[first]++;
            count[first]++;
            count[second]++;
        }

        int res1 = -1, res2 = -1;

        for (int i = 0; i < n; i++) {
            if (count[i] != n - 1) {
                if (res1 != -1)
                    res2 = i;
                else
                    res1 = i;
            }
        }

        if (won[res1] < won[res2])
            System.out.println(++res2 + " " + ++res1);
        else
            System.out.println(++res1 + " " + ++res2);

        s.close();
    }
}
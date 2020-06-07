import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/6/B
     * 
     * 124 ms / 3700 KB
     * 
     * Export the office into a 2D array. For each president character found,
     * explore the 4 adjacent cells in the cardinal directions and add them
     * to a set of subordinate characters. Remove the president character if
     * it was inserted into the set.
     * 
     * TC/SC - O(mn)/O(mn) for m = office.length, n = office[0].length
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); // length of room
        int m = s.nextInt(); // width of room
        char c = s.next().charAt(0); // president's char

        char[][] office = new char[n][m];

        for (int i = 0; i < n; i++) {
            office[i] = s.next().toCharArray();
        }

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == c) {
                    if (i - 1 >= 0 && office[i - 1][j] != '.')
                        set.add(office[i - 1][j]);
                    if (i + 1 < n && office[i + 1][j] != '.')
                        set.add(office[i + 1][j]);
                    if (j - 1 >= 0 && office[i][j - 1] != '.')
                        set.add(office[i][j - 1]);
                    if (j + 1 < m && office[i][j + 1] != '.')
                        set.add(office[i][j + 1]);
                }
            }
        }

        set.remove(c);
        System.out.println(set.size());

        s.close();
    }
}
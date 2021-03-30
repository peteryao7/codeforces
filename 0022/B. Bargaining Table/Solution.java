import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/22/B
     * 
     * 278 ms / 0 KB
     * 
     * Brute force search - Start at every cell and try constructing a table
     * from it. Go right and down until you hit a '1', then get the perimeter
     * of that table by subtracting the start coordinates from the end.
     * 
     * TC/SC - O((nm)^3)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        char[][] grid = new char[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            grid[i] = s.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        boolean endOfTable = true;
                        for (int x = i; x <= k; x++) {
                            for (int y = j; y <= l; y++) {
                                if (grid[x][y] == '1') {
                                    endOfTable = false;
                                    break;
                                }
                            }

                            if (!endOfTable)
                            break;
                        }
                        if (endOfTable)
                            res = Math.max(res, 2 * (k - i + l - j + 2));
                    }
                }
            }
        }

        System.out.println(res);
        s.close();
    }
}
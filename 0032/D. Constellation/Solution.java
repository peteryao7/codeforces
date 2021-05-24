import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/32/problem/D
     * 
     * 342 ms / 0 KB
     * 
     * Brute force search. For each pass through the board, look for stars
     * with radius 1, then 2 and so on until you find the k-th star. Start
     * searching from [0,0] so the upper left star has priority.
     * 
     * TC/SC - O(min(n,m)*nm)/O(1)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        char[][] x = new char[n][m];
        for (int i = 0; i < n; i++) {
            x[i] = sc.next().toCharArray();
        }

        for (int r = 1; r <= Math.min(m, n); r++) {
            for (int i = r; i + r < n; i++) {
                for (int j = r; j + r < m; j++) {
                    if (x[i][j] == '*' && x[i - r][j] == '*' &&
                        x[i + r][j] == '*' && x[i][j - r] == '*' &&
                        x[i][j + r] == '*') {
                        if (--k == 0) {
                            System.out.println((i + 1) + " " + (j + 1));
                            System.out.println((i + 1 - r) + " " + (j + 1));
                            System.out.println((i + 1 + r) + " " + (j + 1));
                            System.out.println((i + 1) + " " + (j + 1 - r));
                            System.out.println((i + 1) + " " + (j + 1 + r));
                            sc.close();
                            return;
                        }
                    }
                }
            }
        }

        System.out.println(-1);
        sc.close();
    }
}
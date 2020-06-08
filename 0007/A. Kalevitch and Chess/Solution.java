import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/7/problem/A
     * 
     * 186 ms / 3716 KB
     * 
     * Export the chessboard into a 2D array of chars. Go through each row
     * and column and check if each char is black; use boolean flags for the
     * row and column that becomes false if any char is white. If, when
     * checking the whole row or column, it's all black, increment the number
     * of rows and columns, then add them together for the result.
     * 
     * If the whole board is black, then we only need to make 8 strokes,
     * either for all the rows or all the columns, not 16. For this edge case,
     * we can check if the sum is 16 and print 8 if so.
     * 
     * TC/SC - O(1)/O(1), since all chessboards are 8 x 8.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] board = new char[8][8];

        for (int i = 0; i < 8; i++) {
            board[i] = s.nextLine().toCharArray();
        }

        int hCount = 0, vCount = 0;

        for (int i = 0; i < 8; i++) {
            boolean hFlag = true, vFlag = true;

            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'W')
                    hFlag = false;
                if (board[j][i] == 'W')
                    vFlag = false;
            }

            if (hFlag)
                hCount++;
            if (vFlag)
                vCount++;
        }

        System.out.println(hCount + vCount == 16 ? 8 : hCount + vCount);

        s.close();
    }
}
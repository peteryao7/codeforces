import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/32/problem/C
     * 
     * 280 ms / 0 KB
     * 
     * For a flea to jump to a valid square, the horizontal or vertical
     * distance is s in either the row or column. First, calculate numM and
     * numN, which are the number of jumps a flea can make in that direction
     * that stay on the board. Then calculate numLeft and numDown, which are
     * the remainders of the other dimension when the flea makes a jump. We
     * want the most frequent occurrence of the remainders mod S. Multiplying
     * all these values together will get you the max number of cells the flea
     * can land on.
     * 
     * TC/SC - O(1)/O(1)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        long numM = (m + s - 1) / s;
        long numN = (n + s - 1) / s;
        long numLeft = (m + s - 1) % s + 1;
        long numDown = (n + s - 1) % s + 1;

        System.out.println(numM * numN * numLeft * numDown);

        sc.close();
    }
}
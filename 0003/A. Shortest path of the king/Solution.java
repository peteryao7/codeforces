import java.util.Scanner;

/*
 * https://codeforces.com/problemset/problem/3/A
 * 
 * 216 ms / 3708 KB
 * 
 * Diagonal moves count as 1 move, whereas a move in the 4 cardinal directions
 * also counts as 1 move. That means a diagonal is equivalent to moving in 2
 * different cardinal directions at the same time, so we want to do as many
 * of those as possible.
 * 
 * It's like trying to find the Manhattan distance from both points, but 
 * moving in LD, LU, RD, or RU count as 1.
 * 
 * We can split the distance of both points into r and c, the number of rows
 * and columns both points are away from, respectively. The minimum number of
 * moves is the max of both values because we can only move at most 1 r and/or
 * 1 c blocks in each move.
 * 
 * To make the path, we can use r and c to determine what direction to move in.
 * We should always do the diagonals first so we can get those out of the way,
 * then as long as r and c are both nonzero, we should be moving diagonally.
 * Whenever we make a move:
 * - decrement r and add "L" to the string if we're moving left
 * - increment r and add "R" to the string if we're moving right
 * - decrement c and add "U" to the string if we're moving up
 * - increment c and add "D" to the string if we're moving down
 * 
 * Then print the string created for each move.
 * 
 * TC/SC: O(max(r, c))/O(1)
 */
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String b = s.nextLine();

        int r = a.charAt(0) - b.charAt(0);
        int c = a.charAt(1) - b.charAt(1);

        System.out.println(Math.max(Math.abs(r), Math.abs(c)));

        while (r != 0 || c != 0) {
            String st = "";

            if (r > 0) {
                st += "L";
                r--;
            }
            else if (r < 0) {
                st += "R";
                r++;
            }

            if (c > 0) {
                st += "D";
                c--;
            }
            else if (c < 0) {
                st += "U";
                c++;
            }

            System.out.println(st);
        }
    }
}
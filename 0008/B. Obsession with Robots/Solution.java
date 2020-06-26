import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/8/problem/B
     * 
     * 216 ms / 25900 KB
     * 
     * We can represent the moves in the input on a 2D array. Use a boolean 2D
     * array to keep track of already visited cells.
     * 
     * For a path to return "OK", the robot may never cross its own path. It's
     * always possible to construct a wall of obstacles that follows a robot's
     * direct path, then wall off the entire other half of the field to make
     * it the most direct path to the final cell.
     * 
     * Mark the current cell you're on as visited, then make the move based
     * on the current letter you're at. Then check the 4 neighboring cells and
     * see if more than one cell, other than the previous current cell, has
     * been visited. Also check if the new cell you're on was already visited.
     * If either or both conditions is true, then the robot went into a cycle
     * and a shorter path could have been made.
     * 
     * Once all the moves have been made and neither condition for a cycle
     * ever returned true, only then can we print "OK".
     * 
     * TC/SC - O(n)/O(n^2) for n = length of input, capped at 100
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[] dirs = s.next().toCharArray();

        int x = 100;
        int y = 100;
        boolean[][] field = new boolean[201][201];

        for (int i = 0; i < dirs.length; i++) {
            field[x][y] = true;
            char c = dirs[i];

            if (c == 'L')
                x--;
            else if (c == 'R')
                x++;
            else if (c == 'U')
                y--;
            else if (c == 'D')
                y++;

            int visitedCells = 0;

            if (field[x - 1][y])
                visitedCells++;
            if (field[x + 1][y])
                visitedCells++;
            if (field[x][y - 1])
                visitedCells++;
            if (field[x][y + 1])
                visitedCells++;

            // visited the same cell again
            // or 2-4 neighboring cells were already visited
            // both make a cycle
            if (field[x][y] || visitedCells > 1) {
                System.out.println("BUG");
                return;
            }
        }
        
        System.out.println("OK");

        s.close();
    }
}
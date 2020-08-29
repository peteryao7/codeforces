import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/18/problem/A
     * 
     * 216 ms / 3720 KB
     * 
     * Use the Pythagorean theorem to determine whether a triangle is right.
     * Avoid using Math.sqrt() to avoid roundoff errors from using double,
     * just squaring the x and y coordinates is fine.
     * 
     * For finding almost triangles, go through all 12 possibilities of
     * incrementing/decrementing the 6 x/y coordinates by 1. If any of them
     * turn out to be a right triangle, then it's an almost triangle.
     * 
     * TC/SC - O(1)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x1 = s.nextInt();
        int y1 = s.nextInt();
        int x2 = s.nextInt();
        int y2 = s.nextInt();
        int x3 = s.nextInt();
        int y3 = s.nextInt();

        if (isRight(x1, y1, x2, y2, x3, y3))
            System.out.println("RIGHT");
        else if (isAlmost(x1, y1, x2, y2, x3, y3))
            System.out.println("ALMOST");
        else
            System.out.println("NEITHER");

        s.close();
    }

    private static int dist(int x, int y) {
        return x * x + y * y;
    }

    private static boolean isRight(int x1, int y1, int x2, int y2, int x3, int y3) {
        int d12 = dist(x1 - x2, y1 - y2);
        int d13 = dist(x1 - x3, y1 - y3);
        int d23 = dist(x2 - x3, y2 - y3);

        return d12 > 0 && d13 > 0 && d23 > 0 &&
            (d12 + d13 == d23 || d12 + d23 == d13 || d13 + d23 == d12);
    }

    private static boolean isAlmost(int x1, int y1, int x2, int y2, int x3, int y3) {
        return isRight(x1 + 1, y1, x2, y2, x3, y3) ||
               isRight(x1 - 1, y1, x2, y2, x3, y3) ||
               isRight(x1, y1 + 1, x2, y2, x3, y3) ||
               isRight(x1, y1 - 1, x2, y2, x3, y3) ||
               isRight(x1, y1, x2 + 1, y2, x3, y3) ||
               isRight(x1, y1, x2 - 1, y2, x3, y3) ||
               isRight(x1, y1, x2, y2 + 1, x3, y3) ||
               isRight(x1, y1, x2, y2 - 1, x3, y3) ||
               isRight(x1, y1, x2, y2, x3 + 1, y3) ||
               isRight(x1, y1, x2, y2, x3 - 1, y3) ||
               isRight(x1, y1, x2, y2, x3, y3 + 1) ||
               isRight(x1, y1, x2, y2, x3, y3 - 1);
    }
}
import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/6/problem/A
     * 
     * 218 ms / 3712 KB
     * 
     * Do as the question says. There are 4 different combinations of sides we
     * can try to check for a valid or degenerate triangle: 0 1 2, 0 1 3,
     * 0 2 3, 1 2 3. Just iterate through those combinations, check if any of
     * them would satisfy the valid and degenerate triangle tests, and print
     * the result in the order of TRIANGLE, SEGMENT, IMPOSSIBLE.
     * 
     * TC/SC - O(1)/O(1)
     * 
     * If we wanted to incorporate more sides into the question, then we would
     * have to generate every single permutation possible with this solution,
     * which would take O(n!) time for n = # sides in the input. This solution
     * is sufficient, but not scalable.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] input = new int[4];

        for (int i = 0; i < input.length; i++) {
            input[i] = s.nextInt();
        }

        if (isTriangle(input[0], input[1], input[2]) ||
            isTriangle(input[0], input[1], input[3]) ||
            isTriangle(input[0], input[2], input[3]) ||
            isTriangle(input[1], input[2], input[3]))
            System.out.println("TRIANGLE");
        else if (isSegment(input[0], input[1], input[2]) ||
            isSegment(input[0], input[1], input[3]) ||
            isSegment(input[0], input[2], input[3]) ||
            isSegment(input[1], input[2], input[3]))
            System.out.println("SEGMENT");
        else
            System.out.println("IMPOSSIBLE");

        s.close();
    }

    private static boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    private static boolean isSegment(int a, int b, int c) {
        return a + b == c || a + c == b || b + c == a;
    }
}
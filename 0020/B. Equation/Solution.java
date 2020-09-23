import java.util.*;
import java.math.*;

public class Solution {
    /*
     * https://codeforces.com/contest/20/problem/B
     * 
     * 155 ms / 0 KB
     * 
     * Use the quadratic formula to figure out the number of roots and the
     * answers for Ax^2 + Bx + C = 0. Because of how large the input is, it's
     * better to initiate the coefficients as a long to prevent overflow and
     * casting problems. Please see the inline comments for a step-by-step
     * explanation.
     * 
     * As a reminder, the quadratic formula is:
     * x = (-B ± sqrt(B^2 - 4AC)) / 2A
     * where B^2 - 4AC is the discriminant.
     * 
     * TC/SC - O(1)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long A = s.nextLong(), B = s.nextLong(), C = s.nextLong();

        // only left with a constant, if C == 0 then there's infinite solns
        // otherwise there's none
        if (A == 0 && B == 0) {
            System.out.println(C == 0 ? -1 : 0);
        }
        // formula is Bx + C = 0
        // so x = -C / B
        else if (A == 0) {
            System.out.println(1);
            System.out.println(1.0 * -C / B);
        }
        else {
            // B^2 - 4AC, all under a sqrt
            long discriminant = B * B - 4 * A * C;

            // cannot take sqrt of negative values, so no soln
            if (discriminant < 0)
                System.out.println(0);
            // -/+ case doesn't matter if you're adding/subtracting 0
            else if (discriminant == 0) {
                System.out.println(1);
                System.out.println(1.0 * -B / (2.0 * A));
            }
            // discriminant is positive, so take the quadratic formula
            else {
                System.out.println(2);
                double num1 = (-B - Math.sqrt(discriminant)) / (2.0 * A);
                double num2 = (-B + Math.sqrt(discriminant)) / (2.0 * A);

                // print in ascending order
                if (num1 < num2) {
                    System.out.println(num1);
                    System.out.println(num2);
                }
                else {
                    System.out.println(num2);
                    System.out.println(num1);
                }
            }
        }

        s.close();
    }
}
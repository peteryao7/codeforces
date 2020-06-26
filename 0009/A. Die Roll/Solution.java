import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/9/problem/A
     * 
     * 218 ms / 26000 KB
     * 
     * Do as the question says. If the number of possibilities of a die roll
     * is 6, and losing the roll is max - 1 as rolling the same as the max of
     * either person count as a win, then rolling a winning possibility is
     * 6 - (max - 1) = 6 - max + 1. Then we print out the corresponding fraction.
     * 
     * TC/SC - O(1)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int max = Math.max(a, b);
        int c = 6 - max + 1;

        switch(c) {
            case 1:
                System.out.println("1/6");
                break;
            case 2:
                System.out.println("1/3");
                break;
            case 3:
                System.out.println("1/2");
                break;
            case 4:
                System.out.println("2/3");
                break;
            case 5:
                System.out.println("5/6");
                break;
            case 6:
                System.out.println("1/1");
                break;
            default:
                System.out.println("0/1");
                break;
        }
        
        s.close();
    }
}
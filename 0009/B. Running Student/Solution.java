import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/9/problem/B
     * 
     * 248 ms / 25972 KB
     * 
     * Do as the question says. Skip the first stop, and calculate the time
     * it would take for the bus to reach each stop, then the time the student
     * would take to reach the university. Add both times together, and stop
     * that produces the the minimum time is the answer. Make sure to add 1
     * to the result as the 0th stop is actually the 1st one.
     * 
     * TC/SC - O(n)/O(n) for n = # stops
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int vb = s.nextInt();
        int vs = s.nextInt();

        double[] stops = new double[n];
        for (int i = 0; i < n; i++)
            stops[i] = s.nextDouble();

        int x = s.nextInt();
        int y = s.nextInt();

        double minTime = Double.MAX_VALUE;
        int min = -1;

        for (int i = 1; i < n; i++) {
            double busTime = stops[i] / vb;
            double stuTime = Math.sqrt(Math.pow(x - stops[i], 2) + Math.pow(y, 2)) / vs;

            if (minTime >= busTime + stuTime) {
                minTime = busTime + stuTime;
                min = i;
            }
        }

        System.out.println(min + 1);
        
        s.close();
    }
}
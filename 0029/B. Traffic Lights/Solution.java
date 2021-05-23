import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/29/problem/B
     * 
     * 278 ms / 0 KB
     * 
     * There are 2 possible cases: the car makes the light or it doesn't. If
     * it's the former, then the answer is just l / v. Otherwise, we need to
     * calculate the wait time. First, calculate the time it takes for the car
     * to reach the light, or x = d / v. This will be used to find the wait
     * time.
     * 
     * We want to know whether the light will be red or green when the car
     * arrives. To do this, subtract all traffic light cycles of g + r until
     * x < g + r. If x >= g, then the car missed the cycle and has to stop.
     * Thus, it has to wait g + r - x extra time, so add that time to the
     * result.
     * 
     * TC/SC - O(1)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double l = s.nextDouble(); // dist btwn A and B
        double d = s.nextDouble(); // dist from A to traffic light
        double v = s.nextDouble(); // car velocity
        double g = s.nextDouble(); // green light
        double r = s.nextDouble(); // red light

        double res = l / v; // minimum time to get from A to B
        double x = d / v; // time to get from A to traffic light
        // ignore g + r cycles
        while (x >= g + r) {
            x -= g + r;
        }
        // can't make light, add wait time to res
        if (x >= g)
            res += g + r - x;
        System.out.println(res);

        s.close();
    }
}
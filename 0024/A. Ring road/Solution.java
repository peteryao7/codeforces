import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/24/problem/A
     * 
     * 280 ms / 0 KB
     * 
     * The problem states that it's already possible to get to any city from
     * any city in a ring, so all we need to do is calculate the total cost
     * from redirecting traffic in one way or the other. That means all roads
     * will go in the same direction. To find the cost, keep track of the
     * total cost for switching every road and the cost for one direction. We
     * can get the cost of switching for the other direction by taking
     * (total cost - cost of switching one direction). Basically, find the
     * complement.
     * 
     * TC/SC - O(n)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int cost = 0, totalCost = 0;
        int[] getFrom = new int[n + 1];
        int[] getTo = new int[n + 1];
        Arrays.fill(getFrom, -1);
        Arrays.fill(getTo, -1);

        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            if (getFrom[a] != -1 || getTo[b] != -1) {
                getFrom[b] = a;
                getTo[a] = b;
            }
            else {
                getFrom[a] = b;
                getTo[b] = a;
                cost += c;
            }

            totalCost += c;
        }

        System.out.println(Math.min(cost, totalCost - cost));

        s.close();
    }
}
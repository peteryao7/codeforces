import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/23/problem/B
     * 
     * 1622 ms / 0 KB
     * 
     * At first I thought the answer would simply be the input, as everyone in
     * the party could just be friends with everyone else. Basically the
     * party would create a complete graph, where every friend is connected
     * with each other. But the example shows that isn't the case.
     * 
     * So we know that someone has to leave the party while it's going on and
     * everyone can't leave at once. Then the next best case scenario is to
     * take the complete graph, but remove an edge. That means 2 people will
     * have n - 2 friends, and the rest have n - 1 friends. Thus, n - 2 people
     * can always be left at the end if n > 1.
     * 
     * If there's only 1 person at the party, then that person leaves and it's
     * the end, so return 0.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            System.out.println((n > 1) ? (n - 2) : 0);
        }

        s.close();
    }
}
import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/22/A
     * 
     * 278 ms / 0 KB
     * 
     * The question can be rephrased as this: Find the second smallest distinct
     * element in a sequence of numbers. Use a set to keep track of distinct
     * numbers and a min PQ to insert those numbers into that keeps the min at
     * the top. After parsing every integer, if there's <= 1 distinct elements
     * in the set, print "NO", otherwise pop from the PQ and return its new top.
     * 
     * TC/SC - O(nlog(n))/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue();
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            if (!set.contains(x)) {
                set.add(x);
                pq.offer(x);
            }
        }

        if (set.size() <= 1)
            System.out.println("NO");
        else {
            pq.poll();
            System.out.println(pq.peek());
        }

        s.close();
    }
}
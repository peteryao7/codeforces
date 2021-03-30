import java.util.*;

public class Solution4 {
    /*
     * https://codeforces.com/problemset/problem/22/A
     * 
     * 280 ms / 0 KB
     * 
     * Max Heap
     * 
     * 
     * TC/SC - O(nlog(k))/O(k)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int n = s.nextInt();

        int i = 0;
        while (pq.size() != 2 && i < n) {
            int x = s.nextInt();
            if (!set.contains(x)) {
                set.add(x);
                pq.offer(x);
            }
            i++;
        }

        while (i < n) {
            int x = s.nextInt();
            if (!set.contains(x)) {
                set.add(x);
                if (x < pq.peek()) {
                    pq.offer(x);
                    pq.poll();
                }
            }
            i++;
        }

        if (set.size() <= 1)
            System.out.println("NO");
        else {
            System.out.println(pq.peek());
        }

        s.close();
    }
}
import java.util.Scanner;

public class Solution {
    /*
     * https://codeforces.com/contest/4/problem/B
     * 
     * 109 ms / 3712 KB
     * 
     * To ensure that an answer is possible, make sure the hours allocated are
     * within the realm of possibility. That means if Peter studied to bare
     * minimum or the absolute maximum of hours given for all d days, then
     * sumTime should be between that range. If not, we can print NO and stop.
     * 
     * Otherwise, we can use a greedy approach. We need to keep track of how
     * many hours sumTime currently has, and the amount of time he must study
     * for this day assuming he only studies the min days afterwards. If that
     * number is larger than the max allocated time of the day, then he can
     * study the max. Otherwise, he needs to reduce the amount of time spent
     * so he doesn't run out of study hours on the last few days.
     * 
     * TC/SC - O(n)/O(n)
     * We make a total of two passes through the input.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int d = s.nextInt();
        int sumTime = s.nextInt();
        int[] a = new int[d]; // mins
        int[] b = new int[d]; // maxes
        int min = 0;
        int max = 0;

        for (int i = 0; i < d; i++) {
            a[i] = s.nextInt();
            b[i] = s.nextInt();
            min += a[i];
            max += b[i];
        }

        if (sumTime >= min && sumTime <= max) {
            System.out.println("YES");
            
            // greedy
            for (int i = 0; i < d; i++) {
                min -= a[i]; // will always take a[i] time anyway

                // number of total hours left needed to study for this day
                // assuming we only study the min hours needed after this day
                int c = sumTime - min;

                // can study up to max hours of d without exhausting sumTime
                if (c >= b[i]) {
                    sumTime -= b[i];
                    System.out.println(b[i]);
                }
                // else study c hours to allocate time for later
                else {
                    sumTime -= c;
                    System.out.println(c);
                }
            }
        }
        else
            System.out.println("NO");

        s.close();
    }
}
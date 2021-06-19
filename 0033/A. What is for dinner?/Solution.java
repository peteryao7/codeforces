import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();

        int[] map = new int[m];
        Arrays.fill(map, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r - 1] = Math.min(map[r - 1], c);
        }

        int res = 0;
        for (int r : map)
            res += r;

        System.out.println(Math.min(k, res));

        sc.close();
    }
}
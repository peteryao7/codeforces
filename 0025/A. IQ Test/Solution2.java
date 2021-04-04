import java.util.*;

public class Solution2 {
    /*
     * https://codeforces.com/problemset/problem/25/A
     * 
     * 248 ms / 0 KB
     * 
     * We can just keep track of the frequency of even and odd values and the
     * last index seen. Either one of the frequencies must be 1, and the last
     * index of that parity will also be the first, so return the respective
     * index.
     * 
     * TC/SC - O(n)/O(1)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int idxEven = 0, idxOdd = 0;
        int numEven = 0, numOdd = 0;

        for (int i = 1; i <= n; i++) {
            int x = s.nextInt();
            if ((x & 1) == 0) {
                idxEven = i;
                numEven++;
            }
            else {
                idxOdd = i;
                numOdd++;
            }
        }

        System.out.println(numEven == 1 ? idxEven : idxOdd);
        s.close();
    }
}
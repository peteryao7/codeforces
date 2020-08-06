import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/12/problem/D
     * 
     * 139 ms / 20664 KB
     * 
     * To get the max, we want to put the highest price tag on the most
     * frequent fruit, then go down the next highest price tags to the next
     * most frequent fruits. Then we do the opposite for min, where we give
     * the most frequent fruit the lowest price tag and go up from there.
     * 
     * First, sort the price array. This will give us a way to go through each
     * successive price tag in terms of amount, so we can go left when
     * finding the min (n - 1 - i), and go right when finding the max (i).
     * 
     * To find the most frequent fruits, we can use a map that stores each
     * fruit's frequency, then put the frequency of the fruit into a frequency
     * array of length n. If there are dupes, then the leftover elements are
     * left as 0 and we'd give the cheapest or most expensive price tags to
     * fruits with a frequency of 0.
     * 
     * TC/SC - O(max(m,n) * log(max(m,n))/O(max(m,n)) for m = # price tags,
     * n = # distinct fruits
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++)
            prices[i] = s.nextInt();

        Arrays.sort(prices);

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String fruit = s.next();
            map.put(fruit, map.getOrDefault(fruit, 0) + 1);
        }

        int[] freqs = new int[n];
        int j = 0;

        for (int freq : map.values()) {
            freqs[j] = freq;
            System.out.println(freqs[j]);
            j++;
        }

        int min = 0;
        int max = 0;

        Arrays.sort(freqs);

        for (int i = 0; i < n; i++) {
            min += prices[i] * freqs[n - 1 - i];
            max += prices[i] * freqs[i];
        }

        System.out.println(min + " " + max);

        s.close();
    }
}
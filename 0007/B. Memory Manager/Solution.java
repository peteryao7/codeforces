import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/7/B
     * 
     * 218 ms / 3756 KB
     * 
     * Do as the question says. Note that the alloc'd memory block must be one
     * continuous block and can't be split up.
     * 
     * For alloc, do a two pass. First, make sure a gap in the memory of size n
     * exists. If so, start inserting it in the second pass as leftmost as
     * possible to make as much room as possible for later allocs. Otherwise,
     * print NULL.
     * 
     * For erase, simply set all memory blocks containing x to 0. If x doesn't
     * exist, print ILLEGAL_ERASE_ARGUMENT.
     * 
     * For defragment, we can use an offset to directly write to the proper
     * index or a writer iterator. Both work, but I opt for the former. Don't
     * forget to clean up everything after the writer index or offset.
     * 
     * TC/SC - O(m)/O(m) for all methods
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int m = s.nextInt();
        int[] memory = new int[m];
        int allocIdx = 0;

        for (int j = 0; j < t; j++) {
            switch (s.next()) {
                case "alloc":
                    int n = s.nextInt();
                    int len = 0;
                    boolean canAlloc = false;
                    for (int i = 0; i < m; i++) {
                        if (memory[i] == 0)
                            len++;
                        else
                            len = 0;
                        if (len == n) {
                            canAlloc = true;
                            len = i - n + 1;
                            break;
                        }
                    }
                    if (canAlloc) {
                        allocIdx++;
                        for (int i = len; i < len + n; i++)
                            memory[i] = allocIdx;
                        System.out.println(allocIdx);
                    }
                    else
                        System.out.println("NULL");
                    break;
                case "erase":
                    int x = s.nextInt();
                    if (x <= 0) {
                        System.out.println("ILLEGAL_ERASE_ARGUMENT");
                        break;
                    }
                    boolean hasErased = false;
                    for (int i = 0; i < m; i++) {
                        if (memory[i] == x) {
                            memory[i] = 0;
                            hasErased = true;
                        }
                    }
                    if (!hasErased)
                        System.out.println("ILLEGAL_ERASE_ARGUMENT");
                    break;
                case "defragment":
                    int d = 0; // offset
                    for (int i = 0; i < m; i++) {
                        if (memory[i] == 0)
                            d++;
                        else
                            memory[i - d] = memory[i];
                    }
                    for (int i = m - d; i < m; i++)
                        memory[i] = 0;
                    break;
                default:
                    System.out.println("h");
                    break;
            }
        }

        s.close();
    }
}
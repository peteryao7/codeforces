import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/4/problem/C
     * 
     * 1870 ms / 3884 KB
     * 
     * To see whether a name has already been chosen, use a HashMap to store
     * already used names and to find those names in O(1). Use the name as the
     * key and the number to append to it as the value, as if multiple people
     * want the same username, then we would assign them as name1 and name2,
     * for example.
     * 
     * TC/SC - O(1)/O(n)
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        // <name, number to append>
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = s.next();

            if (map.containsKey(name)) {
                int num = map.get(name);
                map.put(name, num + 1);
                System.out.println(name + num);
            }
            else {
                map.put(name, 1);
                System.out.println("OK");
            }
        }

        s.close();
    }
}
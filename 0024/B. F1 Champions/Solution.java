import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/contest/24/problem/B
     * 
     * 374 ms / 0 KB
     * 
     * Implementation problem, do what the question says. We can use a map to
     * make sure each case sensitive name is associated with its own Driver
     * class and stats.
     * 
     * TC/SC - O(nlogn)/O(n) for each race where n = # drivers
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] p = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        Map<String, Driver> map = new HashMap<>();
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            for (int j = 0; j < n; j++) {
                String name = s.next();
                Driver d = map.computeIfAbsent(name, k -> new Driver(name));
                d.places[j]++;
                if (j < 10)
                    d.score += p[j];
            }
        }

        List<Driver> drivers = new ArrayList<>(map.values());

        drivers.sort((s1, s2) -> {
            int diffPts = s2.score - s1.score;
            if (diffPts != 0)
                return diffPts;
            for (int i = 0; i < 50; i++) {
                diffPts = s2.places[i] - s1.places[i];
                if (diffPts != 0)
                    return diffPts;
            }
            return 0;
        });
        System.out.println(drivers.get(0).name);

        drivers.sort((s1, s2) -> {
            int firstPlaces = s2.places[0] - s1.places[0];
            if (firstPlaces != 0)
                return firstPlaces;
            int diffPts = s2.score - s1.score;
            if (diffPts != 0)
                return diffPts;
            for (int i = 1; i < 50; i++) {
                diffPts = s2.places[i] - s1.places[i];
                if (diffPts != 0)
                    return diffPts;
            }
            return 0;
        });
        System.out.println(drivers.get(0).name);

        s.close();
    }

    public static class Driver {
        String name;
        int score;
        int[] places;

        public Driver(String nm) {
            name = nm;
            score = 0;
            places = new int[50];
        }
    }
}
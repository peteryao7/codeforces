import java.util.*;

public class Solution {
    /*
     * https://codeforces.com/problemset/problem/19/A
     * 
     * 248 ms / 3800 KB
     * 
     * Implementation exercise. Use a Team class to keep track of each team's
     * name, points, and number of goals made and lost.
     * 
     * TC/SC - O(nlog(n))/O(n) for n = number of teams
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        Map<String, Team> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = s.next();
            map.put(name, new Team(name));
        }

        for (int i = 0; i < n * (n - 1) / 2; i++) {
            String teamNames = s.next();
            int hypIdx = teamNames.indexOf('-');
            String nameA = teamNames.substring(0, hypIdx);
            String nameB = teamNames.substring(hypIdx + 1);

            String scores = s.next();
            int colIdx = scores.indexOf(':');
            int scoreA = Integer.parseInt(scores.substring(0, colIdx));
            int scoreB = Integer.parseInt(scores.substring(colIdx + 1));
            Team teamA = map.get(nameA);
            Team teamB = map.get(nameB);

            teamA.goalsMade += scoreA;
            teamB.goalsMade += scoreB;
            teamA.goalsLost += scoreB;
            teamB.goalsLost += scoreA;
            teamA.points += scoreA > scoreB ? 3 : scoreA == scoreB ? 1 : 0;
            teamB.points += scoreB > scoreA ? 3 : scoreA == scoreB ? 1 : 0;

            map.put(nameA, teamA);
            map.put(nameB, teamB);
        }

        Team[] teams = new Team[n];

        int j = 0;
        for (String name : map.keySet()) {
            teams[j++] = map.get(name);
        }

        Arrays.sort(teams, new Comparator<Team>() {
            @Override
            public int compare(Team a, Team b) {
                if (a.points == b.points) {
                    if (a.goalsMade - a.goalsLost == b.goalsMade - b.goalsLost) {
                        return b.goalsMade - a.goalsMade;
                    }
                    return (b.goalsMade - b.goalsLost) - (a.goalsMade - a.goalsLost);
                }
                return b.points - a.points;
            }
        });

        String[] winners = new String[n / 2];
        for (int i = 0; i < n / 2; i++) {
            winners[i] = teams[i].name;
        }

        Arrays.sort(winners);
        for (String w : winners)
            System.out.println(w);
        
        s.close();
    }

    public static class Team {
        String name;
        int points, goalsMade, goalsLost;

        public Team(String name) {
            this.name = name;
            points = 0;
            goalsMade = 0;
            goalsLost = 0;
        }
    }
}
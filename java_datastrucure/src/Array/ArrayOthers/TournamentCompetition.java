package Array.ArrayOthers;

import java.util.HashMap;
import java.util.Map;

/**
 * There’s an algorithms tournament taking place in which teams of programmers compete against each other to solve algorithmic problems as fast as possible. Teams compete in a round robin,
 * where each team faces off against all other teams. Only two teams compete against each other at a time, and for each competition, one team is designated the home team, while the other
 * team is the away team. In each competition there’s always one winner and one loser; there are no ties. A team receives 3 points if it wins and 0 points if it loses. The winner of the
 * tournament is the team that receives the most amount of points.
 * <p>
 * Given an array of pairs representing the teams that have competed against each other and an array containing the results of each competition, write a function that returns the winner
 * of the tournament. The input arrays are named competitions and results, respectively. The competitions array has elements in the form of [homeTeam, awayTeam], where each team is a
 * string of at most 30 characters representing the name of the team. The results array contains information about the winner of each corresponding competition in the competitions array.
 * Specifically, results[i] denotes the winner of competitions[i], where a 1 in the results array means that the home team in the corresponding competition won and a 0 means that the away team won.
 * <p>
 * It’s guaranteed that exactly one team will win the tournament and that each team will compete against all other teams exactly once. It’s also guaranteed that the tournament will always
 * have at least two teams.
 * <p>
 * Sample Input
 * [homeTeam, awayTeam]
 * <p>
 * competitions = [
 * ["HTML", "C#"],
 * ["C#", "Python"],
 * ["Python", "HTML"],
 * ]
 * results = [0, 0, 1]
 * <p> 1 - home team won
 * 0 - the away team won
 * <p>
 * Sample Output
 * "Python"
 * // C# beats HTML, Python Beats C#, and Python Beats HTML.
 * // HTML - 0 points
 * // C# -  3 points
 * // Python -  6 points
 */
public class TournamentCompetition {


    public static void main(String args[]) {
        String[][] competitions = {{"HTML", "C#"}, {"C#", "Python"}, {"Python", "HTML"}};
        int[] results = {0, 0, 1};

        for (String[] row : competitions) {
            for (String column : row) {
                //   System.out.print(column);
                //   System.out.print(" - ");
            }
            // System.out.println("");
        }
        System.out.println(compileResults(competitions, results));
    }

    public static String compileResults(String[][] competitors, int[] results) {

        Map<String, Integer> scores = new HashMap<>();
        int index = 0;
        int maxSore = 0;
        int totalScores = 0;
        String champion = "";

        for (String[] row : competitors) {
            int matchResult = results[index];
            String winner = null;
            // home team won
            if (matchResult == 1) {
                winner = row[0];
            } else {
                //away tean won
                winner = row[1];
            }

            if (scores.containsKey(winner)) {
                totalScores = scores.get(winner) + 3;
                scores.put(winner, totalScores);
            } else {
                scores.put(winner, 3);
            }
            if (totalScores > maxSore) {
                maxSore = totalScores;
                champion = winner;
            }
            index++;
        }

        return champion;
    }


}

package ArraysSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Tournament {

	public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

		int x = 0;
		Map<String, Integer> scores = new HashMap<String, Integer>();
		String champion = "";
		Integer maxPoints = 0;

		for (ArrayList<String> game : competitions) {
			int result = results.get(x);
			String winner = "";

			if (result == 1) {
				winner = game.get(0);
			} else {
				winner = game.get(1);
			}
			//System.out.println(winner);
			int points = 0 ;
			if (scores.containsKey(winner)) {
				points = scores.get(winner) + 3;
				scores.put(winner,points );
			} else {
				points = 3;
				scores.put(winner, points);
			}
			
			if (points > maxPoints ) {
				maxPoints = points;
				champion = winner;
				//System.out.println(champion);
			}
			x++;
		}

		//System.out.println(scores);

		return champion;
	}

	public static void main(String args[]) {

		ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
		ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
		ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
		ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
		competitions.add(competition1);
		competitions.add(competition2);
		competitions.add(competition3);
		ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
		System.out.println("Champion:");
		System.out.println(tournamentWinner(competitions,results));
		
	}

}

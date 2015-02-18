//Kumar Lama  24/10/2014

import java.util.ArrayList;
import java.util.Scanner;

public class GameCount {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		String[] datas = input.nextLine().split("\\s");
		int n = Integer.parseInt(datas[0]);
		int counter = 0;
		String firstTeam = "";
		String secondTeam = "";

		datas = input.nextLine().split("\\s");
		while (counter < n) {

			firstTeam = datas[2];
			secondTeam = datas[4];
			System.out.println(secondTeam);

			ArrayList<String> team1 = new ArrayList<String>();
			ArrayList<String> team2 = new ArrayList<String>();

			String gameTitle = input.nextLine().trim();

			while (!gameTitle.startsWith("Game")) {
				if (gameTitle.matches("\\*"))
					break;
				String[] pieces = gameTitle.split("\\s");
				if (pieces[0].equals(firstTeam))
					team1.add(pieces[2].concat(" " + pieces[3]));
				else if (pieces[0].equals(secondTeam))
					team2.add(pieces[2].concat(" " + pieces[3]));
				gameTitle = input.nextLine().trim();

			}

			datas = gameTitle.split("\\s");

			int team1Score = team1.size();
			int team2Score = team2.size();

			if (team1Score > team2Score) {
				System.out.printf("Game %d, %s %d %s %d, winning goal by %s\n",
						counter + 1, firstTeam, team1Score, secondTeam,
						team2Score, team1.get(team2Score));
			} else
				System.out.printf("Game %d, %s %d %s %d, winning goal by %s\n",
						counter + 1, secondTeam, team2Score, secondTeam,
						team1Score, team2.get(team1Score));
			counter++;
		}

	}
}

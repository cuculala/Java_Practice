import java.util.ArrayList;

import java.util.Scanner;

public class ccsclottery {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		String[] numbers = input.nextLine().split("\\s");
		int colors = Integer.parseInt(numbers[0]);
		int balls = Integer.parseInt(numbers[1]);

		ArrayList<ArrayList> ballColor = new ArrayList<>();
		for (int i = 0; i < colors * balls; i++) {
			numbers = input.nextLine().split("\\s");
		}

		for (int i = 0;; i++) {

		}

	}

}

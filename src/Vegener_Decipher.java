import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Scanner;

public class Vegener_Decipher {

	private static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<Character> alpha = new ArrayList<Character>();

		for (int i = 0; i < 26; i++) {
			alpha.add((char) (65 + i));
		}

		while (keyboard.hasNext()) {

			String line = keyboard.nextLine();
			if (line.equals("#"))
				return;

			String[] tokens = line.split("\\s");
			String text = tokens[tokens.length - 1];
			String ED = tokens[tokens.length - 2];

			ArrayList<Integer> codes = new ArrayList<Integer>();

			for (int i = 0; i < tokens.length - 2; i++) {
				codes.add(Integer.parseInt(tokens[i]));
			}

			int i = 0;

			if (ED.equals("E")) {
				do {

					Character c = text.charAt(i);
					int pos = alpha.indexOf(Character.toUpperCase(c));
					char ch = alpha.get((pos + codes.get(i)) % 26);
					out.print(c.isUpperCase(c) ? Character.toUpperCase(ch)
							: Character.toLowerCase(ch));
					i++;

				} while (i < text.length());

			} else {
				i = 0;
				do {

					Character c = text.charAt(i);
					int pos = alpha.indexOf(Character.toUpperCase(c));
					int index = pos - codes.get(i);
					char ch = (char) alpha.get(index < 0 ? index + 26 : index);
					out.print(c.isUpperCase(c) ? Character.toUpperCase(ch)
							: Character.toLowerCase(ch));
					i++;

				} while (i < text.length());

			}
			out.println();
		}

		keyboard.close();

	}
}

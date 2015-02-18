import java.util.Scanner;

public class lookandsay {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int testCases = Integer.parseInt(input.nextLine());
		while (testCases > 0) {

			String line = input.nextLine();
			int counter = 0;
			int i = 0;
			String op = "";
			do {

				while (line.substring(i, i + 1).equals(
						line.substring(i + counter, i + counter + 1))) {
					counter++;
					if (i + counter == line.length())
						break;
				}
				op = op.concat(String.format("%d%s", counter,
						line.substring(i, i + 1)));
				i += counter;
				counter = 0;

			} while (i < line.length() - 1);
			System.out.println(op);
		}

	}

}

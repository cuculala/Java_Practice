import java.util.Scanner;

public class Conversions {

	private static final Scanner moreinput = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.next());

		while (testCases > 0) {
			String[] line = moreinput.nextLine().split("\\s");

			float quantity = (float) Double.parseDouble(line[0]);
			String units = line[1];
			System.out.println(units);

			if (units.equals("kg")) {
				System.out.printf("%2.4f lb\n", quantity * 2.2046);
			} else if (units.equals("l")) {
				System.out.printf("%.4f g\n", quantity * 0.2642);
			} else if (units.equals("lb")) {
				System.out.printf("%.4f kg\n", quantity * 0.4536);
			} else if (units.equals("g")) {
				System.out.printf("%.4f l\n", quantity * 3.7854);
			}
		}
	}

}

import java.util.Scanner;

public class BracketsBalanceTest {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int testCases = Integer.parseInt(input.next());

		while (testCases > 0) {
			StringBuilder tester = new StringBuilder(input.next());

			String parenthesis = "()", bracket = "[]";

			int counter = 0;
			while (tester.length() > 0) {
				if (tester.length() == 0 || counter + 1 == tester.length())
					break;// I think we dont need to test if length is 0
				String part = tester.substring(counter, counter + 2);
				if (part.equals(parenthesis) || part.equals(bracket)) {
					tester.replace(counter, counter + 2, "");
					counter = 0;
				} else
					counter++;
			}

			if (tester.length() == 0)
				System.out.println("Balanced");

			else
				System.out.println("UnBalanced");

			testCases--;
		}
	}

}
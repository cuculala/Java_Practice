import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

public class RunLength {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		out.println("Welcomefsadfdf to prgo");
		int counter = Integer.parseInt(input.nextLine());

		while (counter > 0) {
			String lines[] = input.nextLine().split("\\s");
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for (String ss : lines) {
				nums.add(Integer.parseInt(ss));
			}

			int i = 0;
			String output;

			do {

				int count = 1;
				while (nums.get(i) == (nums.get(i + count))
						&& i + count < lines.length - 1) {
					count++;
				}

				if (count > 3) {
					output = String.format("ff %02d %02d ", nums.get(i), count);
					i = i + count;
				} else {
					output = String.format("%02d ", nums.get(i));
					i++;
				}
				out.print(output);

			} while (i < lines.length - 1);

			out.println();
		}

	}

}

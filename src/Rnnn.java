import java.util.ArrayList;

import java.util.Scanner;
import static java.lang.System.out;

public class Rnnn {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		out.println("Welcome to sdfasf prgo");
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
				int temp = i;
				while (nums.get(temp) == (nums.get(1 + temp))) {
					count++;
					temp++;
					if (temp == lines.length - 1) {
						break;
					}
				}

				if (count > 3) {
					output = String.format("ff %02d %02d ", nums.get(i), count);
					i = temp;
				} else {
					output = String.format("%02d ", nums.get(i));

				}
				out.print(output);
				i++;

			} while (i < lines.length - 1);
			if (nums.get(lines.length - 1) != nums.get(lines.length - 2))
				out.println(nums.get(lines.length - 1));

		}

	}

}

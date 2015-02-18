
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Josephes {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int testCases = Integer.parseInt(input.nextLine().trim()), counter = 0;

		while (counter < testCases) {

			String[] datas = input.nextLine().split("\\s");
			int people = Integer.parseInt(datas[0]), passes = Integer
					.parseInt(datas[1]);

			ArrayList<Integer> nums = new ArrayList<Integer>();
			for (int i = 0; i < 5; i++) {
				nums.add(i + 1);
			}

			int n = nums.size(), position = 0;

			while (n != 0) {
				position = (position + passes % n) % n;
				System.out.print(nums.get(position) + " ");
				nums.remove(position);
				n = nums.size();
			}
			System.out.println();
			counter++;
		}
	}

}

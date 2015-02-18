import java.util.Scanner;

public class MagicClock {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		int testCases = Integer.parseInt(input.nextLine());

		while (testCases > 0) {

			String[] times = input.nextLine().split(":");
			int hour = Integer.parseInt(times[0]);
			int min = Integer.parseInt(times[1]);
			int sec = Integer.parseInt(times[2]);
			int hm = Math.abs(hour - min);
			int ms = Math.abs(sec - min);
			int magic = 0;
			if (hm == ms) {
				System.out.println("This is magic time");
				continue;
			} else if (hm > 30)
				hm = 60 - hm;
			else if (ms > 30) {
				ms = 60 - ms;
			}
			if (hm > ms)
				magic = hm - ms;
			else if (ms > hm) {
				magic = (60 - sec) + hour * 5 - hm;
			}
			System.out.println("The next magic time is " + magic);

			testCases--;
		}

	}

}

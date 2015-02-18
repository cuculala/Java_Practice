import java.util.HashMap;
import java.util.Scanner;

public class XORReductions {

	public static final Scanner keyboard = new Scanner(System.in);
	public static final Scanner keys = new Scanner(System.in);

	public static void main(String[] args) {

		// while(keyboard.hasNext()){
		int numberGates = Integer.parseInt(keyboard.next());
		int counter = numberGates;
		String[] inputs = keys.nextLine().split("\\s");

		String gate1 = inputs[1];
		String gate2 = inputs[2];
		String output = "";
		HashMap<Integer, String> outs = new HashMap<Integer, String>();
		// System.out.println(gate1);
		while (numberGates > 0) {
			if (gate1.equals(gate2)) {
				output = "F";
				outs.put(numberGates, output);
				System.out.println(outs.get(gate1));
			} else {
				output = "T";
				outs.put(numberGates, output);
			}

			numberGates--;

			if (numberGates > 0) {
				inputs = keys.nextLine().split("\\s");

				gate1 = inputs[1];
				gate2 = inputs[2];
				if (outs.containsKey(gate1)) {
					gate1 = outs.get(gate1);
				} else if (outs.containsKey(gate2))
					gate2 = outs.get(gate2);

			}
		}
		System.out.println(outs.get(counter - 1));
	}

	// }

}

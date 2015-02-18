import static java.lang.System.out;

public class RemoveChars {

	public static void main(String[] args) {

		StringBuilder str = new StringBuilder("Helllllo, lllllalllal");
		String removers = "al";

		boolean[] flags = new boolean[128];

		for (int i = 0; i < removers.length(); i++) {

			flags[removers.charAt(i)] = true;

		}

		for (int j = 0; j < str.length(); j++) {
			if (!flags[str.charAt(j)]) {
				out.println(str.charAt(j));
			}

		}

	}

}

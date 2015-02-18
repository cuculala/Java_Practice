import java.util.ArrayList;

import static java.lang.System.out;

public class PermutationsStrings {

	public static ArrayList<String> permute(String str) {

		if (str == null)
			return null;

		ArrayList<String> listPermutes = new ArrayList<String>();

		if (str.length() == 0) {
			listPermutes.add("");
			return listPermutes;
		}

		char first = str.charAt(0);
		String remaining = str.substring(1);
		ArrayList<String> subPermutes = permute(remaining);

		for (String word : subPermutes) {

			for (int i = 0; i <= word.length(); i++) {
				StringBuilder ss = new StringBuilder(word);
				String fin = ss.insert(i, first).toString();
				listPermutes.add(fin);
			}
		}

		return listPermutes;

	}

	public static void main(String[] args) {
		ArrayList<String> ss = permute("abc");
		for (String te : ss)
			out.println(ss + " " + ss.size());

		StringBuilder st = new StringBuilder("abcd");
		out.println(st.insert(4, 'k'));

	}

}

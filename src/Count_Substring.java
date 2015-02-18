import java.util.HashSet;

public class Count_Substring {

	public static int totalSubstring(char A, char B, String str) {
		int countA = 0, totalsubstr = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == A)
				countA++;
			else if (str.charAt(i) == B)
				totalsubstr += countA;
			else {

			}
		}

		return totalsubstr;
	}

	public static void main(String[] args) {

		String ss = "Lamo pet";
		System.out.println(totalSubstring('a', 'b', "ab ab ab"));

		HashSet<Character> set = new HashSet<Character>();
		for (char c : ss.toCharArray()) {
			if (set.contains(c))
				System.out.println("Exists Already");
			set.add(c);
		}
		if (set.size() < ss.length())
			System.out.println(set.size() + " " + ss.length() + " Not unique");
		else
			System.out.println(" Unique");

	}

}

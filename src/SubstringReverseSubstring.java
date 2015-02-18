public class SubstringReverseSubstring {

	public static void main(String[] args) {

		String test = "This is substring test string to ...";
		int len = test.length();
		for (int i = 0; i < len - 3; i++) {
			String sub1 = test.substring(i, i + 3);
			for (int j = len - 1; j >= 2; j++) {
				String sub2 = test.substring(len - i - 3, len - i);
				if (sub1 == sub2) {
					System.out.println("String equal");
				}
			}
		}

	}

}

import static java.lang.System.out;

import java.util.Scanner;

public class TestString {

	// "(((())))[][][[]]";
	private static Scanner input = new Scanner(System.in);

	public interface Growabl {
		final static double pi = 90.0;

		void grow(String s, Integer i);

		void Jizz(Integer siso);
	}

	public interface Eatable {
		void much();

		void Jizz(String pa);
	}

	public class Beans implements Growabl, Eatable {

		@Override
		public void much() {
			// TODO Auto-generated method stub
			System.out.println(Beans.pi + Growabl.pi + this.pi
					+ ((Growabl) this).pi);

		}

		@Override
		public void grow(String s, Integer i) {
			// TODO Auto-generated method stub

		}

		@Override
		public void Jizz(String siso) {
			// TODO Auto-generated method stub

		}

		@Override
		public void Jizz(Integer siso) {
			// TODO Auto-generated method stub

		}

	}

	public static int digitToValue(char c) {
		if (c >= '0' && c <= '9')
			return c - '0';
		else if (c >= 'A' && c <= 'F')
			return 10 + c - 'A';
		else if (c >= 'a' && c <= 'f')
			return 10 + c - 'a';
		return -1;
	}

	public static void String_BuilderTest() {
		String str1 = "abc";
		String str2 = str1;

		str1 += "d";

		out.println(str1 + " " + str2 + " " + (str1 == str2));

		StringBuilder sb1 = new StringBuilder("abc");
		StringBuilder sb2 = sb1;
		sb2.append("d");
		out.println(sb1 + " " + sb2 + " " + (sb1 == sb2));
	}

	public static int covertToBase(String number, int base) {
		if (base < 2 || (base > 10 && 16 != base))
			return -1;
		int value = 0;
		for (int i = number.length() - 1; i >= 0; i++) {

			int digit = digitToValue(number.charAt(i));
			out.println(digit + "digit ");
			if (digit < 0 || digit >= base) {
				return -1;
			}
			int exp = number.length() - 1 - i;
			value += digit * Math.pow(base, exp);
		}
		return value;
	}

	public static void main(String[] args) {

		//Scanner inp = new Scanner(System.out);
		//String sa = inp.next();
		//System.out.println("Got it" + sa.length());
		//inp.close();

		out.println(covertToBase("A", 15));
		int[] ra = { 2, 1, 0, 5, -9, 10 };
		out.println(ra);
		final String testString = "   Game* lama kumar 12 claflin  ";
		testString.trim();
		int nums[] = { 1, 10, 20 };
		int i = 0;
		// int a = ++nums[i++];
		nums[i++] += 2;
		out.println(" " + nums[0] + " " + nums[1] + " " + nums[2] + " " + i);
		out.println(testString.substring(2, 4));
		out.println(testString);
		BracketsBalanceTest bct = new BracketsBalanceTest();
		Class<?> typeint = BracketsBalanceTest.class;
		out.println(typeint);

		// testString = testString.trim();

		// if (testString.startsWith("Game")){
		// String [] pieces = testString.split("\\s");
		// System.out.println(pieces[0]);
		// }
		// int ss = Integer.parseInt(input.nextLine());
		// int count = 0;
		// while(count < ss){
		// System.out.println(input.nextLine());
		// ss--;
		// }
		//
		// int counter =0;
		// if (testString.matches(Pattern.quote("()"))){
		//
		// //testString=testString.replaceAll(".*\\[\\].*", " ");
		// //String str=testString.replaceAll(".*\\(\\).*", "");
		// System.out.println("Hello");
		//
		// }
		//
		// if (testString.matches("[(\\(\\)).*(\\[\\]).*]"))
		// System.out.println(testString);
		//
		// while(testString.matches(".*[(\\(\\))(\\[\\])].*")){
		// System.out.println(testString);

		// }

	}

}

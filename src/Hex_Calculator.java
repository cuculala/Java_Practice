public class Hex_Calculator {

	public static void main(String[] args) {

		StringBuilder Number = new StringBuilder("#ff0c");
		StringBuilder Hex = new StringBuilder(Number.replace(0, 1, ""));

		String ss = Hex.toString();
		int decimal = 76;// Integer.parseInt(ss,16);

		System.out.println(decimal);
		ss = Integer.toHexString(decimal);

		Hex = new StringBuilder(ss);
		ss = "#".concat(Hex.toString());
		System.out.println(ss);

	}

}

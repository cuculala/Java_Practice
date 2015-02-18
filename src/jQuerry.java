import java.util.Scanner;

public class jQuerry {

	private jQuerry() {

	}

	private static final Scanner input = new Scanner(System.in);
	private static final Scanner moreinput = new Scanner(System.in);

	public static void main(String[] args) {

		// String ss = "#ff6666 #6666ff 1000 800";//input.next();

		int testCases = Integer.parseInt(input.next());

		while (testCases > 0) {

			String ss = moreinput.nextLine();
			String[] arrays = ss.split("\\s");

			String Color1 = arrays[0];
			String Color2 = arrays[1];
			int duration = Integer.parseInt(arrays[2]);
			int middleTime = Integer.parseInt(arrays[3]);

			int R1, G1, B1, R2, G2, B2;

			R1 = Integer.parseInt(Color1.substring(1, 3), 16);
			G1 = Integer.parseInt(Color1.substring(3, 5), 16);
			B1 = Integer.parseInt(Color1.substring(5, 7), 16);
			R2 = Integer.parseInt(Color2.substring(1, 3), 16);
			G2 = Integer.parseInt(Color2.substring(3, 5), 16);
			B2 = Integer.parseInt(Color2.substring(5, 7), 16);

			float R, G, B;
			float ratio = (float) middleTime / duration;
			// System.out.println("KumarJi"+ middleTime);
			if (R1 >= R2)
				R = R1 - ((R1 - R2) * (ratio));
			else
				R = R1 + ((R2 - R1) * (ratio));
			if (G1 >= G2)
				G = G1 - ((G1 - G2) * (ratio));
			else
				G = G1 + ((G2 - G1) * (ratio));
			if (B1 >= B2)
				B = B1 - ((B1 - B2) * (ratio));
			else
				B = B1 + ((B2 - B1) * (ratio));

			String hex = String.format("#%02x%02x%02x", (int) R, (int) G,
					(int) B);
			System.out.println(hex);
			testCases--;

		}
	}

}

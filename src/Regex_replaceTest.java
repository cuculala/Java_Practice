import java.util.regex.Pattern;

public class Regex_replaceTest {
	public static final String EXAMPLE = "This () () () () is Kumar Testing a Regex FIle System Kumar";

	public static void main(String[] args) {

		String reg = ".*\\\\(\\\\).*";
		String text = EXAMPLE;

		System.out.println(EXAMPLE.replaceAll("(\\(\\))", "DOOOMMBAAA")
				.toString());

	}

}

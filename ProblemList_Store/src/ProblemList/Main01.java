package ProblemList;

import java.util.Scanner;
// 대소변환
public class Main01 {
	public static void main(String[] args) {

		String input = "";
		String output = "";
		int text;
		Scanner scan = new Scanner(System.in);
		input = scan.nextLine();

		for (int i = 0; i < input.length(); i++) {
			text = (int) input.charAt(i);

			if ((text >= 65) && (text <= 90)) {
				output += (char) (text + 32);
			}

			else if ((text >= 97) && (text <= 122)) {
				output += (char) (text - 32);
			}

			else {
				output += (char) text;
			}
		}

		System.out.println(output);

	}
}

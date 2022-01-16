package ProblemList;

import java.util.Scanner;

class Main02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int num = Integer.parseInt(input.nextLine());

		for (int i = 1; i <= 2 * num - 1; i++) {
			for (int j = 1; j <= num; j++) {

				if (i < num && j <= i) {
					System.out.printf("*");
				}

				else if (i >= num && i + j <= 2 * num) {
					System.out.printf("*");
				}

				else {
					System.out.printf(" ");
				}
			}

			System.out.println();
		}

	}
}
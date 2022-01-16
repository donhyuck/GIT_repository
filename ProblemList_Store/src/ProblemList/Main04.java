package ProblemList;

import java.util.Scanner;

public class Main04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int r = input.nextInt();

		for (int k = 1; k <= r; k++) {
			for (int i = 1; i < 2 * num; i++) {
				for (int j = 1; j <= num; j++) {

					if (i < num && j == i) {
						System.out.printf("*");
					}

					else if (i >= num && i + j == 2 * num) {
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
}

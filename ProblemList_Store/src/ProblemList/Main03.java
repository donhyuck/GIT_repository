package ProblemList;

import java.util.Scanner;

class Main03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int num = Integer.parseInt(input.nextLine());
		int check = num / 2;

		for (int i = 1; i <= num; i += 2) {

			for (int j = 1; j <= (num / 2) + (i / 2) + 1; j++) {
				if (j <= check) {
					System.out.print(" ");
				}

				else {
					System.out.print("*");
				}
			}

			check--;

			System.out.println();
		}
	}
}
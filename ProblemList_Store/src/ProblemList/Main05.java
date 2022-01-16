package ProblemList;

import java.util.Scanner;

public class Main05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();
		int max = num;
		int sum = 0;

		int[] arr = new int[num];

		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = input.nextInt();
			sum += arr[i - 1];
			max += i;
		}

		System.out.printf("%d", max - sum);
	}
}

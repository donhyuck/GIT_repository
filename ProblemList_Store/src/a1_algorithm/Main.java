package a1_algorithm;

import java.util.Scanner;

// class Solution 교체
// 가로 a칸, 세로 b칸
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		for (int j = 1; j <= b; j++) {

			for (int i = 1; i <= a; i++) {
				System.out.printf("*");
			}

			System.out.println();
		}
	}
}
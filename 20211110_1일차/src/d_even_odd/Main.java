package d_even_odd;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		// scanner를 이용해 입력값이 짝수면 even
		// 홀수면 odd
		// 출력하는 프로그램 만들어주세요.

		// 숫자를 입력해주세요 : (입력후 엔터)
		// odd 혹은 even (출력)
		Scanner input = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요 : ");
		int num = Integer.parseInt(input.nextLine());

		if (num % 2 == 0) {
			System.out.println("even");
		}

		else {
			System.out.println("odd");
		}

	}
}
// 1284 : 암호 해독
// 어떤 수(n)가 입력되면
// 두 소수의 곱으로 나타낼 수 있으면 두 소수를 오름차순으로 출력하고,
// 그렇지 않으면 "wrong number"를 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int x = 0;
		int y = 0;

		Scanner input = new Scanner(System.in);
		int num = input.nextInt();

		for (int i = 1; i < num; i++) {

			if (num % i == 0) {
				if (get_prime(i) == 1 && get_prime(num / i) == 1) {
					x = i;
					y = num / i;
					break;

				}

			}

		}

		if (x != 0 && y != 0) {
			System.out.printf("%d %d", x, y);
		}

		else {
			System.out.println("wrong number");
		}
	}

	static int get_prime(int number) {
		if (number == 1) {
			return 0;
		}
		if (number == 2) {
			return 1;
		}

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return 0;
			}
		}

		return 1;
	}
}

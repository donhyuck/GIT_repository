package b_gugudan;

import java.util.Scanner;
//Scanner를 이용해 입력값을 받아
// 구구단을 원하는 단이 나오게 해주세요.

// 예시) 원하는 단을 입력해주세요 : 4 (입력후 엔터)

// 4단 출력.

class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.printf("원하는 단을 입력해주세요 : ");
			int dan = Integer.parseInt(input.nextLine());
			
			if (dan == 0) {
				System.out.println("구구단 종료");
				break;
			}
			
			System.out.printf("== %d단 ==\n", dan);

			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", dan, i, dan * i);
			}

		}
	}
}

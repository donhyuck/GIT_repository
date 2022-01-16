package c_introduce;

//이름과 나이를 입력값으로 받아 자기소개를 해주세요.

import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("이름을 입력해주세요:");
		String name = input.nextLine();
		System.out.println("나이를 입력해주세요:");
		int age = Integer.parseInt(input.nextLine());

		System.out.printf("안녕하세요 %d세 %s입니다.", age, name);
		// 출력 : 안녕하세요 29세 홍길동입니다.

	}
}

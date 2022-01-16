package a_input_output_upgrade;
// 입출력 개선 버전
import java.util.Scanner;

//Scanner를 이용해서 아래와 같이 입출력 하여 사칙연산을 수행해주세요.
//입출력 예시
//첫번째 숫자를 입력해주세요: 12
//두번째 숫자를 입력해주세요: 33
//12 + 33 = 45

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.printf("첫번째 숫자를 입력해주세요: ");
		int a = Integer.parseInt(input.nextLine());

		System.out.printf("두번째 숫자를 입력해주세요: ");
		int b = Integer.parseInt(input.nextLine());

		System.out.printf("%d + %d = %d", a, b, a + b);
	}
}
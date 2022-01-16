package e_sum_n_to_m;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int 결과1 = Math.nToMSum(2, 3);
		System.out.println("결과1 : " + 결과1);
		// 출력 : 결과1 : 5

		int 결과2 = Math.nToMSum(5, 10);
		System.out.println("결과2 : " + 결과2);
		// 출력 : 결과2 : 45

//		Scanner input = new Scanner(System.in);
//		System.out.printf("a와 b를 입력하시오 : ");
//		int a = input.nextInt();
//		int b = input.nextInt();
//
//		int 결과3 = Math.nToMSum(a, b);
//		System.out.println(a + "부터 " + b + "까지의 합 : " + 결과3);

	}
}

class Math {

	static int nToMSum(int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i;
		}

		return sum;
	}

}
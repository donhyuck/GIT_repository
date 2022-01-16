package d_sum_1_to_n;

public class Main {
	public static void main(String[] args) {
		// 예시 시작
		int c = 20 + Math.더하기(10, 20);
		System.out.println(c);
		// 예시 끝

		int 결과1 = Math.oneToSum(3);
		System.out.println("결과1 : " + 결과1);
		// 출력 : 결과1 : 6

		int 결과2 = Math.oneToSum(10);
		System.out.println("결과2 : " + 결과2);
		// 출력 : 결과2 : 55
	}
}

class Math {
	// static => 본사직원
	// static은 현재 클래스에 지금당장 존재한다.

	static int 더하기(int a, int b) {
		// 메인 메서드의 int c와 아래 int c는 전혀 관계가 없다.
		int c = a + b;

		// return 값의 타입과 함수명의 앞부분이 같아야 한다.
		// return => 변신
		return c;
	}

	static int oneToSum(int end) {
		// 메인 메서드의 int c와 아래 int c는 전혀 관계가 없다.
		int sum = 0;
		for (int i = 1; i <= end; i++) {
			sum += i;
		}

		// return 값의 타입과 함수명의 앞부분이 같아야 한다.
		// return => 변신
		return sum;
	}
}
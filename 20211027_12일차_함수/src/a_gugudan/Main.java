package a_gugudan;
//문제 : 구구단을 만들어주세요

//출력양식
/*
== 2단 ==
2 * 1 = 2
2 * 2 = 4
2 * 3 = 6
...
== 9단 ==
9 * 1 = 9
...
9 * 9 = 81
*/

public class Main {
	public static void main(String[] args) {
		int dan;
		dan = 8;
		new 구구단출력기().작동(dan);
		new 구구단출력기().작동(7);
	}
}

class 구구단출력기 {
	// 구현시작
	static void 작동(int dan) {
		System.out.printf("=== %d단 ===\n", dan);
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}
	}
	// 구현끝
}
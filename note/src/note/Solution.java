package note;
// 1420 : 3등 찾기

// 첫째 줄에 n이 입력된다. ( 3 <= n <= 50 )
// n명의 친구들 중 정보 성적이 3번째로 높은 친구에게 묻고자 한다.
// 둘째 줄 부터 n+1행까지 친구의 이름과 점수가 공백으로 분리되어 입력된다. 이름은 영문

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();
		int temp;

		int[] arr = new int[num];
		String[] students = new String[num];

		for (int i = 0; i < num; i++) {
			students[i] = input.next();
			arr[i] = input.nextInt();
		}

		for (int a = 0; a < num - 1; a++) {
			for (int b = a + 1; b < num; b++) {
				if (arr[b] > arr[a]) {
					temp = arr[b];
					arr[b] = arr[a];
					arr[a] = temp;
				}
			}
		}

		System.out.println(students[num-3]);

	}
}

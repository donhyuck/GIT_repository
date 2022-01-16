package save;
/*
 탑욕법 - 문제 설명
여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다.
학생들의 번호는 체격 순으로,
바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있다.
예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만
체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.

전체 학생의 수 n
체육복을 도난당한 학생들의 번호가 담긴 배열 lost
여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve
체육수업을 들을 수 있는 학생의 최댓값을 return

제한사항
전체 학생의 수 n : 2명 이상 30명 이하
체육복을 도난당한 학생의 수 lost : 1명 이상 n명 이하, 중복x
여벌의 체육복을 가져온 학생의 수 reserve : 1명 이상 n명 이하, 중복x
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.


 * */

public class Main01 {

	public int solution(int n, int[] lost, int[] reserve) {

		int answer = 0;
		int[] total = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			total[i] = 1;
		}

		for (int l : lost) {
			total[l]--;
		}

		for (int r : reserve) {
			total[r]++;
		}

		if (total[1] == 0 && total[2] == 2) {
			total[1] = 1;
			total[2] = 1;
		}

		if (total[n - 1] == 2 && total[n] == 0) {
			total[n - 1] = 1;
			total[n] = 1;
		}

		for (int i = 2; i < n; i++) {
			if (total[i] == 0) {
				if (total[i - 1] == 2) {
					total[i] = 1;
					total[i - 1] = 1;
				}

				else if (total[i + 1] == 2) {
					total[i] = 1;
					total[i + 1] = 1;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			System.out.printf("%d ", total[i]);
		}

		for (int i = 1; i <= n; i++) {
			if (total[i] >= 1) {
				answer++;
			}
		}

		return answer;

	}
}
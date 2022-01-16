package pro;

/*
// 탑욕법 큰 수 만들기
어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하기
예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] => 이 중 가장 큰 숫자는 [94]
문자열 형식으로 숫자 number / 제거할 수의 개수 k /  solution 함수의 매개변수
number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return
*/
public class Solution {
	public String solution(String number, int k) {
		String answer = "";
		String[] bita = number.split("");
		String[] bitb = number.split("");

		for (int i = 0; i < number.length(); i++) {
			for (int j = 0; j < number.length(); j++) {

				if (Integer.parseInt(bita[i] + bitb[j]) > Integer.parseInt(answer) && i < j) {
					answer = bita[i] + bitb[j];
					System.out.println(answer);
				}
			}
		}

		return answer;
	}
}

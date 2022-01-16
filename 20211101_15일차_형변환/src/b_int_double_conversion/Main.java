package b_int_double_conversion;
//문제 : 정수 i가 가지고 있는 10을 double 형 변수에 넣고 해당 변수의 값을 다시 i에 넣는 코드를 작성해주세요.

public class Main {
	public static void main(String[] args) {
		int i = 10;
		double d = i; // 여기선 자동형변환 허용, 왜냐? 안전하다고 판단되어 자동형변환이 된것
		// 정수 10 -> 실수 10.0 으로 변환되는 과정 중 버려지는 값이 없음
		i = (int) d; // 여기선 자동형변환 불가능, 왜냐? 문제가 발생할 가능성이 있으니까. 값을 잃을 수도 있음
		// 개발자의 싸인이 있어야함. 개발자의 의도가 개입.
		// 문제가 될 수 있지만 "내 뜻은 이게 맞다" 라고 자바에게 알려줌

		System.out.println(d);
	}
}

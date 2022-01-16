package e_person_Arm;

public class Main {
	public static void main(String[] args) {
		사람 a사람 = new 사람();

		// 리모콘호출 객체.~~~
		a사람.나이 = 20;
		a사람.a왼팔 = new 팔();
		// a사람 리모콘으로 사람과 팔을 조종할수있다.
	}
}

class 사람 {
	// 클래스안에 변수를 정의 할 수 있다.
	int 나이;
	// 사람이 팔을 갖는다.
	팔 a왼팔;
	
}

class 팔 {
	// 팔은 길이를 갖는다.
	int 길이;

}
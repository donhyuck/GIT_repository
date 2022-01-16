package d_weapon_detail_explain;

public class Main {
	public static void main(String[] args) {
		무기 a무기 = new 칼();

		// `a무기` 변수(창고)에게 접근한다.
		// 창고의 문을 연다.
		// 무기가 있을 줄 알았는데 무기 리모콘이 있다.
		// 무기리모콘의 버튼중에서 `공격` 버튼을 누르려고 시도한다.
		// 버튼을 못찾아서 실패!!

		// * 안되는 이유
		// 실제로 리모콘에 연결된 칼 객체는 `공격` 기능을 가지고 있다.
		// 안되는 이유는 단순히 버튼이 없어서 이다.
		a무기.공격();
	}
}

class 무기 {
	// 버튼을 잃어버리지 않게 하는 용도의 메서드
	// = 추상메서드(Abstract method)
	void 공격() {}
}

class 칼 extends 무기 {
	void 공격() {
		System.out.println("칼공격");
	}
}

class 활 extends 무기 {
	void 공격() {
		System.out.println("활공격");
	}
}
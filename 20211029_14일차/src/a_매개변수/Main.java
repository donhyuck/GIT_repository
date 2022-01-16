package a_매개변수;

public class Main {
	public static void main(String[] args) {
		// 문제1
		// 무기 클래스로 만든 리모콘으로 칼 객체를 조종
		무기 a무기 = new 칼();
		a무기.공격();
		// 출력 : 칼로 공격합니다.
		double d = 5;
		// 자동 형변환이 되어 5.0 이 된다.

		// 문제2 : 매개변수를 사용해서 전사가 매번 다르게 공격하도록 해주세요.
		// 문제3 : 마지막 공격방식을 기억
		전사 a전사 = new 전사();

		a전사.공격("브라이언", "칼");
		// 브라이언이(가) 칼(으)로 공격합니다.

		a전사.재공격();
		// 브라이언이(가) 칼(으)로 공격합니다.

		a전사.공격("필립", "창");
		// 필립이(가) 창(으)로 공격합니다.

		a전사.공격("마크", "지팡이");
		// 마크(가) 지팡이(으)로 공격합니다.

		a전사.재공격();
		// 마크(가) 지팡이(으)로 공격합니다.

		a전사.재공격();
		// 마크(가) 지팡이(으)로 공격합니다.
	}
}

// 문제1
class 무기 {
	void 공격() {
		System.out.println("칼로 공격합니다.");
	}

	// void 공격() {}
	// 있기만 하면 버튼으로 작용하여 칼에서 고쳐쓸수있다.
}

class 칼 extends 무기 {
//	void 공격() {
//		System.out.println("칼로 공격합니다.");
//	}

	// 칼이 무기가 되면서 공격을 잃어버림. 버튼이 탈락함
}

// 문제2 and 문제3
class 전사 {
	String last_soldier;
	String last_weapon;

	void 공격(String soldier, String weapon) {
		// 지역변수 이므로 백업을 해두지 않으면 함수 종료와 함께 사라짐
		this.last_soldier = soldier;
		// last_soldier = soldier; 이렇게도 가능
		last_weapon = weapon;

		// System.out.printf("%s이(가) %s(으)로 공격합니다.\n", soldier, weapon);
		// 또는
		재공격(); // 만 두기(하청두는셈)
	}

	void 재공격() {
		System.out.printf("%s이(가) %s(으)로 공격합니다.\n", last_soldier, last_weapon);

	}
}
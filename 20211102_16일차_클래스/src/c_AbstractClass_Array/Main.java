package c_AbstractClass_Array;

//추상클래스와 인터페이스
class Main {
	public static void main(String[] args) {
		칼 a무기1 = new 칼();
		활 a무기2 = new 활();
		총 a무기3 = new 총();

		System.out.println("== 모든 무기 작동, 수동버전 ==");
		a무기1.작동();
		a무기2.작동();
		a무기3.작동();

		// 배열에 담기 무기들이라는 배열
		무기[] 무기들 = new 무기[3];
		무기들[0] = a무기1;
		무기들[1] = a무기2;
		무기들[2] = a무기3;

		System.out.println("== 모든 무기 작동, 자동버전 ==");
		for (int i = 0; i < 무기들.length; i++) {
			무기 a무기 = 무기들[i];
			a무기.작동();
		}
	}
}

//단 1개라도 추상메서드를 가지는 클래스는 추상클래스로 만들어야 한다.
//abstract 키워드는 해당 클래스가 추상 클래스라는 뜻 이다.
// 보통 메서드는 있어야 하는데, 구현은 필요없는 경우에 추상메서드로 만들면 좋다.
// 추상화를 하면 반드시 오버라이드를 해야함.
// 추상화를 안했을때는 해도 되고 안해도 되었음/ 추상화를 하면 자유를 제한하고, 의무가 많아짐 
// 여럿이서 작업을 하려면 문법적으로 쓸데없는 일을 줄이려는 의도임.
// 이건 버튼 전용이야 작업하지 마세요.

// 즉, 추상클래스는 선택이다. 의도의 차이이다.
// 추상 메서드를 하나라도 가지는 클래스는 추상클래스이다.
// 순도 100% 추상메서드로 이루어진 클래스는 인터페이스가 될 수 있다.
// 인터페이스는 다중구현이 가능하다.
abstract class 무기 {
	abstract void 작동();
}

class 칼 extends 무기 {
	void 작동() {
		System.out.println("칼 작동");
	}
}

class 활 extends 무기 {
	void 작동() {
		System.out.println("활 작동");
	}
}

class 총 extends 무기 {
	void 작동() {
		System.out.println("총 작동");
	}
}

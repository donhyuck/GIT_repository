package d_Interface;

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

		// 배열에 담기
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

// 인터페이스는 추상클래스와 달리 순도 100% 추상클래스 이다.
// 어차피 인터페이스 안에는 추상메서드만 들어올 수 있기 때문에, 아래의 abstract 키워드는 생략가능하다.

interface 부엌도구 {
	abstract void 작동();
}

interface 무기 {
	void 작동();
}

//인터페이스는 다중구현이 가능
//다중구현을 다중상속으로 이해해도 됨
// 상속은 implements 로 표현하고, public void 로 표현해야함
// 다중상속을 받아도 괜찮은 이유는?
// 기능이 없는 것이 인터페이스 이므로 오버라이딩으로 구현을 해서 써야하므로

class 칼 implements 무기, 부엌도구 {
	public void 작동() {
		System.out.println("칼이 작동");
	}
}

class 활 implements 무기 {
	public void 작동() {
		System.out.println("활 작동");
	}
}

class 총 implements 무기 {
	public void 작동() {
		System.out.println("총 작동");
	}
}

package a_explain_coding;

public class Main {
	public static void main(String[] args) {

	}
}

// c + s + F 하지않기 서술형 저장용
/*
// =======================================================================
문제 - 코드의 내용이 의미하는 바를 모두 써주세요. int 변수

class Main {
	public static void main(String[] args) {
		// a에는 정수가 들어간다.
		int a;
	}
}
// =======================================================================
문제 - 코드의 내용이 의미하는 바를 모두 써주세요. 클래스

class Main {
	public static void main(String[] args) {
		// class 무기 { void 공격() { } } 의 의미
		// 무기 설계도 를 만들었다. 
		// 무기 설계도에는 공격 버튼이 있다.

		// 칼은 무기이다.		
		// 칼은 공격버튼과 사과를 깍다 버튼이 있다.
	}
}

class 무기 {
	void 공격() { }
}

class 칼 extends 무기 {
	void 사과를_깍다() { }
}
// ==========================================================================
// 문제 - 코드의 내용이 의미하는 바를 모두 써주세요. 레퍼런스 변수(리모콘 변수)

class Main {
	public static void main(String[] args) {
		게임.작동하다();
	}
}

class 게임 {
	static void 작동하다() {
		// 설명
		무기 a무기;
		
		// 설명
		a무기 = new 무기();
	}
}

class 무기 {
	void 공격() { }
}
// ===========================================================
문제 - 코드의 내용이 의미하는 바를 모두 써주세요. 상속

class Main {
	public static void main(String[] args) {
		// `class 칼 extends 무기 { }` 의 의미 설명
	}
}

class 무기 {
	void 공격() { }
}

class 칼 extends 무기 {
	void 사과껍질제거() { }
}
// ============================================================
// 문제 : `무기 a무기 = new 칼();` 가 실행되는 세부과정을 자세히 쓰세요.
// 문제 - 무기 클래스로 만든 리모콘으로 칼 객체를 조종하는 과정 설명

class Main {
  public static void main(String[] args) {
    // * double d = 5.5; 의 처리과정
    // 1 : 실수 5.5가 생긴다.
    // 2 : 오직 실수만 담을 수 있는 변수 d가 생성된다.
    // 3 : d는 5.5가 자신안에 들어 올 수 있는지 판단한다.(가능)
    // 4 : d변수에 실수 5.5가 들어간다.
    double d = 5.5;
    
    // * double dd = 5; 의 처리과정
    // 1 : 정수 5가 생긴다.
    // 2 : 오직 실수만 담을 수 있는 변수 dd가 생성된다.
    // 3 : dd는 5가 자신안에 들어 올 수 있는지 판단한다.
    // 4 : 5는 정수이기 때문에 들어 올 수 없다고 판단한다.(불가능)
    // 5 : dd가 아쉬워하는 5에게 이렇게 이야기 합니다. `니가 실수로 변환될 수 있다면 들어올 수 있다.`
    // 6 : 5는 자신의 형태를 버리고 실수화 한다. 즉 5.0으로 변신하다.(캐스팅, 또는 형변환)
    // 7 : dd로 5.0이 들어간다.
    double dd = 5;
    
    // * int i = 5.5; 의 처리과정
    // 1 : 실수 5.5가 생긴다.
    // 2 : 오직 정수만 담을 수 있는 변수 i가 생성된다.
    // 3 : i는 5.5가 자신에게 담길 수 있는지 체크한다.(불가능)
    // 4 : i는 아쉬워하는 5.5에게 이렇게 이야기 합니다. `니가 정수가 된다면 들어올 수 있다.`
    // 5 : 5.5는 도저히 불가능 요구를 받고 치명적인 에러를 발생시킨다.(캐스팅 불가능 으로 인한 에러)
    //int i = 5.5;
    
    
    무기 a무기 = new 칼();
  }
}

class 무기 {
  
}

class 칼 {
  
}
 */
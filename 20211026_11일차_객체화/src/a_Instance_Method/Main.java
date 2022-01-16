package a_Instance_Method;
/*
//문제 : 사람을 말하게 해주세요.

class main {
	public static void main(String[] args) {
		사람 a사람 = new 사람();
		a사람.말하다();
	}
}

class 사람 {
// 사람은 `말하다` 라는 기능을 가지고 있습니다.
	void 말하다() {
		System.out.println("사람이 말합니다.");
	}
}
*/

//문제 : 아래 코드가 실행되도록 해주세요.

class Main {
	public static void main(String[] args) {
		거북이 a거북이 = new 거북이();

		a거북이.걷다();
		// 출력 => 걷다
		a거북이.수영하다();
		// 출력 => 수영하다
	}
}

class 거북이 {
	void 걷다() {
		System.out.println("걷다");
	}

	void 수영하다() {
		System.out.println("수영하다");
	}
}
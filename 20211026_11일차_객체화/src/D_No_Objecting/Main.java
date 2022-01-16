package D_No_Objecting;

//문제 : 아래 코드가 실행되도록 자동차 클래스를 만들어주세요.

class Main {
	public static void main(String[] args) {
		자동차.달리다();
	}
}

class 자동차 {
	// static을 사용하면 객체화 없이 설계도에 있는 능력을 바로 쓸 수 있습니다.
	// 달리다 메서드를 만들때 앞에 static을 붙이면 달리다 메서드는 static 메서드가 됩니다.
	// static 메서드는 함수라고도 불립니다.

	static void 달리다() {
		System.out.println("자동차가 달립니다.");
	}
}

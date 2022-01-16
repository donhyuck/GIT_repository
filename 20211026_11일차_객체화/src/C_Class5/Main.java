package C_Class5;

//문제 : 클래스 5개 이상 만들고 각각을 객체화 하여 메서드를 호출해주세요.

class Main {
	public static void main(String[] args) {
		new 위().움직이다();

		아래 down;
		down = new 아래();
		down.움직이다();

		좌 left = new 좌();
		left.움직이다();

		우.움직이다(); // 객체없이 리모컨 실행

		정지 stop;
		stop = new 정지();
		stop.멈추다();
	}
}

class 위 {
	void 움직이다() {
		System.out.println("위로 이동");
	}
}

class 아래 {
	void 움직이다() {
		System.out.println("아래로 이동");
	}
}

class 좌 {
	void 움직이다() {
		System.out.println("좌로 이동");
	}
}

class 우 {
	static void 움직이다() {
		System.out.println("우로 이동");
	}
}

class 정지 {
	void 멈추다() {
		System.out.println("제자리");
	}
}

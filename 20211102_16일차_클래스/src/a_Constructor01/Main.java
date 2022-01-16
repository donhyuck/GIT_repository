package a_Constructor01;

class Main {
	public static void main(String[] args) {
		사람 a홍길동 = new 홍길동();
		System.out.printf("== 홍길동 정보 ==\n");
		System.out.printf("이름 : %s\n", a홍길동.이름); // 홍길동
		a홍길동.나이 = 25;
		System.out.printf("나이 : %s\n", a홍길동.나이); // 22
		사람 a홍길순 = new 홍길순();
		System.out.printf("== 홍길순 정보 ==\n");
		System.out.printf("이름 : %s\n", a홍길순.이름); // 홍길순
		System.out.printf("나이 : %s\n", a홍길순.나이); // 22
	}
}

class 사람 {
	String 이름;
	int 나이;

	사람() {
		this.나이 = 22;
	}
}

class 홍길동 extends 사람 {
	홍길동() {
		this.이름 = "홍길동";
	}
}

class 홍길순 extends 사람 {
	홍길순() {
		this.이름 = "홍길순";
	}
}

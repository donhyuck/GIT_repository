
public class Main {
	public static void main(String[] args) {
		car Car01 = new car();
		Car01.license_no = 123;
		Car01.color = "red";
		Car01.velocity = 210;
		Car01.model = "KIA";
		Car01.user = "홍길동";
		Car01.insurance = true;

		car Car02 = new car();
		Car02.license_no = 456;
		Car02.color = "yellow";
		Car02.velocity = 250;
		Car02.model = "HYUNDAI";
		Car02.user = "홍길순";
		Car02.insurance = false;

		introduce(Car01);
		System.out.println();

		introduce(Car02);

		Car01.running();
		Car02.running();
	}

	static void introduce(car CarName) {
		System.out.println("==자동차 소개==");
		System.out.printf("등록번호 : %d\n", CarName.license_no);
		System.out.printf("차량색깔 : %s\n", CarName.color);
		System.out.printf("최대속도 : %s km/h\n", CarName.velocity);
		System.out.printf("제 조 사 : %s\n", CarName.model);
		System.out.printf("운 전 자 : %s\n", CarName.user);
		System.out.printf("보험가입 : %b\n", CarName.insurance);
	}
}

class car {
	int license_no;
	String color;
	int velocity;
	String model;
	String user;
	boolean insurance;

	void running() {
		if (velocity > 230) {
			System.out.println("차량이 달립니다.");
		}
	}
}
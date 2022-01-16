package CarVelocity;

public class Main {
	public static void main(String[] args) {
		// 구현시작
		자동차 a자동차1 = new 자동차();
		자동차 a자동차2 = new 자동차();

		a자동차1.lisense_no = 1;
		a자동차1.velocity = 230;

		a자동차2.lisense_no = 2;
		a자동차2.velocity = 210;

		// 구현끝

		a자동차1.달리다();
		// 출력 => 자동차가 최고속력 230km로 달립니다.

		a자동차2.달리다();
		// 출력 => 자동차가 최고속력 210km로 달립니다.
	}
}

class 자동차 {
	// 구현
	int lisense_no;
	int velocity;

	void 달리다() {
		System.out.println(this.lisense_no + "번 자동차가 최고속력 " + this.velocity + "km로 달립니다.");
		System.out.printf("%d번 자동차가 최고속력 %dkm로 달립니다.\n", this.lisense_no, this.velocity);
	}
}

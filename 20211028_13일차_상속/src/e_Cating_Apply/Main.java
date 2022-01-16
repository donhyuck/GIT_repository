package e_Cating_Apply;

//문제 : 아래가 실행되도록 해주세요.
public class Main {
	public static void main(String[] args) {
		무기 a무기 = new 칼();

		칼 a칼 = new 칼();
		a칼 = new 활();
	}
}

class 무기 {

}

class 칼 extends 무기 {

}

class 활 extends 칼 {

}
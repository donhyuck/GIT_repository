
public class Main {
	public static void main(String[] args) {
		// 철수, 영희, 영수
		int[] ages = new int[3];
		// 기본형의 경우 0, 1, 2 ...로 이름이 매겨지고, 사용자가 지정할 수 없다.

		ages[0] = 10;
		ages[1] = 20;
		ages[2] = 30;
		// System.out.println(ages[0] + ages[1] + ages[2]);           // 방번호로 호출

		// 타입을 철수로 두고 철수에 대해 설명
		// 철수의 개인정보 이름 나이 키 결혼 여부
		// 자료형에는 2가지, 기본자료형과 참조형이 있다.
		// char, int, float...

		IntArr3 ages2 = new IntArr3();
		ages2.key0 = 10;
		ages2.key1 = 20;
		ages2.key2 = 30;
		// System.out.println(ages2.key0 + ages2.key1 + ages2.key2);  // 이름으로 호출

		Note note = new Note();
		note.num = 40;
		note.tf = true;
		note.text = "Hello Wrold!";
		System.out.println(note.num);
		System.out.println(note.tf);
		System.out.println(note.text);
	}
}

//기본타입이면 그냥 쓰지만 설계도가 없는 격이기 때문에 class로 설계해야한다.
// 하나의 타입이 아니고 여러 타입이 섞여있다.
class IntArr3 {
	int key0;
	int key1;
	int key2;
}

class Note {
	int num;
	boolean tf;
	String text;
}

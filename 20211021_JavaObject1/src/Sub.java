
public class Sub {
	public static void main(String[] args) {
		Person a = new Person();
		// 앞으로 a에는 Mycustom으로 되어있는 객체를 (연결)할거야
		a.age = 25;
		a.isMarried = true;
		a.name = "영희";
		a.introduce();
	}
}

class Person {
	// 명사 3개
	int age;
	boolean isMarried;
	String name;

	// 동사 1개 -> 행동할 수 있다.
	void introduce() {
		// int age = this.age;
		// String name = this.name;
		System.out.println("==자기소개==");
		System.out.printf("이름 : %s\n", this.name);
		System.out.printf("나이 : %d\n", this.age);
		System.out.printf("결혼여부 : %b\n", this.isMarried);
	}
}
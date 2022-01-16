package a_IncreaseId_Method;

// 게시판 구현
public class Main {
	public static void main(String[] args) {
		// 배열을 조종하는 리모콘
		// 게시물 10개를 꽃을 배열이 생김
		Article[] articles = new Article[10];

//		// 모양에 맞는 메서드를 찾아간다.
//		Article testArticle = new Article(1, "2021-11-19"); // #b
//
//		// 게시물 1개 생김
//		Article article1 = new Article(); // #a
//		articles[0] = article1;
//
//		// 게시물 2개 생김
//		Article article2 = new Article();
//		articles[1] = article2;

		// 이와 동일하며 만들어지자마자 첫번째,두번째,세번째 꼿음
		articles[0] = new Article();
		articles[1] = new Article();
		articles[2] = new Article();

		System.out.println(articles[0].id);
		System.out.println(articles[1].id);
		System.out.println(articles[2].id);
	}
}

class Article {
	// 자바프로그램실행(F11)되면 딱 한 번실행
	// 하나만 존재하며 클래스에 있다. (공유자원)
	static int LastId;
	// * 결과적으로 객체가 하나씩 생길때 마다 id가 1씩 증가하여 기억한다.

	// 객체마다 하나씩 있다.
	int id;
	String regDate;

	// static요소 전용 생성자
	static {
		LastId = 0;
	}

	Article() {
		// this.id = LastId;

		// 다른 생성자 호출
		// Article(int id, String regDate) 를 실행하고
		this(LastId + 1, "2021-11-19");
		
		// LastId 1증가
		LastId++;
	}

	Article(int id, String regDate) {
		this.id = id;
		this.regDate = regDate;
	}
}
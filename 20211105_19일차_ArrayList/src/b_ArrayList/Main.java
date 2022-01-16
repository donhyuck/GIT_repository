package b_ArrayList;

import java.util.ArrayList;
import java.util.List;

// 게시판 구현
public class Main {
	public static void main(String[] args) {

		exam1();
		exam2();
		exam3();
		exam4();

	}

	static void exam1() {
		Article[] articles = new Article[1000];

		int articleSize = 0;
		articles[0] = new Article();
		articleSize++;
		articles[1] = new Article();
		articleSize++;
		articles[2] = new Article();
		articleSize++;
		articles[3] = new Article();
		articleSize++;

		for (int i = 0; i < articleSize; i++) {
			System.out.println(articles[i].id);
		}
	}

	// 위의 형태보다 깔끔한 버전의 ArrayList
	// 내부적으로 자릿수를 체크한다.
	static void exam2() {
		ArrayList articles = new ArrayList();
//		articles.add(10);
//		articles.add(true);

		articles.add(new Article());
		articles.add(new Article());
		articles.add(new Article());
		articles.add(new Article());
		articles.add(new Article());

		for (int i = 0; i < articles.size(); i++) {

			Article article = (Article) articles.get(i);
			System.out.println(article.id);
		}
	}

	static void exam3() {
		ArrayList<Article> articles = new ArrayList<Article>();
		// article만 들어가도록 제한
		articles.add(new Article());
		articles.add(new Article());
		articles.add(new Article());
		articles.add(new Article());
		articles.add(new Article());

		for (int i = 0; i < articles.size(); i++) {
			// 들어있는 article뿐이니 형변환이 필요없다.
			Article article = articles.get(i);
			System.out.println(article.id);
		}
	}

	static void exam4() {
		// 아래 형태를 많이 쓴다.
		List<Article> articles = new ArrayList();

		articles.add(new Article());
		articles.add(new Article());
		articles.add(new Article());
		articles.add(new Article());
		articles.add(new Article());

		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			System.out.println(article.id);
		}
	}
}

class Article {
	// 하나만 존재하며 클래스에 있다. (공유자원)
	static int LastId;

	int id;
	String regDate;

	static {
		LastId = 0;
	}

	Article() {
		this(LastId + 1, "2021-11-19");
		LastId++;
	}

	Article(int id, String regDate) {
		this.id = id;
		this.regDate = regDate;
	}
}
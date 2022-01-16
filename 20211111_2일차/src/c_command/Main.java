package c_command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 그래서 2개 이상의 데이터가 쓰인다면 객체로 표현하는 것이 좋다.
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// 변경 1 : 객체로 묶기
		List<Article> articles = new ArrayList<>();

		// 필요없어짐
//		List<String> titles = new ArrayList<>();
//		List<String> bodies = new ArrayList<>();
//		List<Integer> ids = new ArrayList<>();

		int lastId = 1;

		while (true) {
			System.out.printf("명령어 : ");
			String command = input.nextLine();

			command.trim();

			if (command.length() == 0) {
				continue;
			}
			
			// 변경 2 :  객체로 변경함에 따라 다르게 표현
			if (command.equals("list")) {
				System.out.println("===  게시물 목록  ===");
				for (int i = 0; i < articles.size(); i++) {
					// articles.get(i) 는 덩어리 상태이기 때문에
					Article currentArticle = articles.get(i);
					System.out.printf("%d번째 글 ㅣ %s\n", currentArticle.id, currentArticle.title);
				}
			}

			else if (command.equals("write")) {

				// 게시물의 번호, 제목, 내용
				int id = lastId++;

				System.out.printf("제목 : ");
				String title = input.nextLine();

				System.out.printf("내용 : ");
				String body = input.nextLine();

				// 변경 3 : 묶기
				// id, title, body 3가지를 모아 상자에 담은 것이 게시물이 된다.
				Article article = new Article(id, title, body);
				articles.add(article);

				// 필요가 없어짐
//				titles.add(title);
//				bodies.add(body);
//				ids.add(id);

				System.out.println("게시물 등록이 완료되었습니다.");
			}

			else {
				System.out.printf("%s : 존재하지 않는 명령어입니다.\n", command);
			}
		}
	}
}

class Article {
	int id;
	String title;
	String body;

	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}
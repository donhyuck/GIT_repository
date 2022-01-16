package d_command_detail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 들어가는 내용 길수도 짧을수도 있다.
// 제목이 동일할 수 도있다.
// 식별가능하도록 번호가 있으며, detail도 번호로 선택가능해야 한다.
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		List<Article> articles = new ArrayList<>();

		int lastId = 1;

		while (true) {
			System.out.printf("명령어 : ");
			String command = input.nextLine();

			command.trim();

			if (command.length() == 0) {
				continue;
			}

			// 게시물 목록
			if (command.equals("list")) {
				System.out.println("===  게시물 목록  ===");
				for (int i = 0; i < articles.size(); i++) {
					// articles.get(i) 는 덩어리 상태이기 때문에
					Article currentArticle = articles.get(i);
					System.out.printf("%d번째 글 ㅣ %s\n", currentArticle.id, currentArticle.title);
				}
			}

			// 게시물 작성
			else if (command.equals("write")) {

				// 게시물의 번호, 제목, 내용
				int id = lastId++;

				System.out.printf("제목 : ");
				String title = input.nextLine();

				System.out.printf("내용 : ");
				String body = input.nextLine();

				Article article = new Article(id, title, body);
				articles.add(article);

				System.out.println("게시물 등록이 완료되었습니다.");
			}

			// 게시물 내용
			// detail 과 번호로 명령어 호출
			else if (command.startsWith("detail ")) {
				// split -> 공백으로 구분
				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[1]);

				Article targetArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article currentArticle = articles.get(i);

					if (currentArticle.id == id) {
						targetArticle = currentArticle;
					}
				}

				// null참조에서 오류 발생
				if (targetArticle == null) {
					System.out.printf("%d번 게시물이 존재하지 않습니다.\n", id);
					continue;
				}

				System.out.printf("번호 : %d\n", targetArticle.id);
				System.out.printf("제목 : %s\n", targetArticle.title);
				System.out.printf("내용 : %s\n", targetArticle.body);
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
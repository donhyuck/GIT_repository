package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.dto.Article;
import board.util.Util;

public class App {
	// ArrayList가 main 내부에 있으면 메서드가 접근할 수 없다.
	// main메서드가 아니면 된다.
	// ** static
	// 변경이후론 static 이 아니어도 된다.

	// 접근지정자 private
	private static List<Article> articles;

	// static 을 위한 생성자는 static 이다.
	App() {
		articles = new ArrayList<>();
	}

	// ** static끼리만 통신가능
	// 변경이후론 static 이 아니어도 된다.
	public void start() {
		System.out.println("==프로그램 시작==");

		// 실행과 함께 테스터를 3개 만든다.
		makeTestData();

		Scanner sc = new Scanner(System.in);

		// 글번호를 기억할 필요x
		// int lastId = 1;

		while (true) {
			System.out.print("명령어 : ");
			String command = sc.nextLine();

			command.trim();

			if (command.length() == 0) {
				continue;
			}

			// # 1
			if (command.startsWith("article list")) {

				if (articles.size() == 0) {
					System.out.println("게시물이 없습니다.");
					continue;
				}

				// String searchKeyword = command.substring(13);
				String searchKeyword = command.substring("article list".length()).trim();

				// article 리모콘을 복사해서 줌(기존 변수와 동일한 역할, 조종사가 한명 더 생긴것)
				List<Article> forListArticles = articles;

				// 검색어가 있다면
				if (searchKeyword.length() > 0) {
					forListArticles = new ArrayList<>();

					// 게시글을 뒤져봐서 일치하는 걸 쌓아담는다.
					for (Article article : articles) {
						if (article.title.contains(searchKeyword)) {
							forListArticles.add(article);
						}
					}

					if (forListArticles.size() == 0) {
						System.out.println("검색결과가 존재하지 않습니다.");
						continue;
					}
				}


				System.out.printf("=== 게시물 목록 ===\n");

				System.out.println(" 번호 |    날짜    |   제목   |  조회수");

				// 목록에서 최신글 상단 노출
				for (int i = forListArticles.size() - 1; i >= 0; i--) {
					Article currentArticle = forListArticles.get(i);
					System.out.printf("%3d   | %4s |  %4s  | %4d\n", currentArticle.id, currentArticle.regDate,
							currentArticle.title, currentArticle.hit);
				}
			}

			// # 2
			else if (command.equals("article write")) {

				//// 글번호를 기억할 필요x
				int id = articles.size() + 1;

				System.out.printf("제목 : ");
				String title = sc.nextLine();

				System.out.printf("내용 : ");
				String body = sc.nextLine();

				String currentDate = Util.getCurrentDate();

				// 4개만 받아도 되는 이유는 이미 생성자로 조회수에 대한 정보가 포함되어 있기 때문이다.
				Article article = new Article(id, title, body, currentDate);
				articles.add(article);

				System.out.printf("%d번 게시물 등록이 완료되었습니다.\n", id);

				// # 3
				// detail, modify, delete 에는 공통적으로 게시글 번호를 찾는 기능이 포함되어 있다.
				// 메서드를 통해 이 중복을 없앤다.
			} else if (command.startsWith("article detail ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				// 중복제거
				Article targetArticle = getArticleById(id);

//				for (int i = 0; i < articles.size(); i++) {
//					Article currentArticle = articles.get(i);
//
//					if (currentArticle.id == id) {
//						targetArticle = currentArticle;
//					}
//				}

				if (targetArticle == null) {
					System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
					continue;
				}

				// 여기까지 오는 경우는 존재한다는 의미
				// 조회수 증가
				targetArticle.increaseHit();

				System.out.printf("번호 : %d\n", targetArticle.id);
				System.out.printf("제목 : %s\n", targetArticle.title);
				System.out.printf("내용 : %s\n", targetArticle.body);
				System.out.printf("작성일 : %s\n", targetArticle.regDate);
				System.out.printf("조회수 : %d\n", targetArticle.hit);

				// # 4
			} else if (command.startsWith("article delete ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				int foundIndex = getArticleIndexById(id);

				if (foundIndex == -1) {
					System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
					continue;
				}

				// 글이 아니라 index로서 삭제
				articles.remove(foundIndex);
				System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);

				// # 5
			} else if (command.startsWith("article modify ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				// 글 가져올때면 하청맡기면 된다.
				Article targetArticle = getArticleById(id);

				if (targetArticle == null) {
					System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
					continue;
				}

				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				targetArticle.title = title;
				targetArticle.body = body;

				System.out.printf("%d번 게시물이 수정되었습니다.\n", id);

			} else if (command.equals("system exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			else {
				System.out.printf("%s는 존재하지 않는 명령어입니다.\n", command);
			}
		}
	}

	// delete의 경우 index로 찾아야한다.
	private int getArticleIndexById(int id) {
		int i = 0;
		for (Article article : articles) {

			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

	private Article getArticleById(int id) {

//		for (int i = 0; i < articles.size(); i++) {
//			Article article = articles.get(i);
//			
//			// 목록의 게시글 id와 내가 입력한 id가 일치한다면
//			// 같은걸 찾은것임, 그 객체를 리턴함
//			if (article.id == id) {
//				return article;
//			}
//		}

		// 위의 코드를 더 줄이는 방법
		// 배열전용 반복문(향상된 for문)을 이용한다.
//		for (Article article : articles) {
//			if (article.id == id) {
//				return article;
//			}
//		}

		// 위의 코드를 더 더 줄이는 방법
		// index를 찾아주는 하청을 이용한다.
		int index = getArticleIndexById(id);

		// 찾았는데 -1이 아니라는 것 = 글이 존재한다.
		// 그렇다면 index에서 글을 끄집어낸다.
		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}

	// 변경이후론 static 이 아니어도 된다.
	private void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다.");

		// 5개의 요소
		articles.add(new Article(1, "제목1", "내용1", Util.getCurrentDate(), 11));
		articles.add(new Article(2, "제목2", "내용2", Util.getCurrentDate(), 22));
		articles.add(new Article(3, "제목3", "내용3", Util.getCurrentDate(), 33));
	}

	// 지역변수 => 인스턴스 변수 지역변수는 한 메서드 안에서만 사용가능
	// 인스턴스 변수는 같은 객체의 다른 메서드에서도 접근 가능
}

package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import board.Controller.ArticleController;
import board.Controller.MemberController;
import board.dto.Article;
import board.dto.Member;
import board.util.Util;

public class App {

	private List<Article> articles;
	private List<Member> members;

	App() {
		articles = new ArrayList<>();
		members = new ArrayList<>();
	}

	public void start() {
		System.out.println("==프로그램 시작==");

		makeTestData();

		Scanner sc = new Scanner(System.in);

		// Controller
		MemberController memberController = new MemberController(sc, members);
		ArticleController articleController = new ArticleController();

		while (true) {
			System.out.print("명령어 : ");
			String command = sc.nextLine();

			command.trim();

			if (command.length() == 0) {
				continue;
			}

			// 회원가입 창구
			if (command.equals("member join")) {
				// 가입할때 넘김
				memberController.dojoin();

			}

			else if (command.startsWith("article list")) {

				if (articles.size() == 0) {
					System.out.println("게시물이 없습니다.");
					continue;
				}

				String searchKeyword = command.substring("article list".length()).trim();

				List<Article> forListArticles = articles;

				if (searchKeyword.length() > 0) {
					forListArticles = new ArrayList<>();

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

				for (int i = forListArticles.size() - 1; i >= 0; i--) {
					Article currentArticle = forListArticles.get(i);
					System.out.printf("%3d   | %4s |  %4s  | %4d\n", currentArticle.id, currentArticle.regDate,
							currentArticle.title, currentArticle.hit);
				}
			}

			else if (command.equals("article write")) {

				int id = articles.size() + 1;

				System.out.printf("제목 : ");
				String title = sc.nextLine();

				System.out.printf("내용 : ");
				String body = sc.nextLine();

				String currentDate = Util.getCurrentDate();

				Article article = new Article(id, title, body, currentDate);
				articles.add(article);

				System.out.printf("%d번 게시물 등록이 완료되었습니다.\n", id);

			} else if (command.startsWith("article detail ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				Article targetArticle = getArticleById(id);

				if (targetArticle == null) {
					System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
					continue;
				}

				targetArticle.increaseHit();

				System.out.printf("번호 : %d\n", targetArticle.id);
				System.out.printf("제목 : %s\n", targetArticle.title);
				System.out.printf("내용 : %s\n", targetArticle.body);
				System.out.printf("작성일 : %s\n", targetArticle.regDate);
				System.out.printf("조회수 : %d\n", targetArticle.hit);

			} else if (command.startsWith("article delete ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

				int foundIndex = getArticleIndexById(id);

				if (foundIndex == -1) {
					System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
					continue;
				}

				articles.remove(foundIndex);
				System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);

			} else if (command.startsWith("article modify ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[2]);

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

		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}

	private void makeTestData() {
		System.out.println("테스트를 위한 데이터를 생성합니다.");

		articles.add(new Article(1, "제목1", "내용1", Util.getCurrentDate(), 11));
		articles.add(new Article(2, "제목2", "내용2", Util.getCurrentDate(), 22));
		articles.add(new Article(3, "제목3", "내용3", Util.getCurrentDate(), 33));
	}
}

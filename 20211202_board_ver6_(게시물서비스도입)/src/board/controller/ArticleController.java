package board.controller;

import java.util.List;
import java.util.Scanner;

import board.container.Container;
import board.dto.Article;
import board.dto.Member;
import board.service.ArticleService;
import board.util.Util;

public class ArticleController extends Controller {

	private Scanner sc;
//	private List<Article> articles;
	private String command;
	private String actionMethodName;
	private ArticleService articleService;

	public ArticleController(Scanner sc) {
		// 뒤에서 작업을 수행하므로 없어도 된다.
		// articles = Container.articleDao.articles;

		this.sc = sc;
		articleService = Container.articleService;
	}

	public void doAction(String command, String actionMethodName) {
		this.command = command;
		this.actionMethodName = actionMethodName;

		switch (actionMethodName) {
		case "list":
			showList();
			break;
		case "detail":
			showDetail();
			break;
		case "write":
			doWrite();
			break;
		case "modify":
			doModify();
			break;
		case "delete":
			doDelete();
			break;
		default:
			System.out.println("존재하지 않는 명령어입니다.");
			break;
		}
	}

	private void doWrite() {
		int id = articleService.getNewId();

		System.out.printf("제목 : ");
		String title = sc.nextLine();

		System.out.printf("내용 : ");
		String body = sc.nextLine();

		String regDate = Util.getCurrentDate();

		Article article = new Article(id, regDate, loginedMember.id, title, body);

		articleService.wrtie(article);

		System.out.printf("%d번 게시물 등록이 완료되었습니다.\n", id);
	}

	private void showList() {

//		if (articles.size() == 0) {
//			System.out.println("게시물이 없습니다.");
//			return;
//		}

		String searchKeyword = command.substring("article list".length()).trim();

		// 바로 가져오는 것이 아니라
		// List<Article> forListArticles = articles;

		// 이게 더 나은 구조이다.
		List<Article> forPrintArticles = articleService.getForPrintArticles(searchKeyword);

		if (forPrintArticles.size() == 0) {
			System.out.println("검색결과가 존재하지 않습니다.");
			return;
		}

		System.out.printf("=== 게시물 목록 ===\n");
		System.out.println(" 번호 |   작성자   |  제목   |  조회수");

		for (int i = forPrintArticles.size() - 1; i >= 0; i--) {
			Article currentArticle = forPrintArticles.get(i);

			String writeName = null;

			List<Member> members = Container.memberDao.members;

			for (Member member : members) {
				if (currentArticle.memberId == member.id) {
					writeName = member.name;
					break;
				}
			}

			System.out.printf("%3d   |  %5s  |  %4s | %4d\n", currentArticle.id, writeName, currentArticle.title,
					currentArticle.hit);
		}
	}

	private void showDetail() {
		String[] commandBits = command.split(" ");

		int id = Integer.parseInt(commandBits[2]);

		Article targetArticle = articleService.getArticleById(id);

		if (targetArticle == null) {
			System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
			return;
		}

		targetArticle.increaseHit();

		System.out.printf("번호 : %d\n", targetArticle.id);
		System.out.printf("제목 : %s\n", targetArticle.title);
		System.out.printf("작성자 : %d\n", targetArticle.memberId);
		System.out.printf("내용 : %s\n", targetArticle.body);
		System.out.printf("작성일 : %s\n", targetArticle.regDate);
		System.out.printf("조회수 : %d\n", targetArticle.hit);
	}

	private void doModify() {
		String[] commandBits = command.split(" ");

		int id = Integer.parseInt(commandBits[2]);

		Article foundArticle = articleService.getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
			return;
		}

		if (foundArticle.memberId != loginedMember.id) {
			System.out.println("해당 게시글에 대한 권한이 없습니다.");
			return;
		}

		System.out.printf("제목 : ");
		String title = sc.nextLine();
		System.out.printf("내용 : ");
		String body = sc.nextLine();

		foundArticle.title = title;
		foundArticle.body = body;

		System.out.printf("%d번 게시물이 수정되었습니다.\n", id);

	}

	private void doDelete() {
		String[] commandBits = command.split(" ");

		int id = Integer.parseInt(commandBits[2]);

		Article foundArticle = articleService.getArticleById(id);

		if (foundArticle == null) {
			System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
			return;
		}

		if (foundArticle.memberId != loginedMember.id) {
			System.out.println("해당 게시글에 대한 권한이 없습니다.");
			return;
		}

		// 감히 controller가 삭제를?
//		article.remove(foundArticle);
		articleService.remove(foundArticle);
		System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);
	}

	public void makeTestData() {
		System.out.println("테스트를 위한 게시물 데이터를 생성합니다.");

		Container.articleDao
				.add(new Article(Container.articleDao.getNewId(), Util.getCurrentDate(), 1, "제목1", "내용1", 11));
		Container.articleDao
				.add(new Article(Container.articleDao.getNewId(), Util.getCurrentDate(), 2, "제목2", "내용2", 22));
		Container.articleDao
				.add(new Article(Container.articleDao.getNewId(), Util.getCurrentDate(), 2, "제목3", "내용3", 33));
	}
}

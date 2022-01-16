package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import board.util.Util;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 2개 이상의 데이터를 효율적으로 관리하기 위해 객체 사용
		List<Article> articles = new ArrayList<>();

		int lastId = 1;

		while (true) {
			System.out.print("명령어 : ");
			String command = sc.nextLine();

			// 명령어의 공백 제거
			command.trim();

			// 명령어 미기입시, 반복입력요구
			if (command.length() == 0) {
				continue;
			}

			if (command.equals("list")) {
				System.out.printf("=== 게시물 목록 ===\n");

				for (int i = 0; i < articles.size(); i++) {
					Article currentArticle = articles.get(i);
					System.out.printf("%d  | %s | %s\n", currentArticle.id, currentArticle.regDate,
							currentArticle.title);
				}
			}

			else if (command.equals("write")) {
				// 번호, 제목, 내용
				int id = lastId++;

				System.out.printf("제목 : ");
				String title = sc.nextLine();

				System.out.printf("내용 : ");
				String body = sc.nextLine();

				// static 기능으로 쓰기 때문에 new 안붙여씀
				String currentDate = Util.getCurrentDate();

				// 3개를 모아 상자에 담는다.
				Article article = new Article(id, title, body, currentDate);
				// 모은 상자가 게시물이 된다.

				articles.add(article);

				System.out.printf("게시물 등록이 완료되었습니다.\n");

				// 내용확인을 위한 상세페이지
				// 게시물 번호로 데이터를 식별
				// startsWith : 특정문자열로 시작
			} else if (command.startsWith("detail ")) {

				// 공백으로 구분하여 배열저장
				String[] commandBits = command.split(" ");
				// detail 뒤의 숫자 = 게시물 번호
				int id = Integer.parseInt(commandBits[1]);

				// ** for문 밖에 targetArticle 생성
				Article targetArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article currentArticle = articles.get(i);

					if (currentArticle.id == id) {
						targetArticle = currentArticle;
					}
				}

				// 게시물이 없을 경우
				if (targetArticle == null) {
					System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
					continue;
				}

				// ** 생성된 targetArticle로 상세내용 호출
				System.out.printf("번  호 : %d\n", targetArticle.id);
				System.out.printf("제  목 : %s\n", targetArticle.title);
				System.out.printf("내  용 : %s\n", targetArticle.body);
				System.out.printf("작성일 : %s\n", targetArticle.regDate);

			} else if (command.startsWith("delete ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[1]);

				Article targetArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article currentArticle = articles.get(i);

					if (currentArticle.id == id) {
						targetArticle = currentArticle;
					}
				}

				if (targetArticle == null) {
					System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
					continue;
				}

				// 상세 명령어와 유사하며 아래 삭제 처리가 다르다.
				// targetArticle 라는 값으로 삭제
				articles.remove(targetArticle);
				System.out.printf("%d번 게시물이 삭제되었습니다.\n", id);

			} else if (command.startsWith("modify ")) {

				String[] commandBits = command.split(" ");

				int id = Integer.parseInt(commandBits[1]);

				Article targetArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article currentArticle = articles.get(i);

					if (currentArticle.id == id) {
						targetArticle = currentArticle;
					}
				}

				if (targetArticle == null) {
					System.out.printf("%d번 게시물이 존재하지 않습니다\n", id);
					continue;
				}

				// 새로운 제목과 내용
				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();

				// 새로운 제목과 내용을 받았으면 targetArticle로 바꿔준다
				targetArticle.title = title;
				targetArticle.body = body;

				System.out.printf("%d번 게시물이 수정되었습니다.\n", id);

			} else {
				System.out.printf("%s는 존재하지 않는 명령어입니다.\n", command);
			}

		}

	}

}

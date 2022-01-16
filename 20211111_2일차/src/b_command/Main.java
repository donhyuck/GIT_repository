package b_command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 문제점 : 내용 혹은 제목이 삭제되었을 경우 꼬이기게 된다.

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		// 변경 1 : 리스트로 변경
		List<String> titles = new ArrayList<>();
		List<String> bodies = new ArrayList<>();
		List<Integer> ids = new ArrayList<>();

		// 변경 2 : 게시글 순서 부여
		int lastId = 1;

		while (true) {
			System.out.printf("명령어 : ");
			String command = input.nextLine();

			command.trim();

			if (command.length() == 0) {
				continue;
			}

			if (command.equals("list")) {
				System.out.println("===  게시물 목록  ===");
				for (int i = 0; i < ids.size(); i++) {
					System.out.printf("%d번째 글 ㅣ %s\n", ids.get(i), titles.get(i));
				}
			}

			else if (command.equals("write")) {

				// 게시물의 번호, 제목, 내용
				int id = lastId++;

				System.out.printf("제목 : ");
				String title = input.nextLine();

				System.out.printf("내용 : ");
				String body = input.nextLine();

				titles.add(title);
				bodies.add(body);
				ids.add(id);

				System.out.println("게시물 등록이 완료되었습니다.");
			}

			else {
				System.out.printf("%s : 존재하지 않는 명령어입니다.\n", command);
			}
		}
	}
}
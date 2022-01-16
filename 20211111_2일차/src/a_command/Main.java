package a_command;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		// 어느쪽 지역에 치우치지 않고 목록, 작성 등에 쓰이기 위해
		String title = "";
		String body = "";
		int id = 1;

		while (true) {
			System.out.printf("명령어 : ");
			String command = input.nextLine();

			// 공백 제거
			command.trim();

			// 아무것도 입력하지 않으면 다시 입력하라함
			if (command.length() == 0) {
				continue;
			}

			// 게시물 불러오기 ==> command.equals(" 명령어 ")
			if (command.equals("list")) {
				System.out.println("===  게시물 목록  ===");
				System.out.printf("%d번째 글 ㅣ %s\n", id, title);
			}

			// 게시물 작성
			// 명령어 중 write가 들어온다면
			else if (command.equals("write")) {

				// 게시물의 번호, 제목, 내용

				System.out.printf("제목 : ");
				title = input.nextLine();

				System.out.printf("내용 : ");
				body = input.nextLine();

				System.out.println("게시물 등록이 완료되었습니다.");
				// break;

			}

			// 저장된 명령어 이외
			else {
				System.out.printf("%s : 존재하지 않는 명령어입니다.\n", command);
			}
		}
	}
}
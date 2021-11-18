package board.Controller;

import java.util.List;
import java.util.Scanner;

import board.dto.Member;
import board.util.Util;

public class MemberController {

	private Scanner sc;
	private List<Member> members;

	public MemberController(Scanner sc, List<Member> members) {
		this.sc = sc;
		this.members = members;
	}

	// members를 공용으로 쓰기위해
	// public void dojoin(List<Member> members, Scanner sc) { 대신
	public void dojoin() {
		int id = members.size() + 1;

		// 초기화 이후 값을 받음
		String loginId = null;

		while (true) {
			System.out.printf("로그인 아이디 : ");
			loginId = sc.nextLine();

			// 입력한 아이디가 DB에 있는지 없는지만 확인하면 된다.
			if (isJoinableLoginId(loginId) == false) {
				System.out.printf("%s (은)는 이미 사용중인 아이디입니다.\n", loginId);
				continue;
			}

			break;
		}

		// 초기화 이후 값을 받음

		String loginPw = null;
		String loginPwConfirm = null;

		// 비밀번호가 일치하면 무한루프 탈출
		while (true) {

			System.out.printf("로그인 비밀번호 : ");
			loginPw = sc.nextLine();

			System.out.printf("로그인 비밀번호 확인 : ");
			loginPwConfirm = sc.nextLine();

			if (loginPw.equals(loginPwConfirm) == false) {
				System.out.println("비밀번호를 다시 입력해주세요.");
				continue;
			}

			break;
		}

		System.out.printf("이름 : ");
		String name = sc.nextLine();

		String regDate = Util.getCurrentDate();

		Member member = new Member(id, regDate, loginId, loginPw, name);
		members.add(member);

		System.out.printf("%d번 회원 가입이 완료되었습니다.\n", id);
	}

	private boolean isJoinableLoginId(String loginId) {
		int index = getMemberIndexByLoginId(loginId);

		// 일치하는게 없다 -> 중복X -> 가입할 수 있다.
		if (index == -1) {
			return true;
		}

		// 일치하는게 있다 -> 다시 로그인아이디를 입력받는다.
		return false;
	}

	private int getMemberIndexByLoginId(String loginId) {
		int i = 0;

		// 찾아봤는데 i값이 나온다 라는 의미는
		// 중복이 있으니 isJoinableLoginId에서 가입할수없는것이다.
		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return i;
			}

			i++;
		}
		return -1;
	}

}

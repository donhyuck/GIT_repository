package board.controller;

import board.dto.Member;

public abstract class Controller {

	// 공유자원
	// member Controller 에서 이동 : articleComtroller에서도 이용가능함
	public static Member loginedMember;

	public abstract void doAction(String command, String actionMethodName);

	public abstract void makeTestData();

	// is login? true => null이 아님. 누군가 로그인 중
	public static boolean isLogined() {
		return loginedMember != null;
	}
}

package board.dto;

public class Member extends dto {

	public String loginId;
	public String loginPw;
	public String name;

	public Member(int id, String regDate, String loginId, String loginPw, String name) {
		this.id = id;
		this.regDate = regDate;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
	}
}

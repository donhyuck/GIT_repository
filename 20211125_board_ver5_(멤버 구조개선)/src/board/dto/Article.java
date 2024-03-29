package board.dto;

public class Article extends Dto {

	public String title; 	// 게시물 번호
	public String body; 	// 게시물 번호
	public int hit; 		// 게시물 조회수
	public int memberId;  	// Id가 있어서 memberId 추가 , 유일한 번호를 부여할 수 있다.

	public Article(int id, String regDate, int memberId, String title, String body) {
		this(id, regDate, memberId, title, body, 0);
	}

	public Article(int id, String regDate, int memberId, String title, String body, int hit) {
		this.id = id;
		this.regDate = regDate;
		this.memberId = memberId;
		this.title = title;
		this.body = body;
		this.hit = hit;
	}

	public void increaseHit() {
		hit++;
	}

}

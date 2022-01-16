package board.dto;
// dto
// Data Transfer Objects

public class Article {
	public int id; 		  	// 게시물 번호
	public String title; 	// 게시물 제목
	public String body; 	// 게시물 내용
	public String regDate; 	// 게시물 등록 날짜
	public int hit; 		// 게시물 조회수

	// 4개 짜리 -> 생성에서는 조회수를 받는 것이 이상함
	public Article(int id, String title, String body, String regDate) {
		// 5개 짜리로 일을 넘기는 것
		this(id, title, body, regDate, 0);
	}

	// 5개 짜리
	// 외부에서 조회수도 넘겨받음
	public Article(int id, String title, String body, String regDate, int hit) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.hit = hit;
	}

	// detail 명령어가 실행되었을 때 실행
	public void increaseHit() {
		hit++;
	}

}

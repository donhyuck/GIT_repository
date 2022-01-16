package board;

public class Article {
	int id;         // 게시물 번호
	String title;   // 게시글 제목
	String body;    // 게시글 내용
	String regDate;

	public Article(int id, String title, String body, String regDate) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
	}
}

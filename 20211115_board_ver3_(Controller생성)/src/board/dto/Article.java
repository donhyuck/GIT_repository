package board.dto;

public class Article extends Dto {

	public String title;
	public String body;
	public int hit;

	public Article(int id, String regDate, String title, String body) {
		this(id, title, body, regDate, 0);
	}

	public Article(int id, String regDate, String title, String body, int hit) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
		this.hit = hit;
	}

	public void increaseHit() {
		hit++;
	}
}

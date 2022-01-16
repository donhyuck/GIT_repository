package board.container;

import board.dao.ArticleDao;
import board.dao.MemberDao;
import board.service.ArticleService;
import board.service.MemberService;

public class Container {
	public static ArticleDao articleDao;
	public static MemberDao memberDao;
	public static ArticleService articleService;
	public static MemberService memberService;

	// 공유폴더와 같은 의미
	static {
		articleDao = new ArticleDao();
		memberDao = new MemberDao();
		articleService = new ArticleService();
		memberService = new MemberService();
	}
}

package board.dao;

import java.util.ArrayList;
import java.util.List;

import board.dto.Article;

public class ArticleDao extends Dao {
	private List<Article> articles;

	public ArticleDao() {
		articles = new ArrayList<>();
	}

	public void add(Article article) {
		articles.add(article);
		lastId = article.id;
	}

	public List<Article> getArticles(String searchKeyword) {
		if (searchKeyword != null && searchKeyword.length() != 0) {
			List<Article> forPrintArticles = new ArrayList<>();

			// 중요한 로직을 넘겼고
			// 필요한 건 searchKeyword 인데, 인자로서 넘겨받음
			if (searchKeyword.length() > 0) {

				for (Article article : articles) {
					if (article.title.contains(searchKeyword)) {
						forPrintArticles.add(article);
					}
				}
			}
			return forPrintArticles;
		}
		return articles;
	}

	public int getArticleIndexById(int id) {
		int i = 0;
		for (Article article : articles) {

			if (article.id == id) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public Article getArticleById(int id) {

		int index = getArticleIndexById(id);

		if (index != -1) {
			return articles.get(index);
		}

		return null;
	}

	public void remove(Article foundArticle) {
		articles.remove(foundArticle);
	}
}

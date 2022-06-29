package eeit45.group3.bakeyourlife.article.service;

import java.util.List;

import eeit45.group3.bakeyourlife.article.model.Article;


public interface ArticleService {
	List<Article> findAll();

	List<Article> select(String title);

	List<Article> selectone(Integer postid);

	void insert(Article newArticle);

	void update(Article upArticle);

	int delete(Integer postid);
    
	Article getPic(Integer postid);
}

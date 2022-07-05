package eeit45.group3.bakeyourlife.article.service;

import java.util.List;
import java.util.Optional;

import eeit45.group3.bakeyourlife.article.model.Article;


public interface ArticleService {
	List<Article> findAll();

//	List<Article> select(String title);

	Article insert(Article newArticle);

	Article update(Article upArticle);

	void delete(Integer postid);

	Optional<Article> selectOne(Integer postid);

	List<Article> findByTitle(String title);

	List<Article> findAllByTypeContaining(String type);
}


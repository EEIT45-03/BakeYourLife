package eeit45.group3.bakeyourlife.article.dao;

import java.util.List;

import eeit45.group3.bakeyourlife.article.model.Article;

public interface ArticleDao {

	public List<Article> findAll();

	public List<Article> select(String title);

	public List<Article> selectone(Integer postid);

	public void insert(Article newArticle);

	public void update(Article upArticle);

	public int delete(Integer postid);
	
	public Article getPic(Integer postid);

}
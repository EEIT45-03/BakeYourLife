package eeit45.group3.bakeyourlife.article.dao;

import java.util.List;

import eeit45.group3.bakeyourlife.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query(value="select t from Article t where t.title like '%%資訊'")
     List<Article> findByTitle(String title);

    List<Article> findAllByTypeContaining(String type);

}
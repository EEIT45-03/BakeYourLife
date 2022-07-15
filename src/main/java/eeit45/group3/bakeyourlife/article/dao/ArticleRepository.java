package eeit45.group3.bakeyourlife.article.dao;

import java.sql.Date;
import java.util.List;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.utils.ArticleCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query(value="select t from Article t where t.title like %:title%")
     List<Article> findByTitle(String title);

    List<Article> findAllByTypeContaining(String type);

    @Query(nativeQuery = true,value ="select TOP(3)* from ARTICLE where DATE <= GETDATE() ORDER BY DATE DESC")
    List<Article> findLatestDate(Date date);

    @Query(nativeQuery = true,value = "Select type AS 'label',count(*) AS 'value' FROM ARTICLE GROUP BY type")
    List<ArticleCount> selectTypeCount();

    @Query(nativeQuery = true,value = "Select type AS 'label',AVG(counter) AS 'value' FROM ARTICLE GROUP BY type")
    List<ArticleCount> selectCounterByType();
}
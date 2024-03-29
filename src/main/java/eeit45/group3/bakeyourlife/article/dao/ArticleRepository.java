package eeit45.group3.bakeyourlife.article.dao;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.utils.ArticleCount;
import eeit45.group3.bakeyourlife.user.model.User;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

  @Query(value = "select t from Article t where t.title like %:title%")
  List<Article> findByTitle(String title);

  List<Article> findAllByTypeContaining(String type);

  @Query(
      nativeQuery = true,
      value = "select TOP(5)* from ARTICLE where DATE <= GETDATE() ORDER BY DATE DESC")
  List<Article> findLatestDate(Date date);

  @Query(
      nativeQuery = true,
      value = "Select type AS 'label',count(*) AS 'value' FROM ARTICLE GROUP BY type")
  List<ArticleCount> selectTypeCount();

  @Query(
      nativeQuery = true,
      value = "Select type AS 'label',AVG(counter) AS 'value' FROM ARTICLE GROUP BY type")
  List<ArticleCount> selectCounterByType();

  List<Article> findAllByUser(User user);

  //
  //    @Query(nativeQuery = true,value = "SELECT CAST(CASE WHEN f.id IS NULL THEN 0 ELSE 1 END AS
  // bit) AS state,[postid], [content], [counter], [date], [image_url], [title], [type], [user_id]
  // FROM Article a LEFT JOIN ( SELECT * FROM favorite F WHERE f.use_id = ?1) f ON a.postid =
  // f.article_id")
  //    List<Article> findAll(Integer userId);

  @Query(nativeQuery = true, value = "select TOP(3)* from ARTICLE  ORDER BY counter DESC")
  List<Article> findTopCounter(Integer counter);
}

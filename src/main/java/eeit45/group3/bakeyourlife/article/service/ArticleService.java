package eeit45.group3.bakeyourlife.article.service;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.user.model.User;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ArticleService {
  List<Article> findAll();

  //	List<Article> select(String title);

  Article insert(Article newArticle);

  Article update(Article upArticle);

  void delete(Integer postid);

  Optional<Article> selectOne(Integer postid);

  List<Article> findByTitle(String title);

  List<Article> findAllByTypeContaining(String type);

  List<Article> findLatestDate(Date date);

  public List<Article> findAllByUser(User user);

  List<Article> findTopCounter(Integer counter);
}
//	Article findById (Integer postid);
// }

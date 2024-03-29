package eeit45.group3.bakeyourlife.article.service;

import eeit45.group3.bakeyourlife.article.dao.ArticleRepository;
import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.user.model.User;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

  private ArticleRepository repository;

  @Autowired
  public ArticleServiceImpl(ArticleRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Article> findAll() {
    return repository.findAll();
  }
  //			@Override
  //			public List<Article> select(String title) {
  //				return repository.findAll(title);
  //			}

  @Override
  public Optional<Article> selectOne(Integer postid) {
    return repository.findById(postid);
  }

  @Override
  public List<Article> findByTitle(String title) {
    return repository.findByTitle(title);
  }

  @Override
  public List<Article> findAllByTypeContaining(String type) {
    return repository.findAllByTypeContaining(type);
  }

  @Override
  public List<Article> findLatestDate(Date date) {
    return repository.findLatestDate(date);
  }

  @Override
  public List<Article> findAllByUser(User user) {
    return repository.findAllByUser(user);
  }

  @Override
  public List<Article> findTopCounter(Integer counter) {
    return repository.findTopCounter(counter);
  }

  @Override
  public Article insert(Article newArticle) {
    return repository.save(newArticle);
  }

  @Override
  public Article update(Article upArticle) {
    // Article article = repository.findById(upArticle.getPostid()).orElse(null);
    return repository.save(upArticle);
  }

  @Override
  public void delete(Integer postid) {
    repository.deleteById(postid);
  }
}

//	       public Article findById(Integer postid) {
//		return repository.findById(postid);
//	}
//		};

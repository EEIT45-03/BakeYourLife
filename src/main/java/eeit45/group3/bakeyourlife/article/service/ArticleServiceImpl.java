package eeit45.group3.bakeyourlife.article.service;

import java.util.List;
import java.util.Optional;

import eeit45.group3.bakeyourlife.article.dao.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import eeit45.group3.bakeyourlife.article.model.Article;

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
			public Article insert(Article newArticle) {

				return repository.save(newArticle);
			}

			@Override
			public Article update(Article upArticle) {
				return repository.save(upArticle);
			}

			@Override
			public void delete(Integer postid) {
            repository.deleteById(postid);
			}
		};










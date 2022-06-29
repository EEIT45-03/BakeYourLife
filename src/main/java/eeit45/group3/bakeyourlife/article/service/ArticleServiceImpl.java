package eeit45.group3.bakeyourlife.article.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eeit45.group3.bakeyourlife.article.dao.ArticleDao;
import eeit45.group3.bakeyourlife.article.model.Article;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	SessionFactory factory;
	
	@Autowired
	private  ArticleDao articleDao;
	
	public ArticleServiceImpl() {
//		this.factory = HibernateUtils.getSessionFactory();
//		this.articleDao = new ArticleDaoImpl();
	}

	@Override
	public List<Article> findAll() {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		List<Article> list = null;
//		try {
//			tx = session.beginTransaction();
			list = articleDao.findAll();
//		    tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
		return list;
	}	

	@Override
	public List<Article> select(String title) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		List<Article> list = null;
//		try {
//			tx = session.beginTransaction();
			list = articleDao.select(title);
//		    tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
		return list;
	}
	

	@Override
	public List<Article> selectone(Integer postid) {
		
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
		List<Article> list = null;
//		try {
//			tx = session.beginTransaction();
			list = articleDao.selectone(postid);
//		    tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
		return list;
	}

	@Override
	public void insert(Article newArticle) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		
//		try {
//			tx = session.beginTransaction();
	    articleDao.insert(newArticle);
//		    tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
		}
//	
//	}

	@Override
	public void update(Article upArticle) {
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			articleDao.update(upArticle);
//		    tx.commit();
//		} catch (Exception e) {
//			if (tx != null) {
//				tx.rollback();
//			}
//			e.printStackTrace();
//		}
	}
		

	@Override
	public int delete(Integer postid) {
		int n = 0;
//		Session session = factory.getCurrentSession();
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
			 n = articleDao.delete(postid);
//		    tx.commit();
//		} catch (Exception ex) {
//			if (tx != null) {
//				tx.rollback();
//			}
//		    throw new RuntimeException(ex);
//		}		
		return n;
	}
		
	
    public Article getPic(Integer postid) {
    	Article article = null;
//	Session session = factory.getCurrentSession();
//	Transaction tx = null;
//	try {
//		tx = session.beginTransaction();
		article = articleDao.getPic(postid);
//		tx.commit();
//	}catch(Exception ex) {
//		if(tx !=null) {
//			tx.rollback();
//		}
//	    throw new RuntimeException(ex);
//	}		
//	
	return article;
}
}


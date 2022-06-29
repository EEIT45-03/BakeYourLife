package eeit45.group3.bakeyourlife.article.dao;




import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eeit45.group3.bakeyourlife.article.model.Article;




@Repository
@Transactional
public class ArticleDaoImpl implements ArticleDao{
	
	@Autowired
	private SessionFactory factory; 
	 
	
	
	public ArticleDaoImpl() {
//		factory = HibernateUtils.getSessionFactory();
    }
	
			
	@Override
	public List<Article> findAll(){		
		List<Article> article = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Article";
		article = session.createQuery(hql, Article.class)				             
				             .getResultList();
		return article;
	}
				 
	
	@Override
	public List<Article> select(String title){
		String hql = "FROM Article a WHERE a.title like '%"+ title +"%'";
		Session session = factory.getCurrentSession();	
		List<Article> articles = session.createQuery(hql, Article.class)
//                .setParameter("title", title) 上面有寫title
                .getResultList();		              
		return articles;
	}
	
	
			

	@Override
	public List<Article> selectone(Integer postid){
		String hql = "FROM Article a WHERE a.postid = :postid";
		Session session = factory.getCurrentSession();	
		List<Article> articles = session.createQuery(hql, Article.class)
                .setParameter("postid", postid)
                .getResultList();		              
		return articles;
	}
	


      @Override
	public void insert(Article newArticle) {
    	  Session session = factory.getCurrentSession();
  		session.save(newArticle);
      }
      @Override
	public void update(Article upArticle) {
    	
    	  Session session = factory.getCurrentSession();
  		session.saveOrUpdate(upArticle);
	      
        }	
        	
        @Override
		public int delete(Integer postid) {
        	Session session = factory.getCurrentSession();
    		Article article = new Article();
    		article.setPostid(postid);
    		session.delete(article);
    		return 1;
    		
    		
}
        public Article getPic(Integer postid) {
    		Session session = factory.getCurrentSession();
    		Article article = session.get(Article.class, postid);
    		return article;
    	}
}   			
    	 

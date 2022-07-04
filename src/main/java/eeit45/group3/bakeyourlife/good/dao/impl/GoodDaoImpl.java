//package eeit45.group3.bakeyourlife.good.dao.impl;
//
//import java.util.List;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import eeit45.group3.bakeyourlife.good.dao.GoodDao;
//import eeit45.group3.bakeyourlife.good.model.Goods;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
////import eeit45.group3.util.HibernateUtils;
//
//@Repository
//public class GoodDaoImpl implements GoodDao {
////	@Autowired
////	SessionFactory factory;
//@PersistenceContext
//EntityManager entityManager;
////	public GoodDaoImpl() {
////		factory = HibernateUtils.getSessionFactory();
////	}
//
//
//	@Override
//	public Goods isDup(String name) {
//		//Session session = factory.getCurrentSession();
//		String hql = "FROM Goods gs WHERE gs.name = :goodname";
//		Goods goodsBean = entityManager.createQuery(hql,Goods.class)
//				.setParameter("goodname", name)
//				.getSingleResult();
//		return goodsBean;
//	}
////		if(goodsBeans.size() > 0) {
////			return true;
////		}else {
////			return false;
////		}
//
//	@Override
//	public int save(Goods mb) {
//		//Session session = factory.getCurrentSession();
//		entityManager.persist(mb);
//		return 0;
//	}
//
//	@Override
//	public List<Goods> getAllMembers() {
//		List<Goods> goodBeans = null;
//		//Session session = factory.getCurrentSession();
//		String hql = "FROM Goods";
//		goodBeans = entityManager.createQuery(hql,Goods.class)
//				.getResultList();
//		return goodBeans;
//	}
//
//	@Override
//	public Goods getMember(int pk) {
//		//Session session = factory.getCurrentSession();
//		Goods goodBean = entityManager.find(Goods.class, pk);
//		return goodBean;
//	}
//
//	@Override
//	public int deleteMember(int ipk) {
//		//Session session = factory.getCurrentSession();  //回傳回傳值和數字差異
//		Goods goodBean = new Goods();
//		goodBean.setId(ipk);
//		entityManager.remove(goodBean);
//		return 1;
//	}
//
//	@Override
//	public int updateMember(Goods mb) {
//		//Session session = factory.getCurrentSession();
//		entityManager.merge(mb);
//		return 1;
//	}
//
//}

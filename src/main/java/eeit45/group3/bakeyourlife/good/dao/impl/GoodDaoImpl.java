package eeit45.group3.bakeyourlife.good.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eeit45.group3.bakeyourlife.good.dao.GoodDao;
import eeit45.group3.bakeyourlife.good.model.Goods;
//import eeit45.group3.util.HibernateUtils;

//@Repository
public class GoodDaoImpl implements GoodDao {
	@Autowired
	SessionFactory factory;
	
//	public GoodDaoImpl() {
//		factory = HibernateUtils.getSessionFactory();
//	}


	@Override
	public Goods isDup(String name) {
		Session session = factory.getCurrentSession();
		String hql = "FROM Goods gs WHERE gs.name = :goodname";
		Goods goodsBean = session.createQuery(hql,Goods.class)
				                              .setParameter("goodname", name)
				                              .uniqueResult();
		return goodsBean;
	}
//		if(goodsBeans.size() > 0) {
//			return true;
//		}else {
//			return false;
//		}

	@Override
	public int save(Goods mb) {
		Session session = factory.getCurrentSession();
		session.save(mb);
		return 0;
	}

	@Override
	public List<Goods> getAllMembers() {
		List<Goods> goodBeans = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Goods";
		goodBeans = session.createQuery(hql,Goods.class)
				             .getResultList();
		return goodBeans;
	}

	@Override
	public Goods getMember(int pk) {
		Session session = factory.getCurrentSession();
		Goods goodBean = session.get(Goods.class, pk);
		return goodBean;
	}

	@Override
	public int deleteMember(int ipk) {
		Session session = factory.getCurrentSession();  //回傳回傳值和數字差異
		Goods goodBean = new Goods();
		goodBean.setId(ipk);
		session.delete(goodBean);
		return 1;
	}

	@Override
	public int updateMember(Goods mb) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(mb);
		return 1;
	}

}

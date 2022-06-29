package eeit45.group3.bakeyourlife.good.service.impl;

import java.util.List;

import javax.transaction.Transactional;

//import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eeit45.group3.bakeyourlife.good.dao.GoodDao;
//import eeit45.group3.bakeyourlife.good.dao.impl.GoodDaoImpl;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
//import eeit45.group3.util.HibernateUtils;

@Service
@Transactional
public class GoodServiceHibernateImpl implements GoodService {

	@Autowired
	SessionFactory factory;
	@Autowired
	GoodDao dao;
	

//	public GoodServiceHibernateImpl() {
//	
//		this.factory = HibernateUtils.getSessionFactory();
//		this.dao = new GoodDaoImpl();
//	}

	@Override
	public Goods isDup(String name) {
		return dao.isDup(name);
	}

	@Override
	public int save(Goods mb) {
		return dao.save(mb);
	}

	@Override
	public List<Goods> getAllGoods() {
		return dao.getAllMembers();
	}

	@Override
	public Goods getGoods(int pk) {
		return dao.getMember(pk);
	}

	@Override
	public int deleteGoods(int ipk) {
		return dao.deleteMember(ipk);
	}

	@Override
	public int updateGoods(Goods mb) {
		return dao.updateMember(mb);
	}
	

}

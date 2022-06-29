package eeit45.group3.bakeyourlife.farmerproduct.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@Repository("FarmerProductDao")
@Transactional(propagation = Propagation.MANDATORY)
public class FarmerProductDaoImpl implements FarmerProductDao {
	@Autowired
	SessionFactory factory;

	@Override
	public List<FarmerProductBean> findAll() {
		Session session = factory.getCurrentSession();
		List<FarmerProductBean> farmerProductBeans = session
				.createQuery("FROM FarmerProductBean", FarmerProductBean.class).getResultList();
		return farmerProductBeans;

	}

	@Override
	public void insert(FarmerProductBean farmerProductBean) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(farmerProductBean);

	}

	@Override
	public void update(FarmerProductBean farmerProductBean) {
		Session session = factory.getCurrentSession();
		session.merge(farmerProductBean);
	}

	@Override
	public void delete(Integer farmerProductId) {
		Session session = factory.getCurrentSession();
		FarmerProductBean farmerProductBean = session.get(FarmerProductBean.class, farmerProductId);
		session.delete(farmerProductBean);
	}

	@Override
	public FarmerProductBean findById(Integer farmerProductId) {
		Session session = factory.getCurrentSession();
		FarmerProductBean farmerProductBean = session.get(FarmerProductBean.class, farmerProductId);
		return farmerProductBean;
	}

}

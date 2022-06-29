package eeit45.group3.bakeyourlife.farmerproduct.model;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class FarmerProductServiceImpl implements FarmerProductService {

	SessionFactory factory;
	FarmerProductDao farmerProductDao;

	@Autowired
	public FarmerProductServiceImpl(SessionFactory factory, FarmerProductDao farmerProductDao) {
		this.factory = factory;
		this.farmerProductDao = farmerProductDao;
	}

	@Override
	@Transactional
	public List<FarmerProductBean> findAll() {

		List<FarmerProductBean> farmerProductBeans = null;

		farmerProductBeans = farmerProductDao.findAll();

		return farmerProductBeans;

	}

	@Override
	@Transactional
	public FarmerProductBean findById(Integer farmerProductId) {

		FarmerProductBean farmerProductBean = null;

		farmerProductBean = farmerProductDao.findById(farmerProductId);

		return farmerProductBean;

	}

	@Override
	@Transactional
	public void insert(FarmerProductBean farmerProductBean) {
		farmerProductDao.insert(farmerProductBean);

	}

	@Override
	@Transactional
	public void update(FarmerProductBean farmerProductBean) {
		farmerProductDao.update(farmerProductBean);

	}

	@Override
	@Transactional
	public void delete(Integer farmerProductId) {
		farmerProductDao.delete(farmerProductId);
	}

}

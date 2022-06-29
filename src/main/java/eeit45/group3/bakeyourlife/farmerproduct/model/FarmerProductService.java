package eeit45.group3.bakeyourlife.farmerproduct.model;

import java.util.List;

public interface FarmerProductService {

	public List<FarmerProductBean> findAll();

	public FarmerProductBean findById(Integer farmerProductId);

	public void insert(FarmerProductBean farmerProductBean);

	public void update(FarmerProductBean farmerProductBean);

	public void delete(Integer farmerProductId);

}
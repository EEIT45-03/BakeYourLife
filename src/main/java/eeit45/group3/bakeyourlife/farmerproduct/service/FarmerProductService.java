package eeit45.group3.bakeyourlife.farmerproduct.service;

import java.util.List;
import java.util.Optional;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;

public interface FarmerProductService {

    List<FarmerProductBean> findAll();

    FarmerProductBean findByFarmerProductId(Integer farmerProductId);

    void insert(FarmerProductBean farmerProductBean);

    void update(FarmerProductBean farmerProductBean);

    void delete(Integer farmerProductId);

}
package eeit45.group3.bakeyourlife.farmerproduct.service;

import java.util.List;
import java.util.Optional;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;

import javax.persistence.criteria.CriteriaBuilder;

public interface FarmerProductService {

    List<FarmerProductBean> findAll();

    List<FarmerProductBean> findByUserId(Integer userId);

    List<FarmerProductBean> findByStateOrderByLaunchedTimeDesc(Integer state);

    List<FarmerProductBean> findByTypeAndStateOrderByLaunchedTimeDesc(String type);


    FarmerProductBean findByFarmerProductId(Integer farmerProductId);

    Long count();

    Long countByFarmerId(Integer id);


    void insert(FarmerProductBean farmerProductBean);

    void update(FarmerProductBean farmerProductBean);

    void delete(Integer farmerProductId);

}
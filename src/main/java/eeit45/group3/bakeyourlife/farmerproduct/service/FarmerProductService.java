package eeit45.group3.bakeyourlife.farmerproduct.service;

import java.util.List;
import java.util.Optional;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;

import javax.persistence.criteria.CriteriaBuilder;

public interface FarmerProductService {

    List<FarmerProductBean> findAll();

    List<FarmerProductBean> findByFarmerId(Integer farmerId);

    List<FarmerProductBean> findByStateOrderByLaunchedTimeDesc(Integer state);

    List<FarmerProductBean> findByStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(Integer farmerId);

    List<FarmerProductBean> findByTypeAndStateOrderByLaunchedTimeDesc(String type);

    List<FarmerProductBean> findByTypeAndStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(String type, Integer farmerId);


    FarmerProductBean findByFarmerProductId(Integer farmerProductId);

    Long count();

    Long countByFarmerId(Integer id);

    Integer saleAmountByFarmerId(Integer farmerId);


    void insert(FarmerProductBean farmerProductBean);

    void update(FarmerProductBean farmerProductBean);

    void delete(Integer farmerProductId);

}
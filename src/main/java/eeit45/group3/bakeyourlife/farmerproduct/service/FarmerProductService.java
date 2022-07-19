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

    List<FarmerProductBean> findByTypeAndStateAndFarmerProductIdNotOrderByLaunchedTimeDesc(String type, Integer farmerProductId);

    List<FarmerProductBean> findByTypeAndStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(String type, Integer farmerId);


    FarmerProductBean findByFarmerProductId(Integer farmerProductId);

    Long count();

    Long countByFarmerId(Integer id);

    String saleAmountByFarmerId(Integer farmerId);

    String saleAmount();

    //全部廠商 商品平均星數
    Float avgStar();

    //單個廠商 商品平均星數
    Float avgStarByFarmerId(Integer farmerId);

    //最熱賣商品 件數
    String topSaleItemByFarmerId(Integer farmerId);

    //熱銷Top 6
    List<FarmerProductBean> topSix();


    void insert(FarmerProductBean farmerProductBean);

    void update(FarmerProductBean farmerProductBean);

    void delete(Integer farmerProductId);

}
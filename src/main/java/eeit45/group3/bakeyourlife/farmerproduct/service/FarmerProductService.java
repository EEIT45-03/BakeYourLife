package eeit45.group3.bakeyourlife.farmerproduct.service;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;

import java.util.List;

public interface FarmerProductService {
    //找全部商品
    List<FarmerProductBean> findAll();

    //多個商品 從廠商ID找
    List<FarmerProductBean> findByFarmerId(Integer farmerId);

    //多個商品 從廠商ID找 按時間排序 新到舊
    List<FarmerProductBean> findByFarmerFarmerIdOrderByLaunchedTimeDesc(Integer farmerId);

    //多個商品  按時間排序 新到舊
    List<FarmerProductBean> findAllByOrderByLaunchedTimeDesc();

    //多個商品 從狀態找 按時間排序 新到舊
    List<FarmerProductBean> findByStateOrderByLaunchedTimeDesc(Integer state);

    //多個商品 從狀態跟廠商ID找 按時間排序 新到舊
    List<FarmerProductBean> findByStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(Integer farmerId);

    //多個商品 從類型跟狀態找 按時間排序 新到舊
    List<FarmerProductBean> findByTypeAndStateOrderByLaunchedTimeDesc(String type);

    //多個商品 從類型跟狀態找 排除一個商品 按時間排序 新到舊
    List<FarmerProductBean> findByTypeAndStateAndFarmerProductIdNotOrderByLaunchedTimeDesc(String type, Integer farmerProductId);

    //多個商品 從類型跟狀態跟廠商ID找 按時間排序 新到舊
    List<FarmerProductBean> findByTypeAndStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(String type, Integer farmerId);

    //找單個 從商品ID找
    FarmerProductBean findByFarmerProductId(Integer farmerProductId);

    //全部筆數
    Long count();

    //單個廠商商品數
    Long countByFarmerId(Integer id);

    //單個廠商銷售統計
    String saleAmountByFarmerId(Integer farmerId);

    //全部廠商銷售總額
    String saleAmount();

    //全部廠商 商品平均星數
    Float avgStar();

    //單個廠商 商品平均星數
    Float avgStarByFarmerId(Integer farmerId);

    //最熱賣商品 件數
    String topSaleItemByFarmerId(Integer farmerId);

    //熱銷Top 6
    List<FarmerProductBean> topSix();

    //新增商品
    void insert(FarmerProductBean farmerProductBean);

    //修改商品
    void update(FarmerProductBean farmerProductBean);

    //刪除商品
    void delete(Integer farmerProductId);

}
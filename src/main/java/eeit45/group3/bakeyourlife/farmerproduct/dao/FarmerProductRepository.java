package eeit45.group3.bakeyourlife.farmerproduct.dao;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.utils.TypeAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

public interface FarmerProductRepository extends JpaRepository<FarmerProductBean, Integer> {

    //單個商品 從商品ID找
    FarmerProductBean findByFarmerProductId(Integer farmerProductId);

    //多個商品 從狀態找 按時間排序 新到舊
    List<FarmerProductBean> findByStateOrderByLaunchedTimeDesc(Integer state);

    //多個商品 從狀態跟廠商ID找 按時間排序 新到舊
    List<FarmerProductBean> findByStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(Integer state, Integer farmerId);

    //多個商品 從類型跟狀態找 按時間排序 新到舊
    List<FarmerProductBean> findByTypeAndStateOrderByLaunchedTimeDesc(String type, Integer state);

    //多個商品 從類型跟狀態跟廠商ID找 按時間排序 新到舊
    List<FarmerProductBean> findByTypeAndStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(String type, Integer state, Integer farmerId);

    //多個商品 從廠商ID找
    List<FarmerProductBean> findByFarmerFarmerId(Integer farmerId);

    //廠商商品數量
    Long countByFarmerFarmerId(Integer farmerId);

    //全部商品 類型數量統計
    @Query(nativeQuery = true, value = "Select type, count(type) AS 'value' from farmer_product group by type")
    List<TypeAmount> findTypeAmount();

    //單個廠商 類型數量統計
    @Query(nativeQuery = true, value = "Select type, count(type) AS 'value' from farmer_product WHERE farmer_id =? group by type")
    List<TypeAmount> findTypeAmountByFarmerId(Integer farmerId);


    //單個廠商 賣出商品總金額
    @Query(nativeQuery = true, value = "select sum(oi.sub_total) from order_item oi join ( select 'F'+convert(varchar,farmer_product_id) AS 'id' from farmer_product  where farmer_id =?) f on oi.product_no =f.id join(select order_id,order_status from orders where order_status='完成') o on oi.order_id = o.order_id")
    Integer saleAmountByFarmerId(Integer farmerId);
}

package eeit45.group3.bakeyourlife.farmerproduct.dao;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.utils.QueryChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FarmerProductRepository extends JpaRepository<FarmerProductBean, Integer> {

    //單個商品 從商品ID找
    FarmerProductBean findByFarmerProductId(Integer farmerProductId);

    //多個商品 從狀態找 按時間排序 新到舊
    List<FarmerProductBean> findByStateOrderByLaunchedTimeDesc(Integer state);

    //多個商品 從狀態跟廠商ID找 按時間排序 新到舊
    List<FarmerProductBean> findByStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(Integer state, Integer farmerId);

    //多個商品 從類型跟狀態找 按時間排序 新到舊
    List<FarmerProductBean> findByTypeAndStateOrderByLaunchedTimeDesc(String type, Integer state);

    //多個商品 從類型跟狀態找 排除一個商品 按時間排序 新到舊
    List<FarmerProductBean> findByTypeAndStateAndFarmerProductIdNotOrderByLaunchedTimeDesc(String type, Integer state, Integer farmerProductId);

    //多個商品 從類型跟狀態跟廠商ID找 按時間排序 新到舊
    List<FarmerProductBean> findByTypeAndStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(String type, Integer state, Integer farmerId);

    //多個商品 從廠商ID找
    List<FarmerProductBean> findByFarmerFarmerId(Integer farmerId);

    //廠商商品數量
    Long countByFarmerFarmerId(Integer farmerId);

    //各廠商 總銷售額
    @Query(nativeQuery = true, value = " select fn.farmer_name AS 'label',isnull(sum(oi.sub_total),0) AS 'value'  from order_item oi " +
            " join ( select 'F'+convert(varchar,farmer_product_id) AS 'id', farmer_id from farmer_product ) f on oi.product_no =f.id " +
            " join(select order_id,order_status from orders where order_status != '已退款' AND order_status != '已取消') o on oi.order_id = o.order_id " +
            " right join ( select farmer_name,farmer_id from farmers)  fn on fn.farmer_id =f.farmer_id " +
            " group by fn.farmer_name")
    List<QueryChart> farmerSaleAmount();


    //全部商品 類型數量統計
    @Query(nativeQuery = true, value = "Select type AS 'label', count(type) AS 'value' from farmer_product group by type")
    List<QueryChart> findTypeAmount();

    //單個廠商 類型數量統計
    @Query(nativeQuery = true, value = "Select type AS 'label', count(type) AS 'value' from farmer_product WHERE farmer_id =? group by type")
    List<QueryChart> findTypeAmountByFarmerId(Integer farmerId);


    //單個廠商 賣出商品總金額
    @Query(nativeQuery = true, value = "select sum(oi.sub_total) from order_item oi join ( select 'F'+convert(varchar,farmer_product_id) AS 'id' from farmer_product  where farmer_id =?) f on oi.product_no =f.id join(select order_id,order_status from orders where order_status != '已退款' AND order_status != '已取消') o on oi.order_id = o.order_id")
    Integer saleAmountByFarmerId(Integer farmerId);

    //全部廠商 賣出商品總金額
    @Query(nativeQuery = true, value = "select sum(oi.sub_total) from order_item oi join ( select 'F'+convert(varchar,farmer_product_id) AS 'id' from farmer_product) f on oi.product_no =f.id join(select order_id,order_status from orders where order_status != '已退款' AND order_status != '已取消') o on oi.order_id = o.order_id")
    Integer saleAmount();

    //全部廠商 商品平均星數
    @Query(nativeQuery = true, value = " select CAST(AVG(CONVERT(FLOAT,star)) AS DECIMAL(10,1)) from product_comment where farmer_product_id  is not null")
    Float avgStar();

    //單個廠商 商品平均星數
    @Query(nativeQuery = true, value = "  select CAST(AVG(CONVERT(FLOAT,c.star)) AS DECIMAL(10,1)) from product_comment c join( select farmer_product_id from farmer_product where farmer_id =?) f on c.farmer_product_id =f .farmer_product_id")
    Float avgStarByFarmerId(Integer farmerId);


}

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


    //最熱賣商品 件數
    @Query(nativeQuery = true, value = "select TOP 1 oi.product_name+'@'+convert(varchar,format((sum(oi.qty)),'N0')) from order_item oi " +
            "join ( select 'F'+convert(varchar,farmer_product_id) AS 'id' from farmer_product  where farmer_id =?) f on oi.product_no =f.id " +
            "join(select order_id,order_status from orders where order_status != '已退款' AND order_status != '已取消') o on oi.order_id = o.order_id " +
            "group by oi.product_name order by sum(oi.qty) desc")
    String topSaleItemByFarmerId(Integer farmerId);

    //單個廠商 每月銷售額
    @Query(nativeQuery = true, value = " SELECT CONVERT(char(7), o2.label, 111) AS 'label',  isnull(sum(o2.sub_total),0)   AS 'value' FROM " +
            " ( select oi.order_id ,oi.product_name,sub_total,o.label from order_item oi " +
            "join ( select 'F'+convert(varchar,farmer_product_id) AS 'id' from farmer_product  where farmer_id =?) f on oi.product_no =f.id " +
            "join(select order_id,order_status,CONVERT(char(7), order_date, 111) AS 'label' from orders where order_status != '已退款' AND order_status != '已取消') o on oi.order_id = o.order_id  " +
            ")o2 group by label order by label")
    List<QueryChart> monthSaleAmountByFarmerId(Integer farmerId);

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
    @Query(nativeQuery = true, value = "select format(isnull(sum(oi.sub_total),0),'N0') from order_item oi join ( select 'F'+convert(varchar,farmer_product_id) AS 'id' from farmer_product  where farmer_id =?) f on oi.product_no =f.id join(select order_id,order_status from orders where order_status != '已退款' AND order_status != '已取消') o on oi.order_id = o.order_id")
    String saleAmountByFarmerId(Integer farmerId);

    //全部廠商 賣出商品總金額
    @Query(nativeQuery = true, value = "select format(isnull(sum(oi.sub_total),0),'N0') from order_item oi join ( select 'F'+convert(varchar,farmer_product_id) AS 'id' from farmer_product) f on oi.product_no =f.id join(select order_id,order_status from orders where order_status != '已退款' AND order_status != '已取消') o on oi.order_id = o.order_id")
    String saleAmount();

    //全部廠商 商品平均星數
    @Query(nativeQuery = true, value = " select isnull(CAST(AVG(CONVERT(FLOAT,star)) AS DECIMAL(10,1)),0) from product_comment where farmer_product_id  is not null")
    Float avgStar();

    //單個廠商 商品平均星數
    @Query(nativeQuery = true, value = "  select isnull(CAST(AVG(CONVERT(FLOAT,c.star)) AS DECIMAL(10,1)),0) from product_comment c join( select farmer_product_id from farmer_product where farmer_id =?) f on c.farmer_product_id =f .farmer_product_id")
    Float avgStarByFarmerId(Integer farmerId);


    //熱銷Top 6
    @Query(nativeQuery = true, value = " select Top 6  f1.* from farmer_product f1 " +
            " join(select 'F'+convert(varchar,farmer_product_id) AS 'fid',farmer_product_id from farmer_product ) f2 " +
            " on f1.farmer_product_id =f2.farmer_product_id  " +
            " join(select product_no,sum(qty) as 'sumQty' from order_item where product_type ='小農' group by product_no  )f3  on f2.fid =f3.product_no order by sumQty desc")
    List<FarmerProductBean> topSix();


}

package eeit45.group3.bakeyourlife.order.dao;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.utils.ProductSaleAmount;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByOrderDateBetween(Date orderDateStart, Date orderDateEnd);

    List<Order> findAllByUserAndOrderDateBetween(User user,Date orderDateStart, Date orderDateEnd);

    List<Order> findAllByOrderStatusAndUser(OrderStatus orderStatus, User user);

    Optional<Order> findByOrderNo(String orderNo);

    List<Order> findAllByCoupon(Coupon coupon);

    List<Order> findAllByUser(User user);

    @Query(nativeQuery = true, value = "SELECT ot.product_no AS 'id',ot.product_name AS 'label', SUM(ot.sub_total) 'value' FROM order_item ot LEFT JOIN orders o ON ot.order_id = o.order_id WHERE o.order_status != '已退款' AND O.order_status != '已取消' GROUP BY ot.product_no,ot.product_name")
    List<ProductSaleAmount> findProductSaleAmount();


    @Query(nativeQuery = true, value = "SELECT CONVERT(char(7), o.order_date, 111) AS 'label', sum(o.total_price) AS 'value' FROM orders o WHERE o.order_status != '已退款' AND o.order_status != '已取消' GROUP BY CONVERT(char(7), o.order_date, 111)")
    List<ProductSaleAmount> findMonthSaleAmount();



}

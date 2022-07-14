package eeit45.group3.bakeyourlife.order.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {
    //查詢定單區間
    List<Order> findAllByOrderDateBetween(Date orderDateStart, Date orderDateEnd);

    List<Order> findAllByUserAndOrderDateBetween(User user,Date orderDateStart, Date orderDateEnd);

    List<Order> findAllByOrderStatusAndUser(OrderStatus orderStatus, User user);

    List<Order> findAllByOrderStatus(OrderStatus orderStatus);


    List<Order> findAllByCouponCode(String code);

    Long count();

    Integer findYearSaleAmount();

    /*
     * 用商品名稱找訂單
     *
     */

    //List<Order> findAllByItemName(String itemName);

    //用使用者ID查詢所有訂單
    List<Order> findAllByUser(User user);

    List<Order> findAllByUserId(Integer userId);



    //查詢所有訂單
    List<Order> findAll();

    Page<Order> findAll(Pageable pageable);

    //用訂單類型找訂單
    //List<Order> findAllByOrderType(Integer orderType);

    //用訂單狀態找訂單
    //List<Order> findAllByOrderStatus(Integer orderStatus);

    //用PK找訂單
    Optional<Order> findByOrderId(Integer orderId);

    //用訂單編號找訂單
    Optional<Order> findByOrderNo(String orderNo);


    //發起支付
    Order pay(Integer orderId);

    //訂單發貨
    Order deliver(Integer orderId, String trackingNumber);

    //訂單收貨
    Order receive(Integer orderId);

    //訂單取消
    Order cancel(Integer orderId);

    //訂單提出退款
    Order refund(Integer orderId,Integer refundReason);

    //訂單退款同意
    Order accept(Integer orderId);

    //訂單退款拒絕
    Order reject(Integer orderId);

    //用PK刪除訂單
    void deleteOrder(Integer orderId);

    //更新訂單
    void updateOrder(Order order);
//		void updateOrder(OrderRequest orderRequest);

    //建立訂單
    Order createOrder(Order order);

    List<OrderItem> findOrderItemByOrderId(Integer orderId);

//    Order createOrder(OrderRequest orderRequest);
}

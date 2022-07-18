package eeit45.group3.bakeyourlife.order.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.model.CartItem;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 購物車封裝物件
 */
public class Cart {

    //運費
    private Integer shippingFee = 100;
    //優惠卷
    private Coupon coupon;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //購物車商品
    private Map<String, OrderItem> cart = new HashMap<>();



    public Integer getTotal() {
        Integer total = 0;
        for(OrderItem orderItem: cart.values()) {
            Integer price = orderItem.getPrice();
            Integer qty = orderItem.getQty();
            Integer subTotal = price*qty;
            total+=subTotal;
        }
        return total+shippingFee;
    }

    public Integer getDiscountAmount() {
        if(coupon!=null){
            return coupon.getDiscountAmount(getTotal());
        }
        return 0;
    }


    public Integer getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Integer shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Map<String, OrderItem> getCart() {
        return cart;
    }



    public void addItem(CartItem cartItem, Integer qty) {
        OrderItem orderItem;
        if(qty==null) {
            qty = 1;
        }
        if(cart.containsKey(cartItem.getCartNo())){
            orderItem = cart.get(cartItem.getCartNo());
            orderItem.setQty(orderItem.getQty()+qty);
            orderItem.setSubTotal(orderItem.getPrice()*orderItem.getQty());
        }else {
            orderItem = new OrderItem();
            orderItem.setProductNo(cartItem.getCartNo());
            orderItem.setProductType(cartItem.getCartType());
            orderItem.setPrice(cartItem.getCartPrice());
            orderItem.setProductName(cartItem.getCartName());
            orderItem.setQty(qty);
            orderItem.setSubTotal(orderItem.getPrice()*orderItem.getQty());
        }
        cart.put(cartItem.getCartNo(),orderItem);
    }

    public void removeItem(String itemNo){
        cart.remove(itemNo);
    }

    public void updataItem(CartItem cartItem,Integer qty){
        if(!cart.containsKey(cartItem.getCartNo())){
            addItem(cartItem,qty);
        }else {
        OrderItem orderItem = cart.get(cartItem.getCartNo());
        orderItem.setQty(qty);
        orderItem.setSubTotal(orderItem.getPrice()*orderItem.getQty());
        cart.put(cartItem.getCartNo(), orderItem);
        }
    }

    public Order getOrder(){
        Order order = new Order();

        //訂單狀態
        order.setOrderStatus(OrderStatus.WAIT_PAYMENT);

        order.setShippingFee(this.getShippingFee());

        order.setOrderItemList(new LinkedHashSet<>(this.getCart().values()));

        order.getOrderItemList().forEach((e) -> e.setOrder(order));
        if (this.getCoupon() != null) {
            order.setCoupon(this.getCoupon());
        }

        order.setTotalPrice(this.getTotal() - this.getDiscountAmount());

        order.setDiscountAmount(this.getDiscountAmount());
        return order;
    }

}

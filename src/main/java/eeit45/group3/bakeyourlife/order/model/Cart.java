package eeit45.group3.bakeyourlife.order.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.model.CartItem;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * 購物車封裝物件
 */
public class Cart implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;


    //運費
    private Integer shippingFee = 100;
    private Integer total;
    private Integer discountAmount;
    //優惠券
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

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setCart(Map<String, OrderItem> cart) {
        this.cart = cart;
    }

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
            orderItem.setImgUrl(cartItem.getCartImgUrl());
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

    @JsonIgnore
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

    @Override
    public String toString() {
        return "Cart{" +
                "shippingFee=" + shippingFee +
                ", coupon=" + coupon +
                ", message='" + message + '\'' +
                ", cart=" + cart +
                '}';
    }

    @Override
    public Cart clone() {
        try {
            Cart clone = (Cart) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

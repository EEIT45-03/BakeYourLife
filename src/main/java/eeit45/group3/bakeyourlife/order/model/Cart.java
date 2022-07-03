package eeit45.group3.bakeyourlife.order.model;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.order.model.CartItem;
import eeit45.group3.bakeyourlife.order.model.OrderItem;

import java.util.HashMap;
import java.util.Map;


/**
 * 購物車封裝物件
 */
public class Cart {

    //運費
    private Integer shippingFee = 100;
    //優惠卷
    private Coupon coupon;

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


    public void addItem(CartItem cartItem){
        OrderItem orderItem;
        if(cart.containsKey(cartItem.getCartNo())){
            orderItem = cart.get(cartItem.getCartNo());
            orderItem.setQty(orderItem.getQty()+1);
            orderItem.setSubTotal(orderItem.getPrice()*orderItem.getQty());
        }else {
            orderItem = new OrderItem();
            orderItem.setProductNo(cartItem.getCartNo());
            orderItem.setProductType(cartItem.getCartType());
            orderItem.setPrice(cartItem.getCartPrice());
            orderItem.setProductName(cartItem.getCartName());
            orderItem.setQty(1);
            orderItem.setSubTotal(orderItem.getPrice()*orderItem.getQty());
        }
        cart.put(cartItem.getCartNo(),orderItem);
    }

    public void removeItem(String itemNo){
        cart.remove(itemNo);
    }

    public void updataItem(String itemNo,Integer qty){
        OrderItem orderItem = cart.get(itemNo);
        orderItem.setQty(qty);
        orderItem.setSubTotal(orderItem.getPrice()*orderItem.getQty());
        cart.put(itemNo, orderItem);
    }

}

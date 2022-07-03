package eeit45.group3.bakeyourlife.order.model;

public interface CartItem {

    //單字母+數字(PK)
    String getCartNo();
    //類型(烘培材料/小農...)
    String getCartType();
    //實際銷售價
    Integer getCartPrice();
    //商品名稱
    String getCartName();

    //庫存功能?


}

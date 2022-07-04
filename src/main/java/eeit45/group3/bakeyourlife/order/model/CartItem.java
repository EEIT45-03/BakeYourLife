package eeit45.group3.bakeyourlife.order.model;

public interface CartItem {

    /**
     * 回傳代號(單字母) + 商品PK
     */
    String getCartNo();
    /**
     * 回傳商品類型(烘培材料/小農)
     */
    String getCartType();
    /**
     * 回傳商品價格
     */
    Integer getCartPrice();
    /**
     * 回傳商品名稱
     */
    String getCartName();

    /**
     * 回傳商品是否可被購買
     */
    boolean isEnable();

    //庫存功能?

}

package eeit45.group3.bakeyourlife.order.model;

public class CartItemEx implements CartItem{

    /*
     *
     * 範例
     *
     */
    private Integer farmerProductId;
//    Integer id;
    private String farmerProductName;
//    String name;//名稱
    private Integer farmerProductPrice;
//    String packages;//包裝價格

    /**
     * 回傳代號 + 商品PK
     */
    @Override
    public String getCartNo() {
//        return "G"+id;
        return "F" + farmerProductId;
    }
    /**
     * 回傳商品類型
     */
    @Override
    public String getCartType() {
        return "小農";
//        return "烘培材料";
    }
    /**
     * 回傳商品價格
     */
    @Override
    public Integer getCartPrice() {
        return farmerProductPrice;
//        return Integer.valueOf(packages);
    }
    /**
     * 回傳商品名稱
     */
    @Override
    public String getCartName() {
        return farmerProductName;
//        return name;
    }
    /**
     * 回傳商品是否可被購買
     */
    @Override
    public boolean isEnable() {
        return true;
    }


}

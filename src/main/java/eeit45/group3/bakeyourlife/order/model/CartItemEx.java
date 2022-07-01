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

    @Override
    public String getCartNo() {
//        return "G"+id;
        return "F" + farmerProductId;
    }

    @Override
    public String getCartType() {
        return "小農";
//        return "烘培材料";
    }

    @Override
    public Integer getCartPrice() {
        return farmerProductPrice;
//        return Integer.valueOf(packages);
    }

    @Override
    public String getCartName() {
        return farmerProductName;
//        return name;
    }




}

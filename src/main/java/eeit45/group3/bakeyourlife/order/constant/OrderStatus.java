package eeit45.group3.bakeyourlife.order.constant;

import com.fasterxml.jackson.annotation.JsonValue;

/*
 * 用此方法輸出為
 * "orderStatus": {
 * 		code:"待收貨"
 * }PS:無@JsonValue
 * */
// @JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OrderStatus {
  // 訂單狀態
  // 訂單狀態改變事件
  // 支付，發貨，確認收貨
  // PAYED, DELIVERY, RECEIVED;
  WAIT_PAYMENT("待付款"),
  WAIT_DELIVER("待出貨"),
  WAIT_RECEIVE("待收貨"),
  FINISH("完成"),
  CANCELLED("已取消"),
  REFUNDING("退款審核中"),
  REFUNDED("已退款");

  private String code;

  OrderStatus(String string) {
    code = string;
  }
  /*
   * "orderStatus": "待收貨",
   * */
  @JsonValue
  public String getCode() {
    return code;
  }
}

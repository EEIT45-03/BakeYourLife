package eeit45.group3.bakeyourlife.order.pay;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import eeit45.group3.bakeyourlife.order.model.Order;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EcpayPayment {
  public static AllInOne all;

  private static void initial() {
    all = new AllInOne("");
  }

  public static String genAioCheckOutALL(Order order, String url) {
    // 初始化
    initial();
    // 交易日期格式
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    // 實體化交易物件
    AioCheckOutALL obj = new AioCheckOutALL();
    // 訂單編號
    obj.setMerchantTradeNo(order.getOrderNo());
    // 交易時間
    obj.setMerchantTradeDate(df.format(order.getOrderDate()));
    // 總金額
    obj.setTotalAmount(order.getTotalPrice().toString());

    obj.setTradeDesc("烘焙工作坊");
    obj.setItemName("烘焙工作坊商品一批X1");

    obj.setReturnURL("http://211.23.128.214:5000");

    obj.setOrderResultURL(url);
    obj.setNeedExtraPaidInfo("N");
    String form = all.aioCheckOut(obj, null);
    return form;
  }
}

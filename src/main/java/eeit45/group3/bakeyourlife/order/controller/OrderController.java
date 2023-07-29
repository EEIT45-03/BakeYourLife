package eeit45.group3.bakeyourlife.order.controller;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.pay.PaypalPayment;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/** 接收付款資訊、提供操作(付款、發貨...) */
@Controller
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  /*
   * 接收付款資訊
   */

  @PostMapping("/Order/ECPAY/Result")
  public String result(
      @RequestParam("RtnCode") String rtnCode,
      @RequestParam("MerchantTradeNo") String merchantTradeNo,
      RedirectAttributes model) {
    System.out.println("RtnCode: " + rtnCode);
    System.out.println("MerchantTradeNo: " + merchantTradeNo);

    Order order = orderService.findByOrderNo(merchantTradeNo).orElse(null);
    if (rtnCode.equals("1")) {
      if (order != null) {
        orderService.pay(order.getOrderId());
      }
    }
    model.addFlashAttribute("orderNo", order.getOrderNo());
    return "redirect:/Order/PaySuccess";
  }

  @GetMapping("/Order/PAYPAL/Result")
  public String resultPaypal(@RequestParam String token, RedirectAttributes model) {
    System.out.println("Token: " + token);
    String orderNo = PaypalPayment.captureOrder(token);
    Order order = orderService.findByOrderNo(orderNo).orElse(null);
    if (order != null) {
      Order pay = orderService.pay(order.getOrderId());
    }
    model.addFlashAttribute("orderNo", order.getOrderNo());
    return "redirect:/Order/PaySuccess";
  }

  /*
   * 跳轉付款成功頁面
   */

  @GetMapping("/Order/PaySuccess")
  public String paySuccess() {
    return "order/PaySuccess";
  }
}

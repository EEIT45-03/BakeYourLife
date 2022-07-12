package eeit45.group3.bakeyourlife.order.controller;

import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.pay.EcpayPayment;
import eeit45.group3.bakeyourlife.order.pay.PaypalPayment;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;


/**
 * 接收付款資訊、提供操作(付款、發貨...)
 */
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
	public String result(@RequestParam("RtnCode") String rtnCode,
			@RequestParam("MerchantTradeNo") String merchantTradeNo,
						 RedirectAttributes model) {
		System.out.println("RtnCode: " + rtnCode);
		System.out.println("MerchantTradeNo: " + merchantTradeNo);
		
		Order order = orderService.findByOrderNo(merchantTradeNo).orElse(null);
		if(rtnCode.equals("1")) {
			if(order!=null) {
				orderService.pay(order.getOrderId());
			}
		}
		model.addFlashAttribute("orderNo", order.getOrderNo());
		return "redirect:/Order/PaySuccess";
	}

	@GetMapping ("/Order/PAYPAL/Result")
	public String resultPaypal(@RequestParam String token,
							   RedirectAttributes  model) {
		System.out.println("Token: " + token);
		String orderNo = PaypalPayment.captureOrder(token);
		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		if(order!=null) {
				Order pay = orderService.pay(order.getOrderId());
		}
		model.addFlashAttribute("orderNo", order.getOrderNo());
		return "redirect:/Order/PaySuccess";
	}


	/*
	 * 跳轉付款成功頁面
	 */

	@GetMapping("/Order/PaySuccess")
	public String paySuccess(){
		return "order/PaySuccess";
	}

	/*
	* *************************************************************************************************************************
	* 提供訂單各項操作
	 */

	@GetMapping(value = "/Order/{orderNo}/Pay",produces = "text/html;charset=UTF-8")
	public ResponseEntity<String> pay(@PathVariable String orderNo, HttpServletRequest request){
		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		String baseURL = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();
		if(order!=null && order.getOrderStatus() == OrderStatus.WAIT_PAYMENT){
			switch (order.getPayType()){
				case ECPAY:
					String ecpayUrl =  baseURL + "/Order/ECPAY/Result";
					System.out.println("ecpayUrl:" + ecpayUrl);
					String string = EcpayPayment.genAioCheckOutALL(order, ecpayUrl);
					return new ResponseEntity<>(string, HttpStatus.OK);
				case PAYPAL:
					String paypalUrl =  baseURL + "/Order/PAYPAL/Result";
					System.out.println("paypalUrl:" + paypalUrl);
					return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(PaypalPayment.createPayUrl(order,paypalUrl))).build();
			}
		}
		return null;
	}


	@PostMapping("/Order/{orderNo}/Ship")
	public ResponseEntity<Order> deliver(@RequestParam String trackingNumber,
									   @PathVariable String orderNo){

		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		if(order == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"訂單編號不存在");
		}
		Order deliver = orderService.deliver(order.getOrderId(), trackingNumber);

		return ResponseEntity.status(HttpStatus.OK).body(deliver);

	}


	@PostMapping("/Order/{orderNo}/Cancel")
	public ResponseEntity<Order> cancel(@PathVariable String orderNo){

		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		if(order == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"訂單編號不存在");
		}
		Order cancel = orderService.cancel(order.getOrderId());

		return ResponseEntity.status(HttpStatus.OK).body(cancel);

	}

	@PostMapping("/Order/{orderNo}/Receive")
	public ResponseEntity<Order> receive(@PathVariable String orderNo){

		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		if(order == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"訂單編號不存在");
		}
		Order receive = orderService.receive(order.getOrderId());

		return ResponseEntity.status(HttpStatus.OK).body(receive);

	}

	@PostMapping("/Order/{orderNo}/Refund/{reason}")
	public ResponseEntity<Order> refund(@PathVariable String orderNo
	, @PathVariable Integer reason){

		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		if(order == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"訂單編號不存在");
		}
		Order cancel = orderService.refund(order.getOrderId(), reason);

		return ResponseEntity.status(HttpStatus.OK).body(cancel);

	}

	@PostMapping("/Order/{orderNo}/Refunding")
	public ResponseEntity<Order> refunding(@RequestParam String choose,
										 @PathVariable String orderNo){
		Order order = orderService.findByOrderNo(orderNo).orElse(null);
		if(order == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"訂單編號不存在");
		}
		Order refund = null;
		if(choose.equals("accept")){
			refund = orderService.accept(order.getOrderId());
		} else if (choose.equals("reject")) {
			refund = orderService.reject(order.getOrderId());
		}

		return ResponseEntity.status(HttpStatus.OK).body(refund);
	}


/*
* *************************************************************************************************************************
 */



	
}

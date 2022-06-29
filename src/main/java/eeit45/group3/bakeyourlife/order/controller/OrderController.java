package eeit45.group3.bakeyourlife.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;

@Controller
@RequestMapping(path = "/Order")
public class OrderController {
	
	
	@Autowired
	private OrderService orderService;

//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/Admin/Order/";
//	}
	
	@PostMapping("/Result")
	public String result(@RequestParam("RtnCode") String rtnCode,
			@RequestParam("MerchantTradeNo") String merchantTradeNo,
			Model model) {
		System.out.println("RtnCode: " + rtnCode);
		System.out.println("MerchantTradeNo: " + merchantTradeNo);
		
		Order order = orderService.findByOrderNo(merchantTradeNo).orElse(null);
		if(rtnCode.equals("1")) {
			if(order!=null) {
				order.setOrderStatus(OrderStatus.WAIT_DELIVER);
			}
			orderService.updateOrder(order);
		}
		model.addAttribute("orderNo", order.getOrderNo());
		return "order/PaySucess";
	}
	
	
}

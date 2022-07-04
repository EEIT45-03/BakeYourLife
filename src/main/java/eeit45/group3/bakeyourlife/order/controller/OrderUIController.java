package eeit45.group3.bakeyourlife.order.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;

@Controller
//@RequestMapping(path = "")
public class OrderUIController {
	
	@Autowired
	private OrderService orderService;
//	@Autowired
//	private UserService userService;
	
	@GetMapping("/admin/Order/")
	public String viewAdminIndex(
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date edate,
						Model model) {
		List<Order> orders = null;
		if(sdate!=null && edate!=null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(edate);
			cal.add(Calendar.DATE, 1);
			edate = cal.getTime();
			orders = orderService.findAllByOrderDateBetween(sdate, edate);
		}else {
			orders = orderService.findAll();				
		}

		model.addAttribute("orders", orders);
		return "admin/order/Order";
	}

	@GetMapping("/user/order")
	public String viewOrder(
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date edate,
			@AuthenticationPrincipal CustomUserDetails userDetails,
			Model model){
		List<Order> orders = null;
		if(sdate!=null && edate!=null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(edate);
			cal.add(Calendar.DATE, 1);
			edate = cal.getTime();
			orders = orderService.findAllByUserAndOrderDateBetween(userDetails.getUser(),sdate, edate);
		}else {
			orders = orderService.findAllByUser(userDetails.getUser());
		}

		model.addAttribute("orders", orders);
		return "order/Order";
	}
//
//	@RequestMapping("DeleteOrder")
//	public ResponseEntity<?> deleteOrder(@RequestParam Integer orderId) {
//		orderService.deleteOrder(orderId);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//	}
	
//
//	@GetMapping("/UpdateOrder")
//	public String viewUpdateOrder(@RequestParam Integer orderId,Model model) {
//		OrderRequest orderRequest = new OrderRequest();
//		Order order = null;
//		if(orderId!=null) {
//			order = orderService.findByOrderId(orderId).orElse(null);
//		}
//		if(order!=null) {
//			orderRequest.setUserId(order.getUser().getUserId());
//			orderRequest.setAddress(order.getAddress());
////			orderRequest.setOrderType(order.getOrderType());
//			orderRequest.setShippingFee(order.getShippingFee());
//			orderRequest.setOrderStatus(order.getOrderStatus().getCode());
//			orderRequest.setShipDate(order.getShipDate());
//
//
//
//			model.addAttribute("order",order);
//			model.addAttribute("orderRequest",orderRequest);
//			return "admin/order/UpdateOrder";
//		}
//		return null;
//	}
//
//	@GetMapping("CreateOrder")
//	public String viewCreateOrder() {
//		return "admin/order/CreateOrderRest";
//	}
//
//	@PostMapping("CreateOrder")
//	public String createOrder(@ModelAttribute("order") OrderRequest orderRequest ) {
//		orderService.createOrder(orderRequest);
//		return "redirect:./";
//	}
	
//	@PostMapping("UpdateOrder")
//	public String updateOrder(@RequestParam Integer orderId,@ModelAttribute("orderRequest") OrderRequest orderRequest) {
//		System.out.println(orderRequest);
//		Order orderDb = orderService.findByOrderId(orderId).orElse(null);
////
////		int orderItemTotal = orderDb.getTotalPrice()-orderDb.getShippingFee();
////
////		//更新資料
////				if(orderRequest.getUserId()!=null) {
////					User user = userService.findByUserId(orderRequest.getUserId());
////					orderDb.setUser(user);
////				}
////				if(orderRequest.getAddress()!=null) {
////					orderDb.setAddress(orderRequest.getAddress());
////				}
////				if(orderRequest.getShippingFee()!=null) {
////					orderDb.setShippingFee(Integer.valueOf(orderRequest.getShippingFee()));
////				}
////				if(orderRequest.getOrderStatus()!=null) {
////					orderDb.setOrderStatus(Stream.of(OrderStatus.values())
////			        		.filter(o -> o.getCode().equals(orderRequest.getOrderStatus()))
////			        		.findFirst()
////			        		.orElseThrow(IllegalArgumentException::new));
////				}
////				if(orderRequest.getShipDate()!=null) {
////					orderDb.setShipDate(orderRequest.getShipDate());
////				}
////
////				orderDb.setTotalPrice(orderItemTotal+orderDb.getShippingFee());
//
//		orderService.refund(orderDb.getOrderId());
//		return "redirect:./";
//	}



}

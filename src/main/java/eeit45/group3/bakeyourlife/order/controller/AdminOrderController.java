package eeit45.group3.bakeyourlife.order.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.dto.OrderRequest;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;

@Controller
@RequestMapping(path = "/admin/Order")
public class AdminOrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String viewIndex(@RequestParam(required = false) String sdate,
						@RequestParam(required = false) String edate,
						Model model) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List<Order> orders = null;
		if(sdate!=null && edate!=null) {
			model.addAttribute("sdate",sdate);
			model.addAttribute("edate",edate);
			Date orderDateStart = null;
			Date orderDateEnd = null;
			try {
				orderDateStart = df.parse(sdate);
				Calendar cal = Calendar.getInstance();
				cal.setTime(df.parse(edate));
				cal.add(Calendar.DATE, 1);
				orderDateEnd = cal.getTime();
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			orders = orderService.findAllByOrderDateBetween(orderDateStart, orderDateEnd);
		}else {
			orders = orderService.findAll();				
		}

		//設置給
		model.addAttribute("orders", orders);
		return "admin/order/Order";
	}
	
	
	@GetMapping("/UpdateOrder")
	public String viewUpdateOrder(@RequestParam Integer orderId,Model model) {
		OrderRequest orderRequest = new OrderRequest();
		Order order = null;
		if(orderId!=null) {
			order = orderService.findByOrderId(orderId).orElse(null);
		}
		if(order!=null) {
			orderRequest.setUserId(order.getUser().getUserId());
			orderRequest.setAddress(order.getAddress());
			orderRequest.setOrderType(order.getOrderType());
			orderRequest.setShippingFee(order.getShippingFee());
			orderRequest.setOrderStatus(order.getOrderStatus().getCode());
			orderRequest.setShipDate(order.getShipDate());
			
			
			
			model.addAttribute("order",order);
			model.addAttribute("orderRequest",orderRequest);
			return "admin/order/UpdateOrder";
		}
		return null;
	}
	
	@GetMapping("CreateOrder")
	public String viewCreateOrder() {
		return "admin/order/CreateOrderRest";
	}
	
	@PostMapping("CreateOrder")
	public String createOrder(@ModelAttribute("order") OrderRequest orderRequest ) {
		orderService.createOrder(orderRequest);
		return "redirect:./";
	}
	
	@PostMapping("UpdateOrder")
	public String updateOrder(@RequestParam Integer orderId,@ModelAttribute("orderRequest") OrderRequest orderRequest) {
		System.out.println(orderRequest);
		Order orderDb = orderService.findByOrderId(orderId).orElse(null);
		
		int orderItemTotal = orderDb.getTotalPrice()-orderDb.getShippingFee();
		
		//更新資料
				if(orderRequest.getUserId()!=null) {
					User user = userService.findByUserId(orderRequest.getUserId());
					orderDb.setUser(user);		
				}
				if(orderRequest.getAddress()!=null) {
					orderDb.setAddress(orderRequest.getAddress());
				}
				if(orderRequest.getShippingFee()!=null) {
					orderDb.setShippingFee(Integer.valueOf(orderRequest.getShippingFee()));
				}
				if(orderRequest.getOrderStatus()!=null) {
					orderDb.setOrderStatus(Stream.of(OrderStatus.values())
			        		.filter(o -> o.getCode().equals(orderRequest.getOrderStatus()))
			        		.findFirst()
			        		.orElseThrow(IllegalArgumentException::new));
				}
				if(orderRequest.getShipDate()!=null) {
					orderDb.setShipDate(orderRequest.getShipDate());
				}
				
				orderDb.setTotalPrice(orderItemTotal+orderDb.getShippingFee());

		orderService.refund(orderDb.getOrderId());
//		orderService.updateOrder(orderDb);
		return "redirect:./";
	}
		
	@RequestMapping("DeleteOrder")
	public ResponseEntity<?> deleteOrder(@RequestParam Integer orderId) {
		orderService.deleteOrder(orderId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
//	//此方法未來移到UserController，並調整前端
//	@GetMapping("Check")
//	@ResponseBody
//	public ResponseEntity<Map<String, Object>> viewCheckUserById(@RequestParam Integer userId) {
//		User user = null;
//		Map<String, Object> data = new HashMap<>();
//		if(userId!=null) {
//			user = userService.findByUserId(userId);
//		}
//		if(user!=null) {
//			if(user.getUserName()!=null) {
//				data.put("user_id", user.getUserId());
//				data.put("address", user.getAddress());
//				return ResponseEntity.status(HttpStatus.OK).body(data);
//			}
//		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//	}

}

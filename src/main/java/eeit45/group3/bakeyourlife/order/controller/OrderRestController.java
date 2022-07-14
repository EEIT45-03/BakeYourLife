package eeit45.group3.bakeyourlife.order.controller;

import java.util.List;

import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.constant.OrderStatusConverter;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;

@RestController
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	//查詢全部或指定日期區間
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/Orders")
	public ResponseEntity<List<Order>> getOrders(
			@RequestParam(required = false) String orderStatus,
			Authentication authentication) {
		if(authentication==null){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		OrderStatusConverter orderStatusConverter = new OrderStatusConverter();
		OrderStatus status = null;
		User user = userService.getCurrentUser(authentication);
		if(!"".equals(orderStatus)){
			status = orderStatusConverter.convertToEntityAttribute(orderStatus);
		}
		List<Order> orders = null;
		if(user!=null && status != null){
			orders = orderService.findAllByOrderStatusAndUser(status,user);
		}else {
			orders = orderService.findAllByUser(user);
		}
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}

	
	//查詢單筆訂單
	@GetMapping("/Orders/{orderId}")
	public ResponseEntity<Order> getOrder(@PathVariable Integer orderId){
		Order order = orderService.findByOrderId(orderId).orElse(null);
		
		if(order != null) {
			return ResponseEntity.status(HttpStatus.OK).body(order);
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@PostMapping("/Orders")
	public ResponseEntity<Order> createOrder(@RequestBody(required = false) Order orderReq) {
		Order orderSaved = orderService.createOrder(orderReq);
		
		Order order = orderService.findByOrderId(orderSaved.getOrderId()).orElse(null);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(order);
	}

	
	
	@DeleteMapping("/Orders/{orderId}")
	public ResponseEntity<?> deleteOrder(@PathVariable Integer orderId) {
		orderService.deleteOrder(orderId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}


	@GetMapping("/Orders/{orderId}/OrderItems")
	public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Integer orderId){
		List<OrderItem> orderItems = orderService.findOrderItemByOrderId(orderId);
		return ResponseEntity.status(HttpStatus.OK).body(orderItems);
	}



	
	
	
	
}

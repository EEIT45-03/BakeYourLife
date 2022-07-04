package eeit45.group3.bakeyourlife.order.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.constant.OrderStatusConverter;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;

import javax.persistence.Convert;

@RestController
@CrossOrigin(origins = "*")
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	//查詢全部或指定日期區間
	@GetMapping("/Orders")
	public ResponseEntity<List<Order>> getOrders(
			@RequestParam(required = false) String sdate,
			@RequestParam(required = false) String edate,
			@RequestParam(required = false) String orderStatus,
			Principal principal) {
		OrderStatusConverter orderStatusConverter = new OrderStatusConverter();
		OrderStatus status = null;
		User user = null;
		if(!"".equals(orderStatus)){
			status = orderStatusConverter.convertToEntityAttribute(orderStatus);
			user = userService.findByUsername(principal.getName());
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		List<Order> orders = null;
		if(sdate!=null && edate!=null) {
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
		}else if(user!=null && status != null){
			orders = orderService.findAllByOrderStatusAndUser(status,user);
		}else {
			orders = orderService.findAll();				
		}

		
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}





	@GetMapping("/Users/{userId}/Orders")
	public ResponseEntity<List<Order>> getOrdersByUserId(
			@PathVariable Integer userId) {
		List<Order> orders = orderService.findAllByUserId(userId);
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
	
	@PutMapping("/Orders/{orderId}")
	public ResponseEntity<Order> updateOrder(
			@PathVariable Integer orderId,
			@RequestBody(required = false) Order orderReq ) {
		Order order = orderService.findByOrderId(orderId).orElse(null);
		if(order==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		orderReq.setOrderId(orderId);
		orderService.updateOrder(orderReq);
		
		Order updatedOrder = orderService.findByOrderId(orderId).orElse(null);
		return ResponseEntity.status(HttpStatus.OK).body(updatedOrder);
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

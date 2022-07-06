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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	//查詢全部或指定日期區間
	@GetMapping("/Orders")
	public ResponseEntity<Page<Order>> getOrders(
			@RequestParam(required = false) String orderStatus,
			@RequestParam(required = false) Integer page,
			Principal principal) {
		if(principal==null){
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		OrderStatusConverter orderStatusConverter = new OrderStatusConverter();
		OrderStatus status = null;
		User user = userService.findByUsername(principal.getName());
		if(page==null){
			//如果不指定頁數，預設第一頁
			page = 1;
		}
		if(!"".equals(orderStatus)){
			status = orderStatusConverter.convertToEntityAttribute(orderStatus);
		}
		Page<Order> orders = null;
		Pageable pageable = PageRequest.of(page-1, 2);
		if(user!=null && status != null){
			/*第一個為頁數，從0開始!!!!!
			* 第二個為一頁幾個
			* */

			orders = orderService.findAllByOrderStatusAndUser(status,user,pageable);
		}else {
			orders = orderService.findAllByUser(user,pageable);
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

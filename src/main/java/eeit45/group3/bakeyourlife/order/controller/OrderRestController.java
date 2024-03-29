package eeit45.group3.bakeyourlife.order.controller;

import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.constant.OrderStatusConverter;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderRestController {

  @Autowired private OrderService orderService;
  @Autowired private UserService userService;

  // 查詢全部或指定日期區間
  @PreAuthorize("hasRole('ROLE_USER')")
  @GetMapping("/Orders")
  public ResponseEntity<List<Order>> getOrders(
      @RequestParam(required = false) String orderStatus, Authentication authentication) {

    if (authentication == null) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    OrderStatusConverter orderStatusConverter = new OrderStatusConverter();
    OrderStatus status = null;
    User user = userService.getCurrentUser(authentication);
    List<Order> orders = null;

    if (!"".equals(orderStatus)) {
      status = orderStatusConverter.convertToEntityAttribute(orderStatus);
    }
    if (user != null && status != null) {
      orders = orderService.findAllByOrderStatusAndUser(status, user);
    } else {
      orders = orderService.findAllByUser(user);
    }
    return ResponseEntity.status(HttpStatus.OK).body(orders);
  }

  @GetMapping("/OrdersByDT")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public DataTablesOutput<Order> getOrdersByDataTables(@Valid DataTablesInput input) {
    //			System.out.println(input);
    DataTablesOutput<Order> orders = null;
    orders = orderService.findAll(input);
    return orders;
  }

  // 查詢單筆訂單
  @GetMapping("/Orders/{orderId}")
  public ResponseEntity<Order> getOrder(@PathVariable Integer orderId) {
    Order order = orderService.findByOrderId(orderId).orElse(null);
    order.setOrderItemList(orderService.findOrderItemByOrderId(orderId));
    if (order != null) {
      return ResponseEntity.status(HttpStatus.OK).body(order);
    } else {
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

  //	@GetMapping("/Orders/{orderId}/OrderItems")
  //	public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable Integer orderId){
  //		List<OrderItem> orderItems = orderService.findOrderItemByOrderId(orderId);
  //		return ResponseEntity.status(HttpStatus.OK).body(orderItems);
  //	}

}

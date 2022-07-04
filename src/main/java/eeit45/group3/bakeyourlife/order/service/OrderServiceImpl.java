package eeit45.group3.bakeyourlife.order.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.coupon.service.CouponService;
import eeit45.group3.bakeyourlife.order.constant.OrderStatusChangeEvent;
import eeit45.group3.bakeyourlife.order.dao.OrderItemRepository;
import eeit45.group3.bakeyourlife.order.dao.OrderRepository;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.dto.OrderRequest;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

	private OrderRepository orderRepository;
	private OrderItemRepository orderItemRepository;
	private CouponService couponService;
	private UserService userService;
	private StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine;
	private StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister;


	public OrderServiceImpl(OrderRepository orderRepository,
							OrderItemRepository orderItemRepository,
							UserService userService,
							CouponService couponService,
							StateMachine<OrderStatus, OrderStatusChangeEvent> orderStateMachine,
							StateMachinePersister<OrderStatus, OrderStatusChangeEvent, Order> persister) {
		this.orderRepository = orderRepository;
		this.orderItemRepository = orderItemRepository;
		this.userService = userService;
		this.couponService = couponService;
		this.orderStateMachine = orderStateMachine;
		this.persister = persister;
	}


	@Override
	public List<Order> findAllByOrderDateBetween(Date orderDateStart, Date orderDateEnd) {

		return orderRepository.findAllByOrderDateBetween(orderDateStart, orderDateEnd);
	}

	@Override
	public List<Order> findAllByUserAndOrderDateBetween(User user, Date orderDateStart, Date orderDateEnd) {
		return orderRepository.findAllByUserAndOrderDateBetween(user,orderDateStart,orderDateEnd);
	}

	@Override
	public List<Order> findAllByCouponCode(String code) {
		Coupon coupon = couponService.findById(code).orElse(null);
		if(coupon != null){
			return orderRepository.findAllByCoupon(coupon);
		}
		return null;
	}

	@Override
	public List<Order> findAllByUser(User user) {
		if(user == null){
			return null;
		}
		return orderRepository.findAllByUser(user);
	}

	@Override
	public List<Order> findAllByUserId(Integer userId) {
		User user = userService.findByUserId(userId);
		if(user == null){
			return null;
		}
		return orderRepository.findAllByUser(user);
	}


	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Optional<Order> findByOrderId(Integer orderId) {
		return orderRepository.findById(orderId);
	}
	
	@Override
	public Optional<Order> findByOrderNo(String orderNo) {
		return orderRepository.findByOrderNo(orderNo);
	}

	@Override
	@Transactional
	public Order pay(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElse(null);
		order.setPayDate(new Date());
		System.out.println("訂單號：" + orderId + " 嘗試支付");
		Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.PAYED).setHeader("order", order).build());
		if (sendEvent(message, order)) {
			System.out.println("訂單號：" + orderId + " 支付失敗，狀態異常");
		}
		return order;
	}

	@Override
	@Transactional
	public Order deliver(Integer orderId,String trackingNumber) {
		Order order = orderRepository.findById(orderId).orElse(null);
		order.setTrackingNumber(trackingNumber);
		order.setShipDate(new Date());
		System.out.println("訂單號：" + orderId + " 嘗試發貨");
		Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.DELIVERY).setHeader("order", order).build());
		if (sendEvent(message, order)) {
			System.out.println("訂單號：" + orderId + " 發貨失敗，狀態異常");
		}
		orderRepository.save(order);
		return order;
	}

	@Override
	@Transactional
	public Order receive(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElse(null);
		System.out.println("訂單號：" + orderId + " 嘗試收貨");
		Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.RECEIVED).setHeader("order", order).build());
		if (sendEvent(message, order)) {
			System.out.println("訂單號：" + orderId + " 收貨失敗，狀態異常");
		}
		return order;
	}

	@Override
	@Transactional
	public Order cancel(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElse(null);
		System.out.println("訂單號：" + orderId + " 嘗試取消訂單");
		Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.CANCEL).setHeader("order", order).build());
		if (sendEvent(message, order)) {
			System.out.println("訂單號：" + orderId + " 取消訂單失敗，狀態異常");
		}
		return order;
	}

	@Override
	@Transactional
	public Order refund(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElse(null);
		System.out.println("訂單號：" + orderId + " 嘗試提出退款");
		Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.REFUND).setHeader("order", order).build());
		if (sendEvent(message, order)) {
			System.out.println("訂單號：" + orderId + " 提出退款失敗，狀態異常");
		}
		return order;
	}

	@Override
	@Transactional
	public Order accept(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElse(null);
		System.out.println("訂單號：" + orderId + " 嘗試同意退款");
		Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.ACCEPT).setHeader("order", order).build());
		if (sendEvent(message, order)) {
			System.out.println("訂單號：" + orderId + " 同意退款失敗，狀態異常");
		}
		return order;
	}

	@Override
	@Transactional
	public Order reject(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElse(null);
		System.out.println("訂單號：" + orderId + " 嘗試拒絕退款");
		Mono<Message<OrderStatusChangeEvent>> message = Mono.just(MessageBuilder.withPayload(OrderStatusChangeEvent.REJECT).setHeader("order", order).build());
		if (sendEvent(message, order)) {
			System.out.println("訂單號：" + orderId + " 拒絕退款失敗，狀態異常");
		}
		return order;
	}


	@Override
	@Transactional
	public void deleteOrder(Integer orderId) {
		orderRepository.deleteById(orderId);
	}

	@Override
	@Transactional
	public void updateOrder(Order order) {
		Order orderDb = orderRepository.findById(order.getOrderId()).orElse(null);
		if(orderDb == null){
			throw new RuntimeException("沒有找到要更新的訂單");
		}
		order.getOrderItemList().forEach(ot -> ot.setOrder(order));
		orderRepository.save(order);
	}
	
	@Override
	@Transactional
	public Order createOrder(Order order) {

//		User user = userService.findByUserId(order.getUserId());
//		order.setUser(user);
//		if(order.getTotalPrice() == null) {
//			order.setTotalPrice(0);
//		}
//		order.getOrderItemList().forEach(ot -> {
//			//設定訂單
//			ot.setOrder(order);
//			//計算總價
//			order.setTotalPrice(order.getTotalPrice() + ot.getSubTotal());
//		});
//
//		//加入運費
//		order.setTotalPrice(order.getTotalPrice() + order.getShippingFee());
//		//設定訂單編號
//		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//		Date current = new Date();
//		int end = (int) (Math.random()*10);
//		order.setOrderNo(df.format(current) + end);
//		order.setOrderDate(current);
//		order.setOrderStatus(OrderStatus.WAIT_PAYMENT);
		Coupon coupon = order.getCoupon();
		if(coupon != null && coupon.getUsedQuantity() < coupon.getMaxQuantity()){
			coupon.setUsedQuantity(coupon.getUsedQuantity()+1);
			couponService.updateCoupon(coupon);
		}

		return orderRepository.save(order);
	}
	

	@Override
	@Transactional
	public Order createOrder(OrderRequest orderRequest) {
		Order order = new Order();
		//設定訂單編號
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date current = new Date();
		int end = (int) (Math.random()*10);
		order.setOrderNo(df.format(current) + end);
		order.setOrderDate(current);
		order.setOrderStatus(OrderStatus.WAIT_PAYMENT);
		
		User user = userService.findByUserId(orderRequest.getUserId());
		order.setUser(user);
		order.setAddress(orderRequest.getAddress());
//		order.setOrderType(orderRequest.getOrderType());
		order.setShippingFee(orderRequest.getShippingFee());
		
		
		Set<OrderItem> orderItems = new LinkedHashSet<>();
		order.setOrderItemList(orderItems);
		
		int sum=0;
		for(int i = 0;i<orderRequest.getProductNo().length;i++) {
			OrderItem orderItem = new OrderItem();
			orderItem.setProductName(orderRequest.getProductName()[i].trim());
			orderItem.setProductNo(orderRequest.getProductNo()[i]);
			orderItem.setQty(orderRequest.getQty()[i]);
			orderItem.setSubTotal(orderRequest.getSubTotal()[i]);
			orderItem.setOrder(order);
			sum+=orderItem.getSubTotal();
			orderItems.add(orderItem);
		}
		
		order.setTotalPrice(sum+order.getShippingFee());
		

		return orderRepository.save(order);
	}


	@Override
	public List<OrderItem> findOrderItemByOrderId(Integer orderId){
		Order order = orderRepository.findById(orderId).orElse(null);
		if(order != null){
			return orderItemRepository.findByOrder(order);
		}
		return null;
	}





	/**
	 * 傳送訂單狀態轉換事件
	 *
	 * @param message
	 * @param order
	 * @return
	 */
	private synchronized boolean sendEvent(Mono<Message<OrderStatusChangeEvent>> message, Order order) {
		boolean result = false;
		try {
			//嘗試恢復狀態機狀態
			persister.restore(orderStateMachine, order);
			result = orderStateMachine.sendEvent(message).subscribe().isDisposed();
			//持久化狀態機狀態
			persister.persist(orderStateMachine, order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return !result;
	}
}

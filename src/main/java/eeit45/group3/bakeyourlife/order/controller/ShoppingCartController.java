package eeit45.group3.bakeyourlife.order.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.ecpay.EcpayPayment;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;

@Controller
@SessionAttributes(value = {"cart","total","shippingFee"})
public class ShoppingCartController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	GoodService goodService;
	
	@Autowired
	UserService userService;
	
	Integer shippingFee = 60;

	
	@GetMapping("/Cart")
	public String viewCart(Model model,
			@SessionAttribute(value = "cart",required = false) Map<Integer, OrderItem> cart) {
		List<Goods> goods = goodService.getAllGoods();
		model.addAttribute("goods", goods);
		//cart是null
		if(cart==null) {
			cart = new LinkedHashMap<Integer, OrderItem>();
			model.addAttribute("cart",cart);
		}
		model.addAttribute("cartItems", cart.values());
		model.addAttribute("total", total(cart));
		model.addAttribute("shippingFee", shippingFee);
		return "order/Cart";
	}
	
	@GetMapping("/Cart/Add")
	public String cartAdd(Model model,@RequestParam Integer itemId,
			@SessionAttribute("cart") Map<Integer, OrderItem> cart) {
		
		//cart是null
		if(cart==null) {
			cart = new LinkedHashMap<Integer, OrderItem>();
			model.addAttribute("cart",cart);
		}
		//檢查商品是否存在
		Goods good = goodService.getGoods(itemId);
		OrderItem orderItem = cart.get(itemId);
		if(orderItem == null && good!=null) {
			//購物車沒有，而且商品存在
			orderItem = new OrderItem();
			orderItem.setProductNo(Integer.valueOf(itemId));
			orderItem.setPrice(Integer.valueOf(good.getPackages()));
			orderItem.setProductName(good.getName());
			orderItem.setQty(1);
			orderItem.setSubTotal(orderItem.getPrice()*orderItem.getQty());
			System.out.println("購物車加入一筆商品:"+orderItem.getProductNo());
		}else {
			orderItem.setQty(orderItem.getQty() + 1 );
			orderItem.setSubTotal(orderItem.getPrice()*orderItem.getQty());
			System.out.println("購物車商品ID"+orderItem.getProductNo()+"增加數量為"+orderItem.getQty());
		}
		cart.put(itemId, orderItem);
		model.addAttribute("cartItems", cart.values());
		model.addAttribute("total", total(cart));
		model.addAttribute("shippingFee", shippingFee);
		return "order/CartBody";
	}
	
	@GetMapping("/Cart/Remove")
	public String cartRemove(Model model,@RequestParam Integer itemId,
			@SessionAttribute("cart") Map<Integer, OrderItem> cart) {
		//cart是null
		if(cart==null) {
			cart = new LinkedHashMap<Integer, OrderItem>();
			model.addAttribute("cart",cart);
			return "order/CartBody";
		}
		OrderItem orderItem = cart.get(itemId);
		if(orderItem != null) {//購物車有
			cart.remove(itemId);
			System.out.println("購物車移除商品:"+itemId);
		}
		model.addAttribute("cartItems", cart.values());
		model.addAttribute("total", total(cart));
		model.addAttribute("shippingFee", shippingFee);
		return "order/CartBody";
	}
	
	@GetMapping("/Cart/Update")
	public String cartUpdate(Model model,@RequestParam Integer itemId,
			@RequestParam Integer qty,
			@SessionAttribute("cart") Map<Integer, OrderItem> cart) {
		//cart是null
		if(cart==null) {
			cart = new LinkedHashMap<Integer, OrderItem>();
			model.addAttribute("cart",cart);
		}

		OrderItem orderItem = cart.get(itemId);
		orderItem.setQty(qty );
		orderItem.setSubTotal(orderItem.getPrice()*orderItem.getQty());
		System.out.println("購物車商品ID"+orderItem.getProductNo()+"更新數量為"+orderItem.getQty());
		cart.put(itemId, orderItem);
		
		
		model.addAttribute("cartItems", cart.values());
		model.addAttribute("total", total(cart));
		model.addAttribute("shippingFee", shippingFee);
		return "order/CartBody";
	}
	
	@GetMapping("CheckOut")
	public String viewCheckOut(@SessionAttribute("cart") Map<Integer, OrderItem> cart,
							   Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());


		model.addAttribute("address", user.getAddress());
		model.addAttribute("cartItems", cart.values());
		model.addAttribute("total", total(cart));
		model.addAttribute("shippingFee", shippingFee);
		return "order/CheckOut";
	}
	
	
	@PostMapping(path = "/CheckOut",produces = "text/html;charset=UTF-8")
	public ResponseEntity<String> checkOut(@SessionAttribute("cart") Map<Integer, OrderItem> cart,
			@RequestParam String address,
			HttpServletRequest request,
			Model model,
			Principal principal) {
		String baseURL = request.getRequestURL().substring(0, request.getRequestURL().length() - request.getRequestURI().length()) + request.getContextPath();
		if(cart!=null) {
			Order order = new Order();
			
			
			//設定訂單編號
			DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		    Date current = new Date();
		    int end = (int) (Math.random()*10);
			order.setOrderNo(df.format(current) + end);
			
			order.setOrderDate(current);
			
			//訂單狀態
			order.setOrderStatus(OrderStatus.WAIT_PAYMENT);
			
			
//			User user = (User) request.getSession().getAttribute("user");
			User user = userService.findByUsername(principal.getName());
			
			
			order.setUser(user);
			order.setAddress(address);
			order.setOrderType("一般商品");
			
			order.setShippingFee(shippingFee);
			
			order.setOrderItemList(new LinkedHashSet<>(cart.values()));
			
			order.getOrderItemList().forEach((e) -> e.setOrder(order));
			
			order.setTotalPrice(total(cart));

			orderService.createOrder(order);
			
//			request.getSession().setAttribute("cart", new LinkedHashMap<Integer, OrderItem>());
			model.addAttribute("cart", new LinkedHashMap<Integer, OrderItem>());
			//http://localhost:8080/XXXX
			//http://localhost:8080/XXXX/Order/Result
			String url =  baseURL + "/Order/Result";

//			System.out.println("Session: " + request.getSession(false).getId());
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
			String string = EcpayPayment.genAioCheckOutALL(order, url);
			return new ResponseEntity<String>(string,HttpStatus.OK);
			
			}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", baseURL+"/Cart");
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	
	
	
	
	private Integer total(Map<Integer, OrderItem> cart) {
		Integer total = 0;
		for(OrderItem orderItem: cart.values()) {
			Integer price = orderItem.getPrice();
			Integer qty = orderItem.getQty();
			Integer subTotal = price*qty;
			total+=subTotal;
		}
		return total+shippingFee;
		
	}
}

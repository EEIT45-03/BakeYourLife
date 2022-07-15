package eeit45.group3.bakeyourlife.order.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.model.Cart;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;

@Controller
@SessionAttributes(value = {"cart"})
public class OrderUIController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;


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
	public String viewOrder(){
		return "order/Order";
	}

	@GetMapping("/Cart")
	public String viewCart(@ModelAttribute Cart cart) {
//		List<Goods> goods = goodService.getAllGoods();
//		model.addAttribute("goods", goods);
		return "order/shoping-cart";
	}

	@GetMapping("CheckOut")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String viewCheckOut(@ModelAttribute("cart") Cart cart,
							   Model model, Authentication authentication) {
		if(authentication==null){
			return "redirect:/login";
		}
		User user = userService.getCurrentUser(authentication);
		model.addAttribute("address", user.getAddress());
		return "order/CheckOut";
	}

	@GetMapping("/admin/Order/sale")
	public String viewAdminSale(Model model) {
		Long count = orderService.count();
		List<Order> cancelled = orderService.findAllByOrderStatus(OrderStatus.CANCELLED);
		List<Order> refunded = orderService.findAllByOrderStatus(OrderStatus.REFUNDED);
		model.addAttribute("count", count);
		double cancelledPercent = (double)cancelled.size()/count;
		model.addAttribute("cancelled", (int)(cancelledPercent*100));
		double refundedPercent = (double)refunded.size()/count;
		model.addAttribute("refunded", (int)(refundedPercent*100));
		model.addAttribute("year",orderService.findYearSaleAmount());
		return "admin/order/Chart";
	}

	@ModelAttribute
	public Cart cart(@ModelAttribute Cart cart) {
		if (cart == null) {
			return new Cart();
		}
		return cart;
	}
}

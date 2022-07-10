package eeit45.group3.bakeyourlife.order.controller;

import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.order.model.Cart;
import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String viewCheckOut(@ModelAttribute("cart") Cart cart,
							   Model model, Principal principal) {
		if(principal==null){
			return "redirect:/login";
		}
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("address", user.getAddress());
		return "order/CheckOut";
	}

	@GetMapping("/admin/Order/sale")
	public String viewAdminSale(Model model) {
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

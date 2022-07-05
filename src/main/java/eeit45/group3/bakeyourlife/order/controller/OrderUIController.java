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
	public String viewOrder(){
		return "order/Order";
	}


}

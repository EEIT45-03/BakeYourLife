package eeit45.group3.bakeyourlife.good.controller;//package eeit45.group3.bakeyourlife.good.controller;

import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.util.List;


@Controller
@RequestMapping(path = "/Goods1")
public class GoodsController2 {

	private GoodService goodService;
	private ServletContext context;
	@Autowired
	public GoodsController2(GoodService goodService, ServletContext context) {
		super();
		this.goodService = goodService;
		this.context = context;
	}

	@GetMapping("/")
	public String redirect(Model m) {
		List<Goods> goods = goodService.getAllGoods();
		m.addAttribute("goods", goods);
	return "admin/goods/Goods1";
	}

}

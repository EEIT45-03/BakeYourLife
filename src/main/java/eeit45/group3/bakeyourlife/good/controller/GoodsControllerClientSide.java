package eeit45.group3.bakeyourlife.good.controller;//package eeit45.group3.bakeyourlife.good.controller;

import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import java.util.List;


@Controller
@RequestMapping(path = "/Goods1")
public class GoodsControllerClientSide {

	private GoodService goodService;
	private ServletContext context;
	@Autowired
	public GoodsControllerClientSide(GoodService goodService, ServletContext context) {
		super();
		this.goodService = goodService;
		this.context = context;
	}

	@GetMapping("/")
	public String redirect(Model m) {
		List<Goods> goods = goodService.getAllGoods();
		m.addAttribute("goods", goods);
	return "admin/goods/GoodsClientSide";
	}

	@GetMapping(value = "/Picture")
	public String picture(@RequestParam("id") int id, Model model){
		Goods good = goodService.getGoods(id);
		model.addAttribute("Goods",good);
		return "admin/goods/BuyGoodsClientSide";
	}

}
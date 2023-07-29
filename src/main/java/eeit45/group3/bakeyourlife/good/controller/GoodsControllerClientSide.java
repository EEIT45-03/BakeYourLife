package eeit45.group3.bakeyourlife.good.controller; // package
                                                    // eeit45.group3.bakeyourlife.good.controller;

import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    List<Goods> goods = goodService.getAllBySystem("上架中");
    m.addAttribute("goods", goods);
    List<Goods> sales = goodService.findGoodsSales();
    m.addAttribute("Sales", sales);
    return "admin/goods/GoodsClientSide";
  }

  @GetMapping(value = "/Picture")
  public String picture(
      @RequestParam("id") int id, @RequestParam("name") String name, Model model) {
    char lastChar = name.charAt(name.length() - 1);
    String lastString = String.valueOf(lastChar);
    Goods good = goodService.getGoods(id);
    List<Goods> goods = goodService.getAllByNameLike("%" + lastString + "%");
    model.addAttribute("Goods1", goods);
    model.addAttribute("Goods", good);
    return "admin/goods/BuyGoodsClientSide";
  }

  @GetMapping("/GoodsProducts/{packagematerial}")
  public ResponseEntity<List<Goods>> findByType(@PathVariable String packagematerial) {
    List<Goods> goodsList = null;
    if ("商品總覽".equals(packagematerial)) {
      goodsList = goodService.findBySystemOrderByAdmissionTimeDesc("上架中");
    } else {
      goodsList =
          goodService.findByPackagematerialAndSystemOrderByAdmissionTimeDesc(packagematerial);
    }
    return ResponseEntity.status(HttpStatus.OK).body(goodsList);
  }

  //	@GetMapping("flour")
  //	public String flour(Model model){
  //		List<Goods> goods = goodService.getAllByNameLike("%麵粉%");
  //		model.addAttribute("Goods",goods);
  //		return "good/GoodsClientSideByFlour";
  //	}
}

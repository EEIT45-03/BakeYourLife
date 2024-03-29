package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/FarmerProductShop")
public class FarmerProductShopController {

  FarmerProductService farmerProductService;
  FarmerService farmerService;

  @Autowired
  public FarmerProductShopController(
      FarmerProductService farmerProductService, FarmerService farmerService) {
    this.farmerProductService = farmerProductService;
    this.farmerService = farmerService;
  }

  @GetMapping("/ShopDetails/{id}")
  private String ShopDetails(@PathVariable Integer id, Model model) {
    FarmerProductBean farmerProductBean = null;
    List<FarmerProductBean> farmerProductBeanList = null;
    if (id != null) {
      farmerProductBean = farmerProductService.findByFarmerProductId(id);
      farmerProductBeanList =
          farmerProductService.findByTypeAndStateAndFarmerProductIdNotOrderByLaunchedTimeDesc(
              farmerProductBean.getType(), id);
    }

    model.addAttribute(farmerProductBean);
    model.addAttribute(farmerProductBeanList);
    return "farmerproduct/FarmerProductShopDetails";
  }

  @GetMapping("/ShopGrid")
  private String ShopGrid(Model model) {
    List<FarmerProductBean> farmerProductBeanList =
        farmerProductService.findByStateOrderByLaunchedTimeDesc(0);
    model.addAttribute(farmerProductBeanList);

    List<Farmer> farmerList = farmerService.findAll();
    model.addAttribute(farmerList);

    List<FarmerProductBean> topSixList = farmerProductService.topSix();
    model.addAttribute("topSixList", topSixList);

    return "farmerproduct/FarmerProductShopGrid";
  }

  @GetMapping("/ShopGrid/{id}")
  private String SupplierShopGrid(Model model, @PathVariable Integer id) {

    List<FarmerProductBean> farmerProductBeanList =
        farmerProductService.findByStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(id);
    model.addAttribute(farmerProductBeanList);

    Integer count = farmerProductBeanList.size();
    model.addAttribute("count", count);

    Farmer farmer = farmerService.findByFarmerId(id);
    model.addAttribute(farmer);
    Float star = farmerProductService.avgStarByFarmerId(id);
    String avgStar = "<i class='fa-solid fa-star fa-xs' style='color: #ffd922'></i> " + star;
    model.addAttribute("avgStar", avgStar);

    List<FarmerProductBean> topSixList = farmerProductService.topSix();
    model.addAttribute("topSixList", topSixList);

    return "farmerproduct/SupplierShopGrid";
  }
}

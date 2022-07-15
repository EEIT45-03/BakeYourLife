package eeit45.group3.bakeyourlife.farmerproduct.controller;


import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/FarmerProductShop")
public class FarmerProductShopController {

    FarmerProductService farmerProductService;
    FarmerService farmerService;

    @Autowired
    public FarmerProductShopController(FarmerProductService farmerProductService, FarmerService farmerService) {
        this.farmerProductService = farmerProductService;
        this.farmerService = farmerService;
    }

    @GetMapping("/ShopDetails/{id}")
    private String ShopDetails(@PathVariable Integer id, Model model) {
        FarmerProductBean farmerProductBean = null;

        if (id != null) {
            farmerProductBean = farmerProductService.findByFarmerProductId(id);
        }

        model.addAttribute(farmerProductBean);

        return "farmerproduct/FarmerProductShopDetails";
    }

    @GetMapping("/ShopGrid")
    private String ShopGrid(Model model) {
        List<FarmerProductBean> farmerProductBeanList = farmerProductService.findByStateOrderByLaunchedTimeDesc(0);
        model.addAttribute(farmerProductBeanList);

        List<Farmer> farmerList = farmerService.findAll();

        model.addAttribute(farmerList);

        return "farmerproduct/FarmerProductShopGrid";
    }

    @GetMapping("/ShopGrid/{id}")
    private String SupplierShopGrid(Model model, @PathVariable Integer id) {
        List<FarmerProductBean> farmerProductBeanList = farmerProductService.findByFarmerId(id);
        model.addAttribute(farmerProductBeanList);
        Farmer farmer = farmerService.findByFarmerId(id);
        model.addAttribute(farmer);

        return "farmerproduct/SupplierShopGrid";
    }


}

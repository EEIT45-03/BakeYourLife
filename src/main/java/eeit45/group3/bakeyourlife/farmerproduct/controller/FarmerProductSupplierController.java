package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FarmerProductSupplierController {

    FarmerProductService farmerProductService;

    @Autowired
    public FarmerProductSupplierController(FarmerProductService farmerProductService) {
        this.farmerProductService = farmerProductService;
    }


    @GetMapping("/FarmerProductSupplier")
    public String viewIndex(Model model) {
        List<FarmerProductBean> farmerProductBeans = farmerProductService.findAll();

        model.addAttribute("farmerProductBeans", farmerProductBeans);
//        return "admin/farmerproduct/FarmerProductSupplier";
        return "farmerproduct/FarmerProductSupplier";
    }

    @GetMapping("/FarmerProductSupplier/CreateFarmerProduct")
    public String viewCreateFarmerProduct(Model model) {
        model.addAttribute("farmerProductBean", new FarmerProductBean());
        return "farmerproduct/CreateFarmerProduct";
    }


    @GetMapping("/FarmerProductSupplier/UpdateFarmerProduct")
    private String viewUpdateFarmerProduct(@RequestParam Integer farmerProductId, Model model) {

        FarmerProductBean farmerProductBean = null;

        if (farmerProductId != null) {
            farmerProductBean = farmerProductService.findByFarmerProductId(farmerProductId);
        }

        model.addAttribute(farmerProductBean);

        return "farmerproduct/UpdateFarmerProduct";

    }

    @GetMapping("/FarmerProductSupplier/ShopDetails")
    private String ShopDetails(@RequestParam Integer farmerProductId, Model model) {
        FarmerProductBean farmerProductBean = null;

        if (farmerProductId != null) {
            farmerProductBean = farmerProductService.findByFarmerProductId(farmerProductId);
        }

        model.addAttribute(farmerProductBean);

        return "farmerproduct/FarmerProductShopDetails";
    }

 
}

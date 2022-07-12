package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/FarmerProductSupplier")
public class FarmerProductSupplierController {

    FarmerProductService farmerProductService;

    @Autowired
    public FarmerProductSupplierController(FarmerProductService farmerProductService) {
        this.farmerProductService = farmerProductService;
    }

    @GetMapping("/")
    public String viewChart() {

        return "farmerproduct/SupplierChart";
    }


    @GetMapping("/SupplierProductList")
    public String viewProductList(Model model) {
        List<FarmerProductBean> farmerProductBeans = farmerProductService.findAll();

        model.addAttribute("farmerProductBeans", farmerProductBeans);
//        return "admin/farmerproduct/FarmerProductSupplier";
        return "farmerproduct/SupplierProductList";
    }

    @GetMapping("/SupplierProductList/CreateFarmerProduct")
    public String viewCreateFarmerProduct(Model model) {
        model.addAttribute("farmerProductBean", new FarmerProductBean());
        return "farmerproduct/CreateFarmerProduct";
    }


    @GetMapping("/SupplierProductList/UpdateFarmerProduct")
    private String viewUpdateFarmerProduct(@RequestParam Integer farmerProductId, Model model) {

        FarmerProductBean farmerProductBean = null;

        if (farmerProductId != null) {
            farmerProductBean = farmerProductService.findByFarmerProductId(farmerProductId);
        }

        model.addAttribute(farmerProductBean);

        return "farmerproduct/UpdateFarmerProduct";

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

        return "farmerproduct/FarmerProductShopGrid";
    }


}

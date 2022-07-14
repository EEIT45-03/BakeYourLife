package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/FarmerProductSupplier")
public class FarmerProductSupplierController {

    FarmerProductService farmerProductService;

    FarmerService farmerService;

    @Autowired
    public FarmerProductSupplierController(FarmerProductService farmerProductService, FarmerService farmerService) {
        this.farmerProductService = farmerProductService;
        this.farmerService = farmerService;
    }


    @GetMapping("/")
    public String viewChart(Principal principal, Model model) {
        if (principal != null) {
            Farmer farmer = farmerService.findByUsername(principal.getName());
            if (farmer.getFarmerId() != null) {
                model.addAttribute("farmer", farmer);
                Long count = farmerProductService.countByFarmerId(farmer.getFarmerId());
                model.addAttribute("count", count);
                return "farmerproduct/SupplierChart";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("UpdateSupplier")
    public String viewUpdateSupplier(Principal principal, Model model) {
        if (principal != null) {
            Farmer farmer = farmerService.findByUsername(principal.getName());
            if (farmer.getFarmerId() != null) {
                model.addAttribute("farmer", farmer);
                return "farmerproduct/UpdateSupplier";
            }
        }
        return "redirect:/login";
    }


    @GetMapping("SupplierProductList")
    public String viewProductList(Model model, Principal principal) {

        if (principal != null) {
            Farmer farmer = farmerService.findByUsername(principal.getName());
            model.addAttribute("farmer", farmer);
            List<FarmerProductBean> farmerProductBeans = farmerProductService.findByFarmerId(farmer.getFarmerId());
            model.addAttribute("farmerProductBeans", farmerProductBeans);
            return "farmerproduct/SupplierProductList";
        }
        return "redirect:/login";

    }

    @GetMapping("SupplierProductList/CreateFarmerProduct")
    public String viewCreateFarmerProduct(Model model, Principal principal) {
        if (principal != null) {
            Farmer farmer = farmerService.findByUsername(principal.getName());
            model.addAttribute("farmer", farmer);
            model.addAttribute("farmerProductBean", new FarmerProductBean());
            return "farmerproduct/CreateFarmerProduct";

        }
        return "redirect:/login";

    }


    @GetMapping("SupplierProductList/UpdateFarmerProduct")
    private String viewUpdateFarmerProduct(@RequestParam Integer farmerProductId, Model model) {

        FarmerProductBean farmerProductBean = null;

        if (farmerProductId != null) {
            farmerProductBean = farmerProductService.findByFarmerProductId(farmerProductId);
        }

        model.addAttribute(farmerProductBean);

        return "farmerproduct/UpdateFarmerProduct";

    }


}

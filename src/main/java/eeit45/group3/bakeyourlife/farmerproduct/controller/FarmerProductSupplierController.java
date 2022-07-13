package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/FarmerProductSupplier")
public class FarmerProductSupplierController {

    FarmerProductService farmerProductService;

    UserService userService;

    @Autowired
    public FarmerProductSupplierController(FarmerProductService farmerProductService, UserService userService) {
        this.farmerProductService = farmerProductService;
        this.userService = userService;
    }


    @GetMapping("/")
    public String viewChart(Principal principal, Model model) {
        if (principal != null) {
            User user = userService.findByUsername(principal.getName());
            model.addAttribute("user", user);
            Long count = farmerProductService.countByFarmerId(user.getUserId());
            model.addAttribute("count", count);
            return "farmerproduct/SupplierChart";
        }
        return "redirect:/login";
    }


    @GetMapping("SupplierProductList")
    public String viewProductList(Model model, Principal principal) {

        if (principal != null) {
            User user = userService.findByUsername(principal.getName());
            model.addAttribute("user", user);
            List<FarmerProductBean> farmerProductBeans = farmerProductService.findByUserId(user.getUserId());
            model.addAttribute("farmerProductBeans", farmerProductBeans);
            return "farmerproduct/SupplierProductList";
        }
        return "redirect:/login";

    }

    @GetMapping("SupplierProductList/CreateFarmerProduct")
    public String viewCreateFarmerProduct(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.findByUsername(principal.getName());
            model.addAttribute("user", user);
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

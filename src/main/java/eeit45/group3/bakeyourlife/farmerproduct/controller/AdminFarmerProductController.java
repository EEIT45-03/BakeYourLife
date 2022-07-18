package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductPic;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminFarmerProductController {

    FarmerProductService farmerProductService;

    FarmerService farmerService;

    @Autowired
    public AdminFarmerProductController(FarmerProductService farmerProductService, FarmerService farmerService) {
        this.farmerProductService = farmerProductService;
        this.farmerService = farmerService;
    }

    @GetMapping("/admin/FarmerProduct/Chart")
    public String viewChart(Model model) {
        String saleAmount = farmerProductService.saleAmount();
        model.addAttribute("saleAmount", saleAmount);
        Long farmerCount = farmerService.count();
        model.addAttribute("farmerCount", farmerCount);
        Long count = farmerProductService.count();
        model.addAttribute("count", count);
        Float avgStar = farmerProductService.avgStar();
        model.addAttribute("avgStar", avgStar);
        return "admin/farmerproduct/AdminFarmerProductChart";
    }

    @GetMapping("/admin/FarmerProduct")
    public String viewProductList(Model model) {
        List<FarmerProductBean> farmerProductBeans = farmerProductService.findAll();
        model.addAttribute("farmerProductBeans", farmerProductBeans);
        return "admin/farmerproduct/FarmerProduct";
    }


    @GetMapping("/admin/FarmerProduct/UpdateFarmerProduct")
    private String viewUpdateFarmerProduct(@RequestParam Integer farmerProductId, Model model) {

        FarmerProductBean farmerProductBean = null;

        if (farmerProductId != null) {
            farmerProductBean = farmerProductService.findByFarmerProductId(farmerProductId);
        }

        model.addAttribute(farmerProductBean);

        return "admin/farmerproduct/UpdateFarmerProduct";

    }

}

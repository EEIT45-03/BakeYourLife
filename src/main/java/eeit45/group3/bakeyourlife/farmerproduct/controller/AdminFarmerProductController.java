package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductPic;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
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

    @Autowired
    public AdminFarmerProductController(FarmerProductService farmerProductService) {
        this.farmerProductService = farmerProductService;
    }

    @GetMapping("/admin/FarmerProduct/Chart")
    public String viewChart(Model model) {
        Long count = farmerProductService.count();
        model.addAttribute("count", count);
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

package eeit45.group3.bakeyourlife.farmerproduct.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;

@Controller
@RequestMapping(path = "/admin/FarmerProductSupplier")
public class FarmerProductSupplierController {

    FarmerProductService farmerProductService;

    @Autowired
    public FarmerProductSupplierController(FarmerProductService farmerProductService) {
        this.farmerProductService = farmerProductService;
    }

    @GetMapping("/")
    public String viewIndex(Model model) {
        List<FarmerProductBean> farmerProductBeans = farmerProductService.findAll();
        model.addAttribute("farmerProductBeans", farmerProductBeans);
        return "admin/farmerproduct/FarmerProductSupplier";
    }

    @GetMapping("CreateFarmerProduct")
    public String viewCreateFarmerProduct(Model model) {
        model.addAttribute("farmerProductBean", new FarmerProductBean());
        return "admin/farmerproduct/CreateFarmerProduct";
    }

    @PostMapping("CreateFarmerProduct")
    public String createFarmerProduct(@ModelAttribute FarmerProductBean farmerProductBean) {

        Date date = new Date();
        farmerProductBean.setLaunchedTime(date);
        farmerProductService.insert(farmerProductBean);
        return "redirect:./";
    }

    @GetMapping("/UpdateFarmerProduct")
    private String viewUpdateFarmerProduct(@RequestParam Integer farmerProductId, Model model) {

        FarmerProductBean farmerProductBean = null;

        if (farmerProductId != null) {
            farmerProductBean = farmerProductService.findByFarmerProductId(farmerProductId);
        }

        model.addAttribute(farmerProductBean);

        return "admin/farmerproduct/UpdateFarmerProduct";

    }

    @PostMapping("UpdateFarmerProduct")
    private String updateFarmerProduct(@RequestParam Integer farmerProductId, FarmerProductBean farmerProductBean) {
        FarmerProductBean farmerProductBeanDb = farmerProductService.findByFarmerProductId(farmerProductId);

        if (farmerProductBeanDb != null) {
            farmerProductService.update(farmerProductBean);
        }

        return "redirect:./";
    }

    @RequestMapping("UpdateFarmerProductState")
    private String updateFarmerProductState(@RequestParam Integer farmerProductId, @RequestParam Integer state) {
        FarmerProductBean farmerProductBean = null;
        if (farmerProductId != null) {
            farmerProductBean = farmerProductService.findByFarmerProductId(farmerProductId);
        }
        farmerProductBean.setState(state);
        Date date = new Date();
        switch (state) {
            case 0:
                farmerProductBean.setLaunchedTime(date);
                break;
            case 1:
                farmerProductBean.setSuspendTime(date);
                break;
            case 2:
                farmerProductBean.setViolationTime(date);
                break;
            default:
                break;
        }

        farmerProductService.update(farmerProductBean);
        return "redirect:./";
    }

    @RequestMapping("DeleteFarmerProduct")
    private String deleteFarmerProduct(@RequestParam Integer farmerProductId) {
        farmerProductService.delete(farmerProductId);
        return "redirect:./";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

}

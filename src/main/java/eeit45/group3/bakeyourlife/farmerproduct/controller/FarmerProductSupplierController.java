package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/FarmerProductSupplier")
public class FarmerProductSupplierController {

    FarmerProductService farmerProductService;

    FarmerService farmerService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public FarmerProductSupplierController(FarmerProductService farmerProductService, FarmerService farmerService) {
        this.farmerProductService = farmerProductService;
        this.farmerService = farmerService;
    }


    @GetMapping("/")
    public String viewChart(Principal principal, Model model) {
        if (principal != null) {
            Farmer farmer = farmerService.findByUsername(principal.getName());
            System.out.println(principal.getName());
            if (farmer.getFarmerId() != null) {
                model.addAttribute("farmer", farmer);
                Integer saleAmount = farmerProductService.saleAmountByFarmerId(farmer.getFarmerId());
                model.addAttribute("saleAmount", saleAmount);
                Long count = farmerProductService.countByFarmerId(farmer.getFarmerId());
                model.addAttribute("count", count);
                return "farmerproduct/SupplierChart";
            }
        }
        return "redirect:/login";
    }

    @GetMapping("/UpdateSupplier")
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


    @PostMapping("/UpdateSupplier")
    public String updateSupplier(Authentication authentication, @RequestParam(required = false) Farmer password, Farmer farmer) {

        Farmer farmerDB = farmerService.getCurrentFarmer(authentication);
//        System.out.println("密碼正確:" + encoder.matches(user.getPassword(),userDB.getPassword()));
        MultipartFile productImage = farmer.getProductImage();
        if (productImage.getSize() == 0) {
            farmer.setImageUrl(farmerDB.getImageUrl());
        } else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            farmer.setImageUrl(link);
        }

        if (farmer.getPassword() == null){
            farmer.setPassword(farmerDB.getPassword());
        }else {
            farmer.setPassword(encoder.encode(farmer.getPassword()));
        }

        farmer.setRegisterTime(farmerDB.getRegisterTime());
        farmer.setAuthority(farmerDB.getAuthority());
        farmer.setFarmerId(farmerDB.getFarmerId());
        farmerService.updateFarmer(farmer);
        farmerService.setCurrentFarmer(authentication,farmer);
        return "farmerproduct/UpdateSupplier";


    }




    @GetMapping("SupplierProductList")
    public String viewProductList(Model model, Principal principal) {

        if (principal != null) {
            Farmer farmer = farmerService.findByUsername(principal.getName());
            List<FarmerProductBean> farmerProductBeans = farmerProductService.findByFarmerId(farmer.getFarmerId());
            model.addAttribute("farmerProductBeans", farmerProductBeans);
            return "farmerproduct/SupplierProductList";
        }
        return "redirect:/login";

    }

    @GetMapping("SupplierProductList/CreateFarmerProduct")
    public String viewCreateFarmerProduct(Model model, Principal principal) {
        if (principal != null) {
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

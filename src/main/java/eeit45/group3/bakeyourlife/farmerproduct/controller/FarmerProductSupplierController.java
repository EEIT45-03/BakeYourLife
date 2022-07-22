package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
                String saleAmount = farmerProductService.saleAmountByFarmerId(farmer.getFarmerId());
                model.addAttribute("saleAmount", saleAmount);
                Long count = farmerProductService.countByFarmerId(farmer.getFarmerId());
                model.addAttribute("count", count);
                Float avgStar = farmerProductService.avgStarByFarmerId(farmer.getFarmerId());
                model.addAttribute("avgStar", avgStar);
                String topSaleItem = farmerProductService.topSaleItemByFarmerId(farmer.getFarmerId());
                if (topSaleItem != null) {

                    String[] item = topSaleItem.split("@");
                    model.addAttribute("item", item);
                }
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


        farmer.setPassword(farmerDB.getPassword());
        farmer.setRegisterTime(farmerDB.getRegisterTime());
        farmer.setAuthority(farmerDB.getAuthority());
        farmer.setFarmerId(farmerDB.getFarmerId());
        farmer.setEnabled(farmerDB.isEnabled());

        farmerService.updateFarmer(farmer);
        farmerService.setCurrentFarmer(authentication, farmer);
        return "farmerproduct/UpdateSupplier";

    }

    //----小農管理中心內更改密碼------------------------------------------------------------------
    @GetMapping("/UpdateSupplierPsw")
    public String viewUpdateSupplierPsw(Principal principal, Model model) {
        if (principal != null) {
            Farmer farmer = farmerService.findByUsername(principal.getName());
            if (farmer.getFarmerId() != null) {
                model.addAttribute("farmer", farmer);
                return "farmerproduct/FarmerUpdatepsw";
            }
        }
        return "redirect:/login";
    }

    @PostMapping("/UpdateSupplierPsw")
    public String updatepsw(Authentication authentication, Farmer farmer) {

        Farmer farmerDB = farmerService.getCurrentFarmer(authentication);
//        System.out.println("密碼正確:" + encoder.matches(user.getPassword(),userDB.getPassword()));
        boolean flag = encoder.matches(farmer.getPassword(), farmerDB.getPassword());

        if (!flag) {
            return "farmerproduct/UpdateFarmerpsw_fail";
        }
        farmer.setPassword(encoder.encode(farmer.getNewPassword()));
        farmer.setFarmerId(farmerDB.getFarmerId());
        farmer.setImageUrl(farmerDB.getImageUrl());
        farmer.setUsername(farmerDB.getUsername());
        farmer.setFarmerName(farmerDB.getFarmerName());
        farmer.setEmail(farmerDB.getEmail());
        farmer.setPhone(farmerDB.getPhone());
        farmer.setAddress(farmerDB.getAddress());
        farmer.setRegisterTime(farmerDB.getRegisterTime());
        farmer.setAuthority(farmerDB.getAuthority());
        farmer.setEnabled(farmerDB.isEnabled());
        farmer.setFarmerInfo(farmerDB.getFarmerInfo());
        farmerService.updateFarmer(farmer);
        return "farmerproduct/UpdateFarmerpsw_success";

    }
//------小農管理中心內更改密碼end----------------------------------------------------------

    //------小農管理中心內忘記密碼-----------------------------------------------------------------
    @GetMapping("/FindSupplierPsw")
    public String viewFindSupplierPsw() {
        return "farmerproduct/FarmerFindpsw";
    }

    @GetMapping("/process_FindSupplierPsw")
    public String process_FindSupplierPsw(Principal principal) {
        if (principal != null) {
            Farmer farmer = farmerService.findByUsername(principal.getName());
            farmerService.farmerResetPsw(farmer);
            return "farmerproduct/farmerPswReset_start";
        }
        return "redirect:/login";
    }

    @GetMapping("/farmerPswVerify")
    public String farmerPswVerify(@Param("code") String code, Principal principal, Model model) {
        Farmer farmer = farmerService.findByUsername(principal.getName());
        model.addAttribute("farmer", farmer);

        if (farmerService.farmerpswverify(code)) {
            return "farmerproduct/farmerPswVerify_success";
        } else {
            return "farmerproduct/farmerPswVerify_fail";
        }
    }

    @PostMapping("farmerPswReset")
    public String farmerPswReset(Authentication authentication, Farmer farmer) {
        Farmer farmerDB = farmerService.getCurrentFarmer(authentication);
        farmer.setPassword(encoder.encode(farmer.getPassword()));
        farmer.setFarmerId(farmerDB.getFarmerId());
        farmer.setImageUrl(farmerDB.getImageUrl());
        farmer.setUsername(farmerDB.getUsername());
        farmer.setFarmerName(farmerDB.getFarmerName());
        farmer.setEmail(farmerDB.getEmail());
        farmer.setPhone(farmerDB.getPhone());
        farmer.setAddress(farmerDB.getAddress());
        farmer.setRegisterTime(farmerDB.getRegisterTime());
        farmer.setAuthority(farmerDB.getAuthority());
        farmer.setEnabled(farmerDB.isEnabled());
        farmer.setFarmerInfo(farmerDB.getFarmerInfo());

        farmerService.updateFarmer(farmer);


        return "farmerproduct/farmerPswReset_success";
    }

//------小農管理中心內忘記密碼END-----------------------------------------------------------------


    @GetMapping("SupplierProductList")
    public String viewProductList(Model model, Principal principal) {

        if (principal != null) {
            Farmer farmer = farmerService.findByUsername(principal.getName());
            List<FarmerProductBean> farmerProductBeans = farmerProductService.findByFarmerFarmerIdOrderByLaunchedTimeDesc(farmer.getFarmerId());
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

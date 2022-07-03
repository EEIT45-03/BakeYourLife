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
@RequestMapping(path = "/admin/FarmerProductSupplier")
public class FarmerProductSupplierController {

    FarmerProductService farmerProductService;

    @Autowired
    public FarmerProductSupplierController(FarmerProductService farmerProductService) {
        this.farmerProductService = farmerProductService;
    }

    //    FarmerProductPicService farmerProductPicService;
//
//    //    @Autowired
//    public FarmerProductSupplierController(FarmerProductService farmerProductService, FarmerProductPicService farmerProductPicService) {
//        this.farmerProductService = farmerProductService;
//        this.farmerProductPicService = farmerProductPicService;
//    }

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

        List<String> dataUrls = farmerProductBean.getPictureDataUrl();
        List<FarmerProductPic> farmerProductPicList = new ArrayList<>();

        if (dataUrls.get(0).length() < 30) {
            String dataUrl = dataUrls.get(0) + "," + dataUrls.get(1);
            FarmerProductPic farmerProductPic = new FarmerProductPic();
            farmerProductPic.setFarmerProductBean(farmerProductBean);
            farmerProductPic.setPictureDataUrl(dataUrl);
            farmerProductPicList.add(farmerProductPic);
        } else {

            for (String dataUrl : dataUrls) {
                FarmerProductPic farmerProductPic = new FarmerProductPic();
                if (dataUrl != null && dataUrl.length() > 0) {
                    farmerProductPic.setFarmerProductBean(farmerProductBean);
                    farmerProductPic.setPictureDataUrl(dataUrl);
                    farmerProductPicList.add(farmerProductPic);
                }
            }
        }


        Date date = new Date();
        farmerProductBean.setLaunchedTime(date);
        farmerProductBean.setFarmerProductPicList(farmerProductPicList);
        farmerProductService.insert(farmerProductBean);


//        farmerProductPicService.insertAll(farmerProductPicList);
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

        List<String> dataUrls = farmerProductBean.getPictureDataUrl();
        List<FarmerProductPic> farmerProductPicList = new ArrayList<>();

        if (dataUrls.get(0).length() < 30) {
            String dataUrl = dataUrls.get(0) + "," + dataUrls.get(1);
            FarmerProductPic farmerProductPic = new FarmerProductPic();
            farmerProductPic.setFarmerProductBean(farmerProductBean);
            farmerProductPic.setPictureDataUrl(dataUrl);
            farmerProductPicList.add(farmerProductPic);
        } else {

            for (String dataUrl : dataUrls) {
                FarmerProductPic farmerProductPic = new FarmerProductPic();
                if (dataUrl != null && dataUrl.length() > 0) {
                    farmerProductPic.setFarmerProductBean(farmerProductBean);
                    farmerProductPic.setPictureDataUrl(dataUrl);
                    farmerProductPicList.add(farmerProductPic);
                }
            }
        }

        farmerProductBean.setFarmerProductPicList(farmerProductPicList);

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

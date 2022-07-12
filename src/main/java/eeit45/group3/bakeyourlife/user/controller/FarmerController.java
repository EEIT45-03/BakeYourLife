package eeit45.group3.bakeyourlife.user.controller;

import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin/Farmer")
public class FarmerController {

    FarmerService farmerService;
    private ServletContext context;

    @Autowired
    public FarmerController(FarmerService farmerService, ServletContext context) {
        this.farmerService = farmerService;
        this.context = context;
    }

    @GetMapping("/")
    public String viewIndex(Model model) {
        List<Farmer> farmers = farmerService.findAll();
        model.addAttribute("farmers", farmers);
        return "admin/user/Farmer";
    }

    @GetMapping("CreateFarmer")
    public String viewCreateFarmer(Model model) {
        model.addAttribute("farmer",new Farmer());

        return "admin/user/CreateFarmer";
    }

    @PostMapping("CreateFarmer")
    public String CreateFarmer(Farmer farmer) {
            MultipartFile productImage = farmer.getProductImage();
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            if(productImage != null){
                farmer.setImageUrl(link);
            }
//        ----------------------------------------------------------
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        farmer.setRegisterTime(ts);
        farmer.setAuthority("ROLE_FARMER");
        farmerService.save(farmer);
        return "redirect:./";
        }



    @GetMapping("/UpdateFarmer")
    public String viewUpdateFarmer(@RequestParam("farmerId") Integer farmerId, Model model) {
        Farmer farmer = farmerService.findByFarmerId(farmerId);
        model.addAttribute("farmer",farmer);

        return "admin/user/UpdateFarmer";

    }

    @PostMapping("/UpdateFarmer")
    public String updateUser(@RequestParam("farmerId")Integer farmerId, Farmer farmer) {

//        SerialBlob blob = null;
//        try {
//            MultipartFile productImage = farmer.getProductImage();
//            if (productImage.getSize() == 0) {
//                // 表示使用者並未挑選圖片
//                Farmer farmer1 = farmerService.findByFarmerId(farmerId);
//                farmer.setFarmerImage(farmer1.getFarmerImage());
//            }else if (productImage.getSize() > 0){
//                InputStream is = productImage.getInputStream();
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                byte[] b = new byte[8192];
//                int len = 0;
//                while ((len = is.read(b)) != -1) {
//                    baos.write(b, 0, len);
//                }
//                blob = new SerialBlob(baos.toByteArray());
//                farmer.setFileName(productImage.getOriginalFilename());
//                farmer.setFarmerImage(blob);
//            }
//            // -------------------------------------------------
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Farmer farmerDB = farmerService.findByFarmerId(farmerId);
        MultipartFile productImage = farmer.getProductImage();
        if(productImage.getSize() == 0){
            farmer.setImageUrl(farmerDB.getImageUrl());
        }else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            farmer.setImageUrl(link);
        }
        farmer.setRegisterTime(farmerDB.getRegisterTime());
        farmerService.updateFarmer(farmer);
            return "redirect:./";
    }
    @RequestMapping("DeleteFarmer")
    public String deleteUser(@RequestParam Integer farmerId) {
        farmerService.deleteByFarmerId(farmerId);
        return "redirect:./";

    }
    @PostMapping(value = "/CheckFarmer", produces = "application/json; charset = UTF-8")
    public @ResponseBody boolean CheckFarmer(@RequestParam String username) {
        Farmer farmer = farmerService.findByUsername(username);
        if (farmer == null) {
            return true;
        }
        return false;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        // java.util.Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        dateFormat.setLenient(false);
        CustomDateEditor ce = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, ce);
        // java.sql.Date
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat2.setLenient(false);
        CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true);
        binder.registerCustomEditor(java.sql.Date.class, ce2);
    }
}


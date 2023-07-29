package eeit45.group3.bakeyourlife.user.controller;

import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin/Farmer")
public class FarmerController {

  FarmerService farmerService;
  UserService userService;

  @Autowired PasswordEncoder encoder;

  @Autowired
  public FarmerController(FarmerService farmerService, UserService userService) {
    this.farmerService = farmerService;
    this.userService = userService;
  }

  @GetMapping("/")
  public String viewIndex(Model model) {
    List<Farmer> farmers = farmerService.findAll();
    model.addAttribute("farmers", farmers);
    return "admin/user/Farmer";
  }

  @GetMapping("/CreateFarmer")
  public String viewCreateFarmer(Model model) {
    model.addAttribute("farmer", new Farmer());

    return "admin/user/CreateFarmer";
  }

  @PostMapping("/CreateFarmer")
  public String CreateFarmer(Farmer farmer) {
    MultipartFile productImage = farmer.getProductImage();
    if (productImage.getSize() == 0) {
      String pic = "https://i.imgur.com/gEHJxsi.jpg";
      farmer.setImageUrl(pic);
    } else {
      String link = ImgurService.updateByMultipartFile(productImage).getLink();
      farmer.setImageUrl(link);
    }
    //        --------------------------------------------------------------
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    farmer.setRegisterTime(ts);
    farmer.setAuthority("ROLE_FARMER");
    farmer.setEnabled(true);
    farmerService.save(farmer);
    return "redirect:./";
  }

  @GetMapping("/UpdateFarmer")
  public String viewUpdateFarmer(@RequestParam("farmerId") Integer farmerId, Model model) {
    Farmer farmer = farmerService.findByFarmerId(farmerId);
    model.addAttribute("farmer", farmer);

    return "admin/user/UpdateFarmer";
  }

  @PostMapping("/UpdateFarmer")
  public String updateUser(@RequestParam("farmerId") Integer farmerId, Farmer farmer) {

    Farmer farmerDB = farmerService.findByFarmerId(farmerId);

    MultipartFile productImage = farmer.getProductImage();
    if (productImage.getSize() == 0) {
      farmer.setImageUrl(farmerDB.getImageUrl());
    } else {
      String link = ImgurService.updateByMultipartFile(productImage).getLink();
      farmer.setImageUrl(link);
    }
    // -------------------------------------------------------------------------------------------
    if (farmer.getPassword().length() == 0) {
      farmer.setPassword(farmerDB.getPassword());
    } else {
      farmer.setPassword(encoder.encode(farmer.getPassword()));
    }
    // -------------------------------------------------------------------------------------------
    farmer.setRegisterTime(farmerDB.getRegisterTime());
    farmer.setAuthority(farmerDB.getAuthority());
    farmer.setEnabled(farmerDB.isEnabled());
    farmerService.updateFarmer(farmer);
    return "redirect:./";
  }

  @RequestMapping("DeleteFarmer")
  public String deleteUser(@RequestParam Integer farmerId) {
    farmerService.deleteByFarmerId(farmerId);

    return "redirect:./";
  }

  @RequestMapping("EnableFarmer")
  public String enableFarmer(@RequestParam Integer farmerId) {
    Farmer farmer = farmerService.findByFarmerId(farmerId);
    if (farmer.isEnabled()) {
      farmer.setEnabled(false);
    } else {
      farmer.setEnabled(true);
    }
    farmerService.updateFarmer(farmer);
    return "redirect:./";
  }

  @PostMapping(value = "/CheckFarmer", produces = "application/json; charset = UTF-8")
  public @ResponseBody boolean CheckFarmer(@RequestParam String username) {
    User user = userService.findByUsername(username);
    Farmer farmer = farmerService.findByUsername(username);
    if (user == null && farmer == null) {
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

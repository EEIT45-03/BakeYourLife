package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.email.service.EmailService;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductPic;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FarmerProductController {

  FarmerProductService farmerProductService;
  FarmerService farmerService;

  EmailService emailService;

  public FarmerProductController(
      FarmerProductService farmerProductService,
      FarmerService farmerService,
      EmailService emailService) {
    this.farmerProductService = farmerProductService;
    this.farmerService = farmerService;
    this.emailService = emailService;
  }

  @PostMapping("/FarmerProducts")
  public ResponseEntity<FarmerProductBean> createFarmerProduct(
      @RequestBody FarmerProductBean farmerProductBean) {

    List<String> base64List = farmerProductBean.getBase64();
    List<FarmerProductPic> farmerProductPicList = new ArrayList<>();
    if (base64List != null && base64List.size() > 0) {
      for (String base64 : base64List) {
        FarmerProductPic farmerProductPic = new FarmerProductPic();
        if (base64 != null && base64.length() > 0) {
          farmerProductPic.setFarmerProductBean(farmerProductBean);
          farmerProductPic.setPictureLink(ImgurService.updateByBase64(base64).getLink());
          farmerProductPicList.add(farmerProductPic);
        }
      }
    } else {
      FarmerProductPic farmerProductPic = new FarmerProductPic();
      farmerProductPic.setFarmerProductBean(farmerProductBean);
      farmerProductPic.setPictureLink("https://i.imgur.com/fWtT2ZK.png");
      farmerProductPicList.add(farmerProductPic);
    }

    Date date = new Date();
    farmerProductBean.setLaunchedTime(date);
    farmerProductBean.setFarmerProductPicList(farmerProductPicList);

    farmerProductBean.setFarmer(farmerService.findByFarmerId(farmerProductBean.getFarmerId()));

    farmerProductService.insert(farmerProductBean);

    return ResponseEntity.status(HttpStatus.CREATED).body(farmerProductBean);
  }

  @PutMapping("/FarmerProducts/{id}")
  private ResponseEntity<FarmerProductBean> updateFarmerProduct(
      @PathVariable Integer id, @RequestBody FarmerProductBean farmerProductBean) {

    List<String> base64List = farmerProductBean.getBase64();
    List<FarmerProductPic> farmerProductPicList = new ArrayList<>();
    if (base64List != null && base64List.size() > 0) {
      for (String base64 : base64List) {
        FarmerProductPic farmerProductPic = new FarmerProductPic();
        if (base64 != null && base64.length() > 0) {
          farmerProductPic.setFarmerProductBean(farmerProductBean);
          System.out.println(base64.substring(0, 4));
          if (base64.substring(0, 4).equals("http")) {
            farmerProductPic.setPictureLink(base64);
          } else {
            farmerProductPic.setPictureLink(ImgurService.updateByBase64(base64).getLink());
          }
          farmerProductPicList.add(farmerProductPic);
        }
      }
    } else {
      FarmerProductPic farmerProductPic = new FarmerProductPic();
      farmerProductPic.setFarmerProductBean(farmerProductBean);
      farmerProductPic.setPictureLink("https://i.imgur.com/fWtT2ZK.png");
      farmerProductPicList.add(farmerProductPic);
    }

    farmerProductBean.setFarmerProductPicList(farmerProductPicList);
    farmerProductBean.setFarmerProductId(id);
    farmerProductBean.setFarmer(farmerService.findByFarmerId(farmerProductBean.getFarmerId()));

    FarmerProductBean farmerProductBeanDb = farmerProductService.findByFarmerProductId(id);
    if (farmerProductBeanDb != null) {
      farmerProductService.update(farmerProductBean);
    }

    return ResponseEntity.status(HttpStatus.OK).body(farmerProductBean);
  }

  @DeleteMapping("/FarmerProducts/{id}")
  private ResponseEntity<?> deleteFarmerProduct(@PathVariable Integer id) {
    farmerProductService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PutMapping("/FarmerProducts/{id}/{state}")
  private ResponseEntity<?> updateFarmerProductState(
      @PathVariable Integer id, @PathVariable Integer state) {
    FarmerProductBean farmerProductBean = null;
    if (id != null) {
      farmerProductBean = farmerProductService.findByFarmerProductId(id);
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

      default:
        break;
    }

    farmerProductService.update(farmerProductBean);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PutMapping("/FarmerProducts/sendMail/{id}/{text}")
  private ResponseEntity<?> sendViolationMail(@PathVariable Integer id, @PathVariable String text) {
    FarmerProductBean farmerProductBean = null;
    if (id != null) {
      farmerProductBean = farmerProductService.findByFarmerProductId(id);
    }
    farmerProductBean.setState(2);
    Date date = new Date();
    farmerProductBean.setViolationTime(date);
    Farmer farmer = null;
    String email = "";
    farmer = farmerProductBean.getFarmer();
    if (farmer != null) {
      email = farmer.getEmail();
    }
    String subject = "[Bake Your Life 烘焙材料網] 商品違規通知";
    String templateName = "violation";
    try {
      emailService.sendViolationMail(email, subject, farmerProductBean, text, templateName);
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
    farmerProductService.update(farmerProductBean);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}

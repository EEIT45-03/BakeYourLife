package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductPic;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class FarmerProductController {

    FarmerProductService farmerProductService;


    @Autowired
    public FarmerProductController(FarmerProductService farmerProductService) {
        this.farmerProductService = farmerProductService;
    }

    @GetMapping("/FarmerProducts")
    public ResponseEntity<List<FarmerProductBean>> viewIndex() {
        List<FarmerProductBean> farmerProductBeans = farmerProductService.findAll();
//        model.addAttribute("farmerProductBeans", farmerProductBeans);
        return ResponseEntity.status(HttpStatus.OK).body(farmerProductBeans);
    }

    @PostMapping("/FarmerProducts")
    public ResponseEntity<FarmerProductBean> createFarmerProduct(@RequestBody @Valid FarmerProductBean farmerProductBean) {

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
        }

        Date date = new Date();
        farmerProductBean.setLaunchedTime(date);
        farmerProductBean.setFarmerProductPicList(farmerProductPicList);
        farmerProductService.insert(farmerProductBean);


        return ResponseEntity.status(HttpStatus.CREATED).body(farmerProductBean);
    }

    @PutMapping("/FarmerProducts/{id}")
    private ResponseEntity<FarmerProductBean> updateFarmerProduct(@PathVariable Integer id,
                                                                  @RequestBody @Valid FarmerProductBean farmerProductBean) {

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
        }

        farmerProductBean.setFarmerProductPicList(farmerProductPicList);
        farmerProductBean.setFarmerProductId(id);


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
    private ResponseEntity<?> updateFarmerProductState(@PathVariable Integer id, @PathVariable Integer state) {
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
            case 2:
                farmerProductBean.setViolationTime(date);
                break;
            default:
                break;
        }

        farmerProductService.update(farmerProductBean);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

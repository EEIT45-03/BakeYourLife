package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QueryController {

    FarmerProductService farmerProductService;

    public QueryController(FarmerProductService farmerProductService) {
        this.farmerProductService = farmerProductService;
    }

    @GetMapping("/FarmerProducts/{type}")
    public ResponseEntity<List<FarmerProductBean>> findByType(@PathVariable String type) {
        List<FarmerProductBean> farmerProductBeanList = null;
        if ("全部".equals(type)) {
            farmerProductBeanList = farmerProductService.findByStateOrderByLaunchedTimeDesc(0);
        } else {
            farmerProductBeanList = farmerProductService.findByTypeAndStateOrderByLaunchedTimeDesc(type);
        }
        return ResponseEntity.status(HttpStatus.OK).body(farmerProductBeanList);
    }

    @GetMapping("/FarmerProducts/{type}/{id}")
    public ResponseEntity<List<FarmerProductBean>> findByTypeAndId(@PathVariable String type, @PathVariable Integer id) {
        List<FarmerProductBean> farmerProductBeanList = null;
        if ("全部".equals(type)) {
            farmerProductBeanList = farmerProductService.findByStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(id);
        } else {
            farmerProductBeanList = farmerProductService.findByTypeAndStateAndFarmerFarmerIdOrderByLaunchedTimeDesc(type, id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(farmerProductBeanList);
    }

}

package eeit45.group3.bakeyourlife.farmerproduct.controller;


import eeit45.group3.bakeyourlife.farmerproduct.dao.FarmerProductRepository;
import eeit45.group3.bakeyourlife.farmerproduct.utils.FarmerProductChart;
import eeit45.group3.bakeyourlife.farmerproduct.utils.TypeAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FarmerChartController {

    private final FarmerProductRepository farmerProductRepository;

    @Autowired
    public FarmerChartController(FarmerProductRepository farmerProductRepository) {
        this.farmerProductRepository = farmerProductRepository;
    }

    @GetMapping("/FarmerProductSupplier/typeAmount")
    public FarmerProductChart findTypeAmount() {
        FarmerProductChart farmerProductChart = new FarmerProductChart();
        List<TypeAmount> typeAmountList = farmerProductRepository.findTypeAmount();
        for (TypeAmount data : typeAmountList) {
            farmerProductChart.addData(data);
        }
        return farmerProductChart;
    }

    @GetMapping("/FarmerProductSupplier/typeAmountByFarmerId/{id}")
    public FarmerProductChart findTypeAmountByFarmerId(@PathVariable Integer id) {
        FarmerProductChart farmerProductChart = new FarmerProductChart();
        List<TypeAmount> typeAmountList = farmerProductRepository.findTypeAmountByUserId(id);
        for (TypeAmount data : typeAmountList) {
            farmerProductChart.addData(data);
        }
        return farmerProductChart;
    }
}

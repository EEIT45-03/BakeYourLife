package eeit45.group3.bakeyourlife.farmerproduct.controller;

import eeit45.group3.bakeyourlife.farmerproduct.dao.FarmerProductRepository;
import eeit45.group3.bakeyourlife.farmerproduct.utils.FarmerProductChart;
import eeit45.group3.bakeyourlife.farmerproduct.utils.QueryChart;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmerChartController {

  private final FarmerProductRepository farmerProductRepository;

  @Autowired
  public FarmerChartController(FarmerProductRepository farmerProductRepository) {
    this.farmerProductRepository = farmerProductRepository;
  }

  @GetMapping("/FarmerProductSupplier/monthSaleAmountByFarmerId/{id}")
  public FarmerProductChart monthSaleAmountByFarmerId(@PathVariable Integer id) {
    FarmerProductChart farmerProductChart = new FarmerProductChart();
    List<QueryChart> queryChartList = farmerProductRepository.monthSaleAmountByFarmerId(id);
    for (QueryChart data : queryChartList) {
      farmerProductChart.addData(data);
    }
    return farmerProductChart;
  }

  @GetMapping("/FarmerProductSupplier/farmerSaleAmount")
  public FarmerProductChart farmerSaleAmount() {
    FarmerProductChart farmerProductChart = new FarmerProductChart();
    List<QueryChart> queryChartList = farmerProductRepository.farmerSaleAmount();
    for (QueryChart data : queryChartList) {
      farmerProductChart.addData(data);
    }
    return farmerProductChart;
  }

  @GetMapping("/FarmerProductSupplier/typeAmount")
  public FarmerProductChart findTypeAmount() {
    FarmerProductChart farmerProductChart = new FarmerProductChart();
    List<QueryChart> queryChartList = farmerProductRepository.findTypeAmount();
    for (QueryChart data : queryChartList) {
      farmerProductChart.addData(data);
    }
    return farmerProductChart;
  }

  @GetMapping("/FarmerProductSupplier/typeAmountByFarmerId/{id}")
  public FarmerProductChart findTypeAmountByFarmerId(@PathVariable Integer id) {
    FarmerProductChart farmerProductChart = new FarmerProductChart();
    List<QueryChart> queryChartList = farmerProductRepository.findTypeAmountByFarmerId(id);
    for (QueryChart data : queryChartList) {
      farmerProductChart.addData(data);
    }
    return farmerProductChart;
  }
}

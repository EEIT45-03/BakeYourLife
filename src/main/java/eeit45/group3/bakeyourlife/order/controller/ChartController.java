package eeit45.group3.bakeyourlife.order.controller;

import eeit45.group3.bakeyourlife.order.dao.OrderRepository;
import eeit45.group3.bakeyourlife.order.utils.Chart;
import eeit45.group3.bakeyourlife.order.utils.ProductSaleAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ChartController {


    private final OrderRepository orderRepository;

    @Autowired
    public ChartController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/admin/order/productSaleAmount")
    public Chart findProductSaleAmount() {
        Chart chart = new Chart();
        List<ProductSaleAmount> productSaleAmountList = orderRepository.findProductSaleAmount();
        for (ProductSaleAmount productSaleAmount : productSaleAmountList) {
            chart.addData(productSaleAmount);
        }
        System.out.println(chart.getLabels());
        System.out.println(chart.getData());
        return chart;
    }

    @GetMapping("/admin/order/monthSaleAmount")
    public Chart findMonthSaleAmount() {
        Chart chart = new Chart();
        List<ProductSaleAmount> productSaleAmountList = orderRepository.findMonthSaleAmount();
        for (ProductSaleAmount productSaleAmount : productSaleAmountList) {
           chart.addData(productSaleAmount);
        }
        System.out.println(chart.getLabels());
        System.out.println(chart.getData());
        return chart;
    }
}

package eeit45.group3.bakeyourlife.good.controller;

import eeit45.group3.bakeyourlife.good.dao.GoodsRepository;
import eeit45.group3.bakeyourlife.good.utils.GoodsChart;
import eeit45.group3.bakeyourlife.good.utils.GoodsCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodsChartController {


    private final GoodsRepository goodsRepository;

    @Autowired
    public GoodsChartController(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @GetMapping("/GoodsTypeCount")
    public GoodsChart findGoodsTypeAmount() {
        GoodsChart goodsChart = new GoodsChart();
        List<GoodsCount> goodsCountList = goodsRepository.findGoodsTypeAmount();
        for (GoodsCount data : goodsCountList) {
            goodsChart.addData(data);
        }
        return goodsChart;
    }

    @GetMapping("/GoodsOriginCount")
    public GoodsChart findGoodsOriginAmount() {
        GoodsChart goodsChart = new GoodsChart();
        List<GoodsCount> goodsCountList = goodsRepository.findGoodsOriginAmount();
        for (GoodsCount data : goodsCountList) {
            goodsChart.addData(data);
        }
        return goodsChart;
    }

    @GetMapping("/GoodsNameCount")
    public GoodsChart findGoodsNameCount() {
        GoodsChart goodsChart = new GoodsChart();
        List<GoodsCount> goodsCountList = goodsRepository.findGoodsNameCount();
        for (GoodsCount data : goodsCountList) {
            goodsChart.addData(data);
        }
        return goodsChart;
    }

}


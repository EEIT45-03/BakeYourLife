package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.dao.ArticleRepository;
import eeit45.group3.bakeyourlife.article.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import eeit45.group3.bakeyourlife.article.utils.ArticleChart;
import eeit45.group3.bakeyourlife.article.utils.ArticleCount;
import java.util.List;

@RestController
public class ArticleChartController{

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleChartController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @GetMapping("/admin/article/typeCount")
    public ArticleChart selectTypeCount(){
        ArticleChart chart = new ArticleChart();
        List<ArticleCount> typeCountList = articleRepository.selectTypeCount();
        for (ArticleCount typeCount : typeCountList) {
            chart.addData(typeCount);
        }
//
        return chart;
    }
    @GetMapping("/admin/article/counterByType")
    public ArticleChart selectCounterByType(){
        ArticleChart chart = new ArticleChart();
        List<ArticleCount> typeCountList = articleRepository.selectCounterByType();
        for (ArticleCount typeCount : typeCountList) {
            chart.addData(typeCount);
        }
//
        return chart;
    }
}


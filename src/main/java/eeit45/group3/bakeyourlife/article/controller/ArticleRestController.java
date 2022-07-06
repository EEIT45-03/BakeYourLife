package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.service.ArticleService;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.tomcat.util.codec.binary.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;

    /*
    GET /Articles findAll
    GET /Articles/{postId} 查詢單筆
    POST /Articles 新增一筆
    PUT /Articles/{postId} 更新
    DELETE /Articles/{postId} 刪除

     */

    @GetMapping(value = "/ArticlesTitle/{title}", produces = "application/json")
    public ResponseEntity<List<Article>> findByTitle(@PathVariable String title){
        List<Article> article = articleService.findByTitle(title);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

    @GetMapping(value = "/ArticlesType/{type}", produces = "application/json")
    public ResponseEntity<List<Article>> findAllByTypeContaining(@PathVariable String type){
        List<Article> article = articleService.findAllByTypeContaining(type);

//        String encoded64 = new String(article.getBase64());
//        article.setBase64(encoded64);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }
}

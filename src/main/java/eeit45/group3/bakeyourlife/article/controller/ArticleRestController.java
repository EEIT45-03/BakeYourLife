package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.model.Message;
import eeit45.group3.bakeyourlife.article.service.ArticleService;
import eeit45.group3.bakeyourlife.article.service.MessageService;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private MessageService messageService;
    /*
    GET /Articles findAll
    GET /Articles/{postId} 查詢單筆
    POST /Articles 新增一筆
    PUT /Articles/{postId} 更新
    DELETE /Articles/{postId} 刪除

     */

    @GetMapping(value = "/ArticlesTitle/{title}", produces = "application/json")
    public ResponseEntity<List<Article>> findByTitle(@PathVariable String title) {
        List<Article> article = articleService.findByTitle(title);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

    @GetMapping(value = "/ArticlesType/{type}", produces = "application/json")
    public ResponseEntity<List<Article>> findAllByTypeContaining(@PathVariable String type) {
        List<Article> article = articleService.findAllByTypeContaining(type);

//        String encoded64 = new String(article.getBase64());
//        article.setBase64(encoded64);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }

    @PostMapping(value = "/MessageAdd")
    public ResponseEntity<Message> insert(
            @RequestParam String userName,
            @RequestParam String message,
            //@RequestParam Date datetime,
            @RequestParam ("messageImage")  MultipartFile messageImage) {

        Message m = new Message();
        m.setMessage(message);
        m.setUserName(userName);
//        Date date = new Date();
//        m.setDateTime(date);
//        messageInfo.setMessageImage(messageImage);
//        try{
//            byte[] image = Base64.encodeBase64(messageInfo.getMessageImage().getBytes());
//            String result = new String(image);
//            System.out.println(result);
//            messageInfo.setImage(image);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
        m.setImageUrl(ImgurService.updateByMultipartFile(messageImage).getLink());
        //m.setMessageImage(messageImage);
        System.out.println("圖片網址:  " + ImgurService.updateByMultipartFile(messageImage).getLink());
        Message createMessage = messageService.insert(m);
        return ResponseEntity.status(HttpStatus.CREATED).body(createMessage);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        // java.util.Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        dateFormat.setLenient(false);
        CustomDateEditor ce = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, ce);
    }
}


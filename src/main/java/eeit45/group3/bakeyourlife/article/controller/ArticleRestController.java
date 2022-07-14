package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.model.Message;
import eeit45.group3.bakeyourlife.article.service.ArticleService;
import eeit45.group3.bakeyourlife.article.service.MessageService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
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
    @PostMapping(value = "/ArticleAdd")
    public ResponseEntity<Article> insert(@Valid
            @RequestParam String title,
            Principal principal,
            @RequestParam String type,
            @RequestParam java.sql.Date date,
            @RequestParam String content,
            @RequestParam ("articleImage")  MultipartFile articleImage) {

//        if (bindingResult.hasErrors()) {
//            //model = new ModelAndView("customerCreate");
//            //return model;
//            return ResponseEntity.ok("valid");
//        }

        Article m = new Article();
        m.setTitle(title);
        //User user = userService.findByUsername(principal.getName());
        m.setType(type);
        m.setDate(date);
        m.setContent(content);
        m.setCounter(0);
        m.setImageUrl(ImgurService.updateByMultipartFile(articleImage).getLink());
        //m.setMessageImage(messageImage);
        System.out.println("圖片網址:  " + ImgurService.updateByMultipartFile(articleImage).getLink());
        Article createArticle = articleService.insert(m);
        return ResponseEntity.status(HttpStatus.CREATED).body(createArticle);
    }

    @PutMapping(value = "/ArticleUpdate/{postid}")
    public ResponseEntity<Article> update(
            @RequestParam("postid")Integer postid,
            @RequestParam String title,
            Principal principal,
            @RequestParam String type,
            @RequestParam java.sql.Date date,
            @RequestParam String content,
            @RequestParam ("articleImage")  MultipartFile articleImage) {

        Article update = new Article();
        update.setPostid(postid);
        update.setTitle(title);
     //   User user = userService.findByUsername(principal.getName());
        update.setType(type);
        update.setDate(date);
        update.setContent(content);
        update.setCounter(0);
        update.setImageUrl(ImgurService.updateByMultipartFile(articleImage).getLink());
        //m.setMessageImage(messageImage);
        System.out.println("圖片網址:  " + ImgurService.updateByMultipartFile(articleImage).getLink());
        Article UpdateArticle = articleService.update(update);
        return ResponseEntity.status(HttpStatus.OK).body(UpdateArticle);
    }

    @DeleteMapping("/ArticleDelete/{postid}")
    public ResponseEntity<Article> delete(@PathVariable Integer postid) {
        articleService.delete(postid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping(value = "/MessageAdd")
    public ResponseEntity<Message> insert(
            @RequestParam String userName,
            Principal principal,
            @RequestParam String message,
            @RequestParam Integer postid,
            //@RequestParam Date datetime,
            @RequestParam ("messageImage")  MultipartFile messageImage) {

        Message m = new Message();
        m.setMessage(message);
        User user = userService.findByUsername(principal.getName());
        m.setUserName(userName);
        Date date = new Date();
        m.setDateTime(date);
        m.setImageUrl(ImgurService.updateByMultipartFile(messageImage).getLink());
        Article article = articleService.selectOne(postid).orElse(null);;
        m.setArticle(article);
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

        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat2.setLenient(false);
        CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true);
        binder.registerCustomEditor(java.sql.Date.class, ce2);
    }
}


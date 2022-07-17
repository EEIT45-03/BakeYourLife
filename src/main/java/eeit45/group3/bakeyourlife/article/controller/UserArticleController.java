package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.service.ArticleService;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/UserArticle")
public class UserArticleController {

    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;


    @GetMapping(path = "")
    private String processFindOne(@RequestParam(required = false) Integer userid,  Model m) {

        List<Article> listAll = articleService.findByUserId(userid);
        m.addAttribute("articles", listAll);


        return "article/UserArticle";

    }

    @GetMapping(path = "/Update")
    public String processQuery(@RequestParam(required = false) Integer postid,
                               Model model) throws IOException {
        Article article = articleService.selectOne(postid).orElse(null);
        if (article == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        article.setCounter(article.getCounter() + 1);
        articleService.update(article);

        model.addAttribute("article", article);
        return "article/UserArticle";

    }

    @GetMapping(path = "/UserArticleDetail")
    public String processArticleQuery(@RequestParam(required = false) Integer postid,
                               Model model) throws IOException {
        Article article = articleService.selectOne(postid).orElse(null);
        if (article == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        //Message message = messageService.messageOne(messageId).orElse(null);
//		article = listone.get(0);
        article.setCounter(article.getCounter() + 1);
        articleService.update(article);

        // List<Message> messageAll = messageService.findMessageAll();
        //model.addAttribute("messages", messageAll);
        model.addAttribute("article", article);
        return "article/UserArticleDetail";

    }
}

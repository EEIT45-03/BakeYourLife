package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.model.Favorite;
import eeit45.group3.bakeyourlife.article.model.Message;
import eeit45.group3.bakeyourlife.article.service.ArticleService;
import eeit45.group3.bakeyourlife.article.service.FavoriteService;
import eeit45.group3.bakeyourlife.article.service.MessageService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/FrontArticle")
public class FrontArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private MessageService messageService;
    @Resource
    private FavoriteService favoriteService;
    @Resource
    private UserService userService;




    @GetMapping(path = "")
    private String processFindOne(@RequestParam(required = false) Integer postid, @RequestParam(required = false) Date date,
                                  @RequestParam(required = false) String state, Model m,
                                  Authentication authentication) {
        User currentUser=null;
        if(authentication!=null){
            currentUser = userService.getCurrentUser(authentication);
        }
        
        
        List<Article> listAll = null;
        List<Favorite> favorites;
        Map<Integer,Favorite> map = new HashMap<>();
        if(currentUser!=null){
            listAll = articleService.findAll();
            favorites = favoriteService.findAllByUser(currentUser);
            favorites.forEach(favorite -> {
                map.put(favorite.getArticle().getPostid(),favorite);
            });
            listAll.forEach(article -> {
                article.setState(map.get(article.getPostid()) != null);
            });
        }else {
            listAll = articleService.findAll();
        }
        m.addAttribute("articles", listAll);
        List<Article> article = articleService.findLatestDate(date);
        m.addAttribute("articleDate", article);


        return "article/FrontArticle";

    }

    @GetMapping(path = "/ArticleDetail")
    public String processQuery(@RequestParam(required = false) Integer postid,
                               @RequestParam(required = false) Integer counter,
                               @RequestParam(required = false) Date date,
                               Model model) throws IOException {
        Article article = articleService.selectOne(postid).orElse(null);
        if (article == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

//		article = listone.get(0);
        article.setCounter(article.getCounter() + 1);
        articleService.update(article);


        model.addAttribute("article", article);
        List<Article> articleType = articleService.findTopCounter(counter);
        model.addAttribute("selectType", articleType);
        List<Article> Date = articleService.findLatestDate(date);
        model.addAttribute("articleDate", Date);
        return "article/ArticleDetail";

    }
    @PostMapping(path = "/CreateArticle")
    public String processInsert(@Valid @ModelAttribute("articles") Article articleInfo,
                                BindingResult bindingResult,
                                @RequestParam(value = "articleImage", required = false) MultipartFile file,
                                RedirectAttributes redirectAttributes
    ) {


        if (bindingResult.hasErrors()) {
            //model = new ModelAndView("customerCreate");
            //return model;
            return "admin/article/CreateArticle";
        }



        articleInfo.setCounter(0);
        articleInfo.setArticleImage(file);
        try{
//			byte[] image = Base64.encodeBase64(articleInfo.getArticleImage().getBytes());
//			String result = new String(image);
//			System.out.println(result);
//			articleInfo.setPicture(image);
            articleInfo.setImageUrl(ImgurService.updateByMultipartFile(file).getLink());
        } catch(Exception e) {
            e.printStackTrace();
        }

        articleService.insert(articleInfo);
        return "redirect:./";
    }


    @GetMapping (path = "/SelectArticle")
    private String viewSelect(@RequestParam(required = false) String title,@RequestParam(required = false) Date date,
                              Model m) {

        List<Article> article = articleService.findByTitle(title);
        m.addAttribute("articles", article);
        List<Article> articleDate = articleService.findLatestDate(date);
        m.addAttribute("articleDate", articleDate);

        return "article/SelectArticle";

    }


//    @PostMapping (path = "/SelectArticle")
//    private String processSelect(@Valid @ModelAttribute("SelectArticle") Article articles,@RequestParam(required = false) String title,@RequestParam(required = false) Date date,
//                                 BindingResult bindingResult,Model m) {
//
//            if (bindingResult.hasErrors()) {
//
//			return "article/SelectArticle";
//		}
//
//        List<Article> article = articleService.findByTitle(title);
//        m.addAttribute("articles", article);
//        List<Article> articleDate = articleService.findLatestDate(date);
//        m.addAttribute("articleDate", articleDate);
//
//        return "article/SelectArticle";
//
//    }


//    @GetMapping(path = "/index")
//    public String processIndex(@RequestParam(required = false) Integer counter,
//                               Model model) throws IOException {
//
//
//        List<Article> articleType = articleService.findTopCounter(counter);
//        model.addAttribute("selectType", articleType);
//
//        return "index";
//
//    }


}
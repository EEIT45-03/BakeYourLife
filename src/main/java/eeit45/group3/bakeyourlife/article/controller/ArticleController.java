package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.service.ArticleService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/admin/Article")
public class ArticleController {

  @Autowired private ArticleService articleservice;
  // private MessageService messageService;
  @Autowired private UserService userService;

  @GetMapping(path = "/")
  private String processFindOne(
      @RequestParam(required = false) Integer postid, Model m, Authentication authentication) {

    User currentUser = userService.getCurrentUser(authentication);
    List<Article> listAll = articleservice.findAll();
    m.addAttribute("articles", listAll);
    //		List<Message> messageAll = messageService.findMessageAll();
    //		m.addAttribute("messages", messageAll);
    return "admin/article/Article";
  }

  @GetMapping(path = "/ArticleChart")
  private String processSelectChart() {

    return "admin/article/ArticleChart";
  }
  // 發文id}
  // AAA/{id}/CCC
  @GetMapping(path = "/QueryArticle")
  public String processQuery(@RequestParam(required = false) Integer postid, Model model)
      throws IOException {
    Article article = articleservice.selectOne(postid).orElse(null);
    // Message message = messageService.messageOne(messageId).orElse(null);
    //		article = listone.get(0);
    article.setCounter(article.getCounter() + 1);
    articleservice.update(article);

    //		String encoded64 = new String(article.getPicture());
    //		article.setBase64(encoded64);
    model.addAttribute("article", article);
    // model.addAttribute("message", message);
    return "admin/article/ShowArticle";
  }

  //	  String base64 = getBase64(listone.get(0).getPicture());
  //	  model.addAttribute("contentImage",base64);
  //		public String getBase64(byte[] picture)throws UnsupportedEncodingException {
  //			byte[] encodeBase64 = Base64.encodeBase64(picture);
  //			String base64Encoded = new String(encodeBase64, "UTF-8");
  //			return base64Encoded;
  //		}

  @GetMapping("/CreateArticle")
  public String viewInsert(Model model) {
    // 表單綁定用

    model.addAttribute("article", new Article());
    return "admin/article/CreateArticle";
  }

  @PostMapping(path = "/CreateArticle")
  public String processInsert(
      @Valid @ModelAttribute("article") Article articleInfo,
      BindingResult bindingResult,
      Authentication authentication,
      @RequestParam(value = "articleImage", required = false) MultipartFile file,
      RedirectAttributes redirectAttributes) {

    if (bindingResult.hasErrors()) {
      // model = new ModelAndView("customerCreate");
      // return model;
      return "admin/article/CreateArticle";
    }

    User user = userService.getCurrentUser(authentication);

    articleInfo.setCounter(0);
    articleInfo.setArticleImage(file);
    try {
      //			byte[] image = Base64.encodeBase64(articleInfo.getArticleImage().getBytes());
      //			String result = new String(image);
      //			System.out.println(result);
      //			articleInfo.setPicture(image);
      articleInfo.setImageUrl(ImgurService.updateByMultipartFile(file).getLink());
      articleInfo.setUser(user);
    } catch (Exception e) {
      e.printStackTrace();
    }

    articleservice.insert(articleInfo);
    return "redirect:./";
  }

  @GetMapping("/UpdateArticle")
  public String viewUpdate(@RequestParam(required = false) Integer postid, Model model) {
    // 表單綁定用

    Article listone = articleservice.selectOne(postid).orElse(null);

    //		String encoded64 = new String(listone.getPicture());
    //		listone.setBase64(encoded64);
    model.addAttribute("article", listone);
    return "admin/article/UpdateArticle";
  }

  @PostMapping("/UpdateArticle")
  public String processUpdate(
      @ModelAttribute("article") Article articleInfo,
      Authentication authentication,
      @RequestParam(value = "articleImage", required = false) MultipartFile file,
      Model model)
      throws IOException {

    User user = userService.getCurrentUser(authentication);

    //		articleInfo.setArticleImage(file);
    try {
      //			byte[] image = Base64.encodeBase64(articleInfo.getArticleImage().getBytes());
      //			String result = new String(image);
      //			System.out.println(result);
      //			articleInfo.setPicture(image);
      articleInfo.setUser(user);
      articleInfo.setImageUrl(ImgurService.updateByMultipartFile(file).getLink());
    } catch (Exception e) {
      e.printStackTrace();
    }

    // Article upArticle = new Article(postid,title,type,date,content,
    // articleInfo.getPicture(),file,base64,0);
    articleInfo.setCounter(0);
    articleservice.update(articleInfo);
    // Integer counter = 0;

    return "redirect:./";
  }

  @PostMapping("/DeleteArticle")
  public String processDelete(@RequestParam("postid") Integer postid) {
    articleservice.delete(postid);
    return "redirect:./";
    // ResponseEntity.status(HttpStatus.NO_CONTENT).build();

  }

  @InitBinder
  public void initBinder(WebDataBinder binder, WebRequest request) {
    // java.sql.Date
    DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat2.setLenient(false);
    CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true);
    binder.registerCustomEditor(java.sql.Date.class, ce2);
  }
}

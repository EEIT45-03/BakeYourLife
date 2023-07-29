package eeit45.group3.bakeyourlife.article.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.model.Favorite;
import eeit45.group3.bakeyourlife.article.service.ArticleService;
import eeit45.group3.bakeyourlife.article.service.FavoriteService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping(path = "User/UserArticle")
public class UserArticleController {

  @Autowired private UserService userService;
  @Autowired private ArticleService articleService;

  @Autowired private FavoriteService favoriteService;

  @GetMapping(path = "")
  private String processFindOne(
      @RequestParam(required = false) Integer userid, Model m, Authentication authentication) {

    User user = userService.getCurrentUser(authentication);
    List<Article> listAll = articleService.findAllByUser(user);

    m.addAttribute("articles", listAll);

    return "article/UserArticle";
  }

  @GetMapping(path = "/farvorite")
  private String processFavorite(
      @RequestParam(required = false) Integer postid, Model m, Authentication authentication) {

    User user = userService.getCurrentUser(authentication);
    List<Favorite> favorites = favoriteService.findAllByUser(user);

    m.addAttribute("favorites", favorites);
    return "article/FavoriteArticle";
  }

  @GetMapping(path = "/Update")
  public String processQuery(@PathVariable Integer postid, Model model) throws IOException {
    Article article = articleService.selectOne(postid).orElse(null);
    if (article == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    article.setCounter(article.getCounter() + 1);
    articleService.update(article);

    model.addAttribute("article", article);
    return "article/UserArticle";
  }

  @GetMapping(path = "/UserArticleDetail")
  public String processArticleQuery(@RequestParam(required = false) Integer postid, Model model)
      throws IOException {
    Article article = articleService.selectOne(postid).orElse(null);
    if (article == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    // Message message = messageService.messageOne(messageId).orElse(null);
    //		article = listone.get(0);
    article.setCounter(article.getCounter() + 1);
    articleService.update(article);

    // List<Message> messageAll = messageService.findMessageAll();
    // model.addAttribute("messages", messageAll);
    model.addAttribute("article", article);
    return "article/UserArticleDetail";
  }
}

package eeit45.group3.bakeyourlife.article.controller;


import eeit45.group3.bakeyourlife.article.model.Favorite;
import eeit45.group3.bakeyourlife.article.service.ArticleService;

import eeit45.group3.bakeyourlife.article.service.FavoriteService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.article.model.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/farvorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;


    @Autowired
    ArticleService articleService;

    @PostMapping("/addFavorite/{postid}")
    public ResponseEntity<Favorite> addToFavorite(
            Authentication authentication,@PathVariable("postid") Integer postid) {

        // authenticationService.authenticate(token);

        User user = userService.getCurrentUser(authentication);
        Article SetArticle = articleService.selectOne(postid).orElse(null);
        Favorite favorite = new Favorite();
        //favorite.setId();
        favorite.setArticle(SetArticle);
        favorite.setUser(user);
        Date date = new Date();
        favorite.setCreatedDate(date);

        Favorite favoriteList = favoriteService.createFavorite(favorite);


        return ResponseEntity.status(HttpStatus.CREATED).body(favoriteList);
    }




    @GetMapping("")
    public ResponseEntity<List<Favorite>> getFavorite(Authentication authentication) {

        // authenticationService.authenticate(token);

        User user = userService.getCurrentUser(authentication);

        List<Favorite> favorites = favoriteService.findAllByUser(user);
        return  ResponseEntity.status(HttpStatus.OK).body(favorites);
    }

    @DeleteMapping("/farvoriteDelete/{id}")
    public ResponseEntity<Article> delete(@PathVariable Integer id) {
        favoriteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}




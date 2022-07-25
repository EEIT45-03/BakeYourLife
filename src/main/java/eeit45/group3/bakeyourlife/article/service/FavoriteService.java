package eeit45.group3.bakeyourlife.article.service;

import eeit45.group3.bakeyourlife.article.model.Favorite;
import eeit45.group3.bakeyourlife.user.model.User;


import java.util.List;


public interface FavoriteService {

    Favorite createFavorite(Favorite favorite);

    List<Favorite> findAllByUser(User user);

    void deleteById(Integer id);

    List<Favorite> findFavoriteByState(String state);
}

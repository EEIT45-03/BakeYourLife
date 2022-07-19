package eeit45.group3.bakeyourlife.article.service;

import eeit45.group3.bakeyourlife.article.dao.FavoriteRepository;
import eeit45.group3.bakeyourlife.article.model.Favorite;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FavoriteServiceImpl implements FavoriteService {
     @Autowired
    FavoriteRepository favoriteRepository;

    public Favorite createFavorite(Favorite favorite) {
        return  favoriteRepository.save(favorite);
    }

    public List<Favorite> findAllByUser(User user){
        return favoriteRepository.findAllByUser(user);
    }
}
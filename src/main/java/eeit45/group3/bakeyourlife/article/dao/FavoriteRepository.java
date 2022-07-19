package eeit45.group3.bakeyourlife.article.dao;

import eeit45.group3.bakeyourlife.article.model.Favorite;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Integer>{

List<Favorite> findAllByUser(User user);


}

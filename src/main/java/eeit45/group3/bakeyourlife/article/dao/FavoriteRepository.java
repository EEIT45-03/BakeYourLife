package eeit45.group3.bakeyourlife.article.dao;

import eeit45.group3.bakeyourlife.article.model.Favorite;
import eeit45.group3.bakeyourlife.user.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

  List<Favorite> findAllByUser(User user);

  @Query(nativeQuery = true, value = "SELECT * FROM favorite WHERE state LIKE '已收藏'")
  List<Favorite> findFavoriteByState(String state);

  @Query(
      nativeQuery = true,
      value =
          "SELECT * FROM favorite WHERE use_id = :user_id AND article_id = :post_id") // ?1 or $1
  Boolean findFavoriteByUserAndPostID(
      @Param("user_id") User user_id, @Param("post_id") Integer post_id);
}

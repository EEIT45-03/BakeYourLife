package eeit45.group3.bakeyourlife.article.dao;


import eeit45.group3.bakeyourlife.article.model.AuthenticationToken;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
     AuthenticationToken findByUser(User user);
     AuthenticationToken findByToken(String token);

}

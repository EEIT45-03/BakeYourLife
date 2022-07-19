package eeit45.group3.bakeyourlife.article.dao;


import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByArticle(Article postid);

//    Optional<Message> findById(Message messageId);
}

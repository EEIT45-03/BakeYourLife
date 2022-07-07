package eeit45.group3.bakeyourlife.article.dao;


import eeit45.group3.bakeyourlife.article.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}

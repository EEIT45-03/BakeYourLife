package eeit45.group3.bakeyourlife.article.service;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.model.Message;
import java.util.List;
import java.util.Optional;

public interface MessageService {
  List<Message> findMessageAll();

  List<Message> findMessageByPostid(Article postid);

  Optional<Message> messageOne(Integer messageId);

  Message insert(Message newArticle);

  Message update(Message upArticle);

  void delete(Integer messageId);
}

package eeit45.group3.bakeyourlife.article.service;

import eeit45.group3.bakeyourlife.article.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<Message> findMessageAll();

    Optional<Message> MessageOne(Integer messageId);

    Message insert(Message newArticle);

    Message update(Message upArticle);

    void delete(Integer messageId);
}

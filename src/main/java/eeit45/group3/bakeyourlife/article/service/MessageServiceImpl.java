package eeit45.group3.bakeyourlife.article.service;

import eeit45.group3.bakeyourlife.article.dao.MessageRepository;
import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.article.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

  private MessageRepository messageRepository;

  @Autowired
  public MessageServiceImpl(MessageRepository messageRepository) {

    this.messageRepository = messageRepository;
  }

  @Override
  public List<Message> findMessageAll() {
    return messageRepository.findAll();
  }

  @Override
  public List<Message> findMessageByPostid(Article postid) {
    return messageRepository.findAllByArticle(postid);
  }

  @Override
  public Optional<Message> messageOne(Integer messageId) {
    return messageRepository.findById(messageId);
  }

  @Override
  public Message insert(Message newArticle) {

    return messageRepository.save(newArticle);
  }

  @Override
  public Message update(Message upArticle) {
    return messageRepository.save(upArticle);
  }

  @Override
  public void delete(Integer messageId) {
    messageRepository.deleteById(messageId);
  }
}
;

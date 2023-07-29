package eeit45.group3.bakeyourlife;

import eeit45.group3.bakeyourlife.email.service.EmailService;
import javax.mail.MessagingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BakeYourLifeApplicationTests {

  @Autowired private EmailService emailService;

  @Test
  void contextLoads() throws MessagingException {
    // 測試時輸入自己的email
    emailService.sendMailByThymeleaf("xxxxxxx@gmail.com", "test", "test", "test", "welcome");
  }
}

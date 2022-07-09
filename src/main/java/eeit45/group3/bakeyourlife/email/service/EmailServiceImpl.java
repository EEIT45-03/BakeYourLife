package eeit45.group3.bakeyourlife.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("EmailService")
public class EmailServiceImpl implements EmailService {


    @Autowired
    private JavaMailSender mailSender;


    public void sendSimpleMessage(String to,
            String subject,
            String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bakeyourlifemail@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

}

package eeit45.group3.bakeyourlife.email.service;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Register;

import javax.mail.MessagingException;

public interface EmailService {

    void sendSimpleMessage(String to,
                           String subject,
                           String text);

    void sendMailByThymeleaf(
            String to,//收件者
            String subject,//主旨
            String text, //內容
            String templateName//模板名稱
    ) throws MessagingException;

    void sendRegisterMail(String email, //收件者
                          String subject, //主旨
                          Register register,//內容
                          String templateName//模板名稱
    ) throws MessagingException;


}

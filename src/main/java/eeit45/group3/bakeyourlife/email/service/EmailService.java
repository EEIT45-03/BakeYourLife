package eeit45.group3.bakeyourlife.email.service;

public interface EmailService {

    void sendSimpleMessage(String to,
                           String subject,
                           String text);
}

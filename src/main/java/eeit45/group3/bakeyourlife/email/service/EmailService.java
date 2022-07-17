package eeit45.group3.bakeyourlife.email.service;

import eeit45.group3.bakeyourlife.order.constant.OrderStatusChangeEvent;
import eeit45.group3.bakeyourlife.order.model.Order;

import javax.mail.MessagingException;

public interface EmailService {
    void sendMailByThymeleaf(
            String to,//收件者
            String subject,//主旨
            String text, //內容
            String head,
            String templateName//模板名稱
    ) throws MessagingException;

    void sendOrderMail(
            Order order,
            OrderStatusChangeEvent orderStatusChangeEvent
    ) throws MessagingException;


}

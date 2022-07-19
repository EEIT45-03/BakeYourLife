package eeit45.group3.bakeyourlife.email.service;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Register;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
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


    void sendRegisterMail(String email, //收件者
                          String subject, //主旨
                          Register register,//內容
                          String templateName//模板名稱
    ) throws MessagingException;

    public void sendViolationMail(
            String to,//收件者
            String subject,//主旨
            FarmerProductBean farmerProductBean,//內容
            String text,
            String templateName//模板名稱
    ) throws MessagingException;
}

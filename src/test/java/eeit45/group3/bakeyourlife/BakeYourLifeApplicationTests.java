package eeit45.group3.bakeyourlife;

import eeit45.group3.bakeyourlife.email.service.EmailService;
import eeit45.group3.bakeyourlife.order.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class BakeYourLifeApplicationTests {

    @Autowired
    private EmailService emailService;

    @Test
    void contextLoads() throws MessagingException {
        //測試時輸入自己的email
        Order order = new Order();
        order.setOrderNo("111111111111111");
        order.setTrackingNumber("111111111111");
        String payed =
                "<p style=\"font-size: 14px; line-height: 140%;\">您的訂單:" + order.getOrderNo() + "已經完成付款</p>" +
                "<p style=\"font-size: 14px; line-height: 140%;\">您會在發貨時收到一封含有追蹤物流編號的E-mail</p>";
        String delivery =
                "<p style=\"font-size: 14px; line-height: 140%;\">您的訂單:" + order.getOrderNo() + "已經發貨</p>" +
                        "<p style=\"font-size: 14px; line-height: 140%;\">追蹤物流編號:" + order.getTrackingNumber() +"</p>";
        emailService.sendMailByThymeleaf("gwe9001@gmail.com", "訂單:"+order.getOrderNo()+" 已付款", payed,"你的訂單已付款","order");
        emailService.sendMailByThymeleaf("gwe9001@gmail.com", "訂單:"+order.getOrderNo()+" 已發貨", delivery,"你的訂單已發貨","order");
    }

}

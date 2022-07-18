package eeit45.group3.bakeyourlife.order.utils;

import eeit45.group3.bakeyourlife.email.service.EmailService;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.constant.OrderStatusChangeEvent;
import eeit45.group3.bakeyourlife.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * 狀態監聽器
 */
@Component("orderStateListener")
@WithStateMachine(name = "orderStateMachine")
public class OrderStateListener {

    @Autowired
    private EmailService emailService;

    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public boolean payTransition(Message<OrderStatusChangeEvent> message) throws MessagingException {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.WAIT_DELIVER);
        System.out.println("支付，狀態機反饋資訊：" + message.getHeaders().toString());
        emailService.sendOrderMail(order, message.getPayload());
        return true;
    }

    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public boolean deliverTransition(Message<OrderStatusChangeEvent> message) throws MessagingException {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.WAIT_RECEIVE);
        System.out.println("發貨，狀態機反饋資訊：" + message.getHeaders().toString());
        emailService.sendOrderMail(order, message.getPayload());
        return true;
    }

    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public boolean receiveTransition(Message<OrderStatusChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.FINISH);
        System.out.println("收貨，狀態機反饋資訊：" + message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_PAYMENT", target = "CANCELLED")
    public boolean cancelTransition(Message<OrderStatusChangeEvent> message) throws MessagingException {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.CANCELLED);
        System.out.println("取消訂單，狀態機反饋資訊：" + message.getHeaders().toString());
        emailService.sendOrderMail(order, message.getPayload());
        return true;
    }

    @OnTransition(source = "WAIT_DELIVER", target = "REFUNDING")
    public boolean refundTransition(Message<OrderStatusChangeEvent> message) throws MessagingException {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.REFUNDING);
        System.out.println("提出退款，狀態機反饋資訊：" + message.getHeaders().toString());
        emailService.sendOrderMail(order, message.getPayload());
        return true;
    }

    @OnTransition(source = "REFUNDING", target = "REFUNDED")
    public boolean acceptTransition(Message<OrderStatusChangeEvent> message) throws MessagingException {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.REFUNDED);
        System.out.println("退款同意，狀態機反饋資訊：" + message.getHeaders().toString());
        emailService.sendOrderMail(order, message.getPayload());
        return true;
    }

    @OnTransition(source = "REFUNDING", target = "WAIT_DELIVER")
    public boolean rejectTransition(Message<OrderStatusChangeEvent> message) throws MessagingException {
        Order order = (Order) message.getHeaders().get("order");
        order.setOrderStatus(OrderStatus.WAIT_DELIVER);
        System.out.println("退款拒絕，狀態機反饋資訊：" + message.getHeaders().toString());
        emailService.sendOrderMail(order, message.getPayload());
        return true;
    }
}

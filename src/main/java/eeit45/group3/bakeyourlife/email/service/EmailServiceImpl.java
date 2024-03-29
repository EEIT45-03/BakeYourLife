package eeit45.group3.bakeyourlife.email.service;

import eeit45.group3.bakeyourlife.course.model.Register;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductPic;
import eeit45.group3.bakeyourlife.order.constant.OrderStatusChangeEvent;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service("EmailService")
public class EmailServiceImpl implements EmailService {

  private final String FROM_EMAIL = "Bake Your Life 烘焙材料網<bakeyourlifemail@gmail.com>";

  private final TemplateEngine templateEngine;

  private final JavaMailSender javaMailSender;

  @Autowired
  public EmailServiceImpl(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
    this.templateEngine = templateEngine;
    this.javaMailSender = javaMailSender;
  }

  /**
   * 寄信件
   *
   * @param to 收件者
   * @param subject 主旨
   * @param text 內容
   * @param templateName emails資料夾下的模板名稱
   * @throws MessagingException
   */
  @Override
  @Async
  public void sendMailByThymeleaf(
      String to, // 收件者
      String subject, // 主旨
      String text, // 內容
      String head,
      String templateName // 模板名稱
      ) throws MessagingException {
    Context context = new Context();
    context.setVariable("text", text);
    context.setVariable("head", head);
    User user = new User();
    user.setFullName("測試用戶");
    context.setVariable("user", user);

    String process = templateEngine.process("emails/" + templateName, context);
    javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    helper.setFrom(FROM_EMAIL);
    helper.setSubject(subject);
    helper.setText(process, true);
    helper.setTo(to);
    javaMailSender.send(mimeMessage);
  }

  // 報名課程Email
  @Override
  @Async // 非同步
  public void sendRegisterMail(
      String to, // 收件者
      String subject, // 主旨
      Register register, // 內容
      String templateName // 模板名稱
      ) throws MessagingException {
    Context context = new Context();
    context.setVariable("register", register);
    String process = templateEngine.process("emails/" + templateName, context);
    javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    helper.setFrom(FROM_EMAIL);
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(process, true);
    javaMailSender.send(mimeMessage);
  }

  @Override
  @Async // 非同步
  public void sendOrderMail(Order order, OrderStatusChangeEvent orderStatusChangeEvent)
      throws MessagingException {
    String to = order.getUser().getEmail();
    String subject = "訂單編號: " + order.getOrderNo();
    String status = "";
    switch (orderStatusChangeEvent) {
      case PAYED: // 付款
        status += "已付款";
        break;
      case DELIVERY: // 出貨
        status += "已出貨";
        break;
      case CANCEL: // 取消
        status += "已取消";
        break;
      case REFUND: // 退款
        status += "已成功提出退款請求";
        break;
      case ACCEPT: // 接受退款
        status += "退款請求已接受";
        break;
      case REJECT: // 拒絕退款
        status += "退款請求已被拒絕";
        break;
    }
    Context context = new Context();
    context.setVariable("order", order);
    context.setVariable("status", status);
    String process = templateEngine.process("emails/order", context);
    javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    helper.setFrom(FROM_EMAIL);
    helper.setTo(to);
    helper.setSubject(subject + " - " + status);
    helper.setText(process, true);
    javaMailSender.send(mimeMessage);
    System.out.println("已發送訂單通知信件");
  }

  @Override
  @Async // 非同步
  public void sendUserMail(
      String to, // 收件者
      String subject, // 主旨
      User user, // 內容
      String templateName // 模板名稱
      ) throws MessagingException {
    Context context = new Context();
    context.setVariable("user", user);
    String process = templateEngine.process("emails/" + templateName, context);
    javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    helper.setFrom(FROM_EMAIL);
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(process, true);
    javaMailSender.send(mimeMessage);
    System.out.println("已發送信件");
  }

  @Override
  @Async // 非同步
  public void sendFarmerMail(
      String to, // 收件者
      String subject, // 主旨
      Farmer farmer, // 內容
      String templateName // 模板名稱
      ) throws MessagingException {
    Context context = new Context();
    context.setVariable("farmer", farmer);
    String process = templateEngine.process("emails/" + templateName, context);
    javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    helper.setFrom(FROM_EMAIL);
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(process, true);
    javaMailSender.send(mimeMessage);
    System.out.println("已發送信件");
  }

  // 小農廠商違規通知信
  @Override
  @Async // 非同步
  public void sendViolationMail(
      String to, // 收件者
      String subject, // 主旨
      FarmerProductBean farmerProductBean, // 違規的商品
      String text, // 違規原因說明
      String templateName // 模板名稱
      ) throws MessagingException {
    Context context = new Context();
    context.setVariable("farmerProductBean", farmerProductBean);
    List<FarmerProductPic> farmerProductPicList = farmerProductBean.getFarmerProductPicList();
    String imgLink = farmerProductPicList.get(0).getPictureLink();
    context.setVariable("imgLink", imgLink);
    context.setVariable("text", text);
    String process = templateEngine.process("emails/" + templateName, context);
    javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    helper.setFrom(FROM_EMAIL);
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(process, true);
    javaMailSender.send(mimeMessage);
  }

  @Override
  @Async
  public void sendRentalMail(String to, String subject, Rental rental, String templateName)
      throws MessagingException {
    Context context = new Context();
    context.setVariable("rental", rental);
    String process = templateEngine.process("emails/" + templateName, context);
    javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
    helper.setFrom(FROM_EMAIL);
    helper.setTo(to);
    helper.setSubject(subject);
    helper.setText(process, true);
    javaMailSender.send(mimeMessage);
    System.out.println("已發送信件");
  }
}

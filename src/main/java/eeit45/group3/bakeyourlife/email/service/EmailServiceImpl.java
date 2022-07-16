package eeit45.group3.bakeyourlife.email.service;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Register;
import eeit45.group3.bakeyourlife.course.repository.CourseRepository;
import eeit45.group3.bakeyourlife.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    private final String FROM_EMAIL = "bakeyourlifemail@gmail.com";

    private final TemplateEngine templateEngine;

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailServiceImpl(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }

    //純文字信件
    @Override
    public void sendSimpleMessage(
            String to,//收件者
            String subject,//主旨
            String text) {//內容
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_EMAIL);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    /**
     * 寄信件
     * @param to 收件者
     * @param subject 主旨
     * @param text 內容
     * @param templateName emails資料夾下的模板名稱
     * @throws MessagingException
     */
    @Override
    public void sendMailByThymeleaf(
            String to,//收件者
            String subject,//主旨
            String text, //內容
            String templateName//模板名稱
    ) throws MessagingException {
        Context context = new Context();
        context.setVariable("text", text);

        String process = templateEngine.process("emails/"+templateName, context);
        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(subject);
        helper.setText(process, true);
        helper.setTo(to);
        javaMailSender.send(mimeMessage);

}
    //報名課程Email
    public void sendRegisterMail(
            String to,//收件者
            String subject,//主旨
            Register register,//內容
            String templateName//模板名稱
    ) throws MessagingException {
        Context context = new Context();
        context.setVariable("register", register);
        String process = templateEngine.process("emails/"+templateName, context);
        javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        helper.setSubject(subject);
        helper.setText(process, true);
        helper.setTo(to);
        javaMailSender.send(mimeMessage);

    }

}

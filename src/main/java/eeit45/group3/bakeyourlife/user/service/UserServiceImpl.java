package eeit45.group3.bakeyourlife.user.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import eeit45.group3.bakeyourlife.user.dao.UserRepository;
import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eeit45.group3.bakeyourlife.user.model.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserRepository repository;
    PasswordEncoder encoder;
    JavaMailSender mailSender;
    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder,JavaMailSender mailSender) {
        this.repository = repository;
        this.encoder = encoder;
        this.mailSender = mailSender;

    }

    @Override
    public User save(User user) {
        // 加密密碼
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public User getCurrentUser(Authentication authentication){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getUser();
    }

    @Override
    public void setCurrentUser(Authentication authentication, User user){
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        userDetails.setUser(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findByUserId(Integer userId) {
        return repository.findById(userId).orElse(null);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void deleteByUserId(Integer userId) {
        repository.deleteById(userId);

    }

    @Override
    public void updateUser(User user) {
        // 修改的加密密碼改在controller
//        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);


    }

    @Override
    public User findByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }


    public void register(User user, String siteURL)
            throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        String randomCode = RandomString.make(64);
        user.setVerificationCode(randomCode);
        user.setEnabled(false);

        repository.save(user);

        sendVerificationEmail(user, siteURL);
    }

    public void sendVerificationEmail(User user, String siteURL)
            throws UnsupportedEncodingException,MessagingException {
        String toAddress = user.getEmail();
        String fromAddress = "bakeyourlifemail@gmail.com";
        String senderName = "Bake Your Life 烘焙材料網";
        String subject = "Bake Your Life 烘焙材料網會員 "+user.getFullName()+ " 註冊驗證信件";
        String content = "Dear [[name]],<br>"
                + "請以下點擊連結完成註冊:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">點我完成註冊</a></h3>"
                + "謝謝您<br>";


        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getFullName());
        String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }

}

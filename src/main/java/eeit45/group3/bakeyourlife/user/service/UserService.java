package eeit45.group3.bakeyourlife.user.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.security.core.Authentication;

import eeit45.group3.bakeyourlife.user.model.User;

import javax.mail.MessagingException;


public interface UserService {

    User save(User user);
    User getCurrentUser(Authentication authentication);


    void setCurrentUser(Authentication authentication, User user);

    List<User> findAll();

    User findByUserId(Integer userId);

    User findByUsername(String username);

    void deleteByUserId(Integer userId);

    void updateUser(User user);


    User findByPhone(String phone);

    User findByEmail(String email);

    void register(User user, String siteURL)throws UnsupportedEncodingException, MessagingException;

    void resetpsw(User user);

    void sendfindpswEmail(User user);


    void sendVerificationEmail(User user, String siteURL)throws UnsupportedEncodingException, MessagingException;
    boolean verify(String verificationCode);

    boolean pswverify(String verificationCode);


}

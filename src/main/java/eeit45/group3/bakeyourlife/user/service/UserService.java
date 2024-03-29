package eeit45.group3.bakeyourlife.user.service;

import eeit45.group3.bakeyourlife.user.model.User;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.security.core.Authentication;

public interface UserService {

  User save(User user);

  User getCurrentUser(Authentication authentication);

  User getCurrentOAuthUser(Authentication authentication);

  void setCurrentUser(Authentication authentication, User user);

  List<User> findAll();

  User findByUserId(Integer userId);

  User findByUsername(String username);

  void deleteByUserId(Integer userId);

  void updateUser(User user);

  User findByPhone(String phone);

  User findByEmail(String email);

  Long count();

  Long countEnabled();

  void register(User user) throws UnsupportedEncodingException, MessagingException;

  void sendVerificationEmail(User user);

  void sendNewUserCouponEmail(User user);

  void resetpsw(User user);

  void sendFindPswEmail(User user);

  void loginresetpsw(User user);

  void sendLoginFindPswEmail(User user);

  boolean verify(String verificationCode);

  boolean pswverify(String verificationCode);

  void createNewUserAfterOAuthLoginSuccess(String email, String name, String imageUrl);

  void updateUserAfterOAuthLoginSuccess(User user, String name);
}

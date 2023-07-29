package eeit45.group3.bakeyourlife.user.service;

import eeit45.group3.bakeyourlife.email.service.EmailService;
import eeit45.group3.bakeyourlife.user.dao.UserRepository;
import eeit45.group3.bakeyourlife.user.model.CustomOAuth2User;
import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.User;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.List;
import javax.mail.MessagingException;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  UserRepository repository;
  PasswordEncoder encoder;
  JavaMailSender mailSender;
  @Autowired EmailService emailService;

  @Autowired
  public UserServiceImpl(
      UserRepository repository, PasswordEncoder encoder, JavaMailSender mailSender) {
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
  public User getCurrentUser(Authentication authentication) {
    if (authentication instanceof OAuth2AuthenticationToken) {
      CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
      String email = customOAuth2User.getEmail();
      return repository.findByEmail(email);
    } else if (authentication instanceof UsernamePasswordAuthenticationToken
        || authentication instanceof RememberMeAuthenticationToken) {
      CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
      return repository.findByUsername(userDetails.getUsername());
    }
    //        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    //        return repository.findByUsername(userDetails.getUsername());
    //        return userDetails.getUser();
    return null;
  }

  @Override
  public User getCurrentOAuthUser(Authentication authentication) {
    CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
    String email = customOAuth2User.getEmail();
    return repository.findByEmail(email);
    //        return userDetails.getUser();
  }

  @Override
  public void setCurrentUser(Authentication authentication, User user) {
    // -------------------------------------------------
    if (authentication instanceof OAuth2AuthenticationToken) {
      CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
      customOAuth2User.setUser(user);
    } else if (authentication instanceof UsernamePasswordAuthenticationToken
        || authentication instanceof RememberMeAuthenticationToken) {
      CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
      userDetails.setUser(user);
    }
    //        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    //        return repository.findByUsername(userDetails.getUsername());
    //        return userDetails.getUser();
    // ---------------------------------------------------

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

  @Override
  public Long count() {
    return repository.count();
  }

  @Override
  public Long countEnabled() {
    return repository.countEnabled();
  }

  @Override
  public void register(User user) throws UnsupportedEncodingException, MessagingException {
    String encodedPassword = encoder.encode(user.getPassword());
    user.setPassword(encodedPassword);

    String randomCode = RandomString.make(64);
    user.setVerificationCode(randomCode);
    user.setEnabled(false);

    repository.save(user);

    sendVerificationEmail(user);
  }

  @Override
  public void sendVerificationEmail(User user) {
    //        String randomCode = RandomString.make(64);
    String email = user.getEmail();
    try {
      emailService.sendUserMail(email, "Bake Your Life 烘焙材料網註冊驗證信件", user, "signupmail");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void sendNewUserCouponEmail(User user) {
    String email = user.getEmail();
    try {
      emailService.sendUserMail(email, "歡迎加入 Bake Your Life 烘焙材料網(內含優惠券)", user, "coupon");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

  // ----------------------------------------------------------------------------------------------------------

  @Override
  public void resetpsw(User user) {
    String randomCode = RandomString.make(64);
    user.setVerificationCode(randomCode);

    repository.save(user);
    sendFindPswEmail(user);
  }

  @Override
  public void sendFindPswEmail(User user) {
    String email = user.getEmail();
    try {
      emailService.sendUserMail(email, "Bake Your Life 烘焙材料網 重設您的密碼", user, "findpswmail");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

  // -------------------------------------------------------------------------------------------------------

  @Override
  public void loginresetpsw(User user) {
    String randomCode = RandomString.make(64);
    user.setVerificationCode(randomCode);

    repository.save(user);
    sendLoginFindPswEmail(user);
  }

  @Override
  public void sendLoginFindPswEmail(User user) {
    String email = user.getEmail();
    try {
      emailService.sendUserMail(email, "Bake Your Life 烘焙材料網 重設您的密碼", user, "loginfindpswmail");
    } catch (MessagingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean verify(String verificationCode) {
    User user = repository.findByVerificationCode(verificationCode);

    if (user == null || user.isEnabled()) {
      return false;
    } else {
      user.setVerificationCode(null);
      user.setEnabled(true);
      repository.save(user);
      sendNewUserCouponEmail(user);
      return true;
    }
  }

  @Override
  public boolean pswverify(String verificationCode) {
    User user = repository.findByVerificationCode(verificationCode);

    if (user == null) {
      return false;
    } else {
      user.setVerificationCode(null);
      repository.save(user);

      return true;
    }
  }

  @Override
  public void createNewUserAfterOAuthLoginSuccess(String email, String name, String imageUrl) {
    Timestamp ts = new Timestamp(System.currentTimeMillis());
    String randomCode = RandomString.make(10);

    User user = new User();
    user.setUsername(randomCode);
    user.setEmail(email);
    user.setFullName(name);
    user.setEnabled(true);
    user.setImageUrl(imageUrl);
    user.setRegisterTime(ts);
    user.setAuthority("ROLE_USER");
    repository.save(user);
  }

  @Override
  public void updateUserAfterOAuthLoginSuccess(User user, String name) {
    user.setFullName(name);
    repository.save(user);
  }
}

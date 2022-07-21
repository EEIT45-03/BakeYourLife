package eeit45.group3.bakeyourlife.user.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import eeit45.group3.bakeyourlife.email.service.EmailService;
import eeit45.group3.bakeyourlife.user.dao.UserRepository;
import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eeit45.group3.bakeyourlife.user.model.User;

import javax.mail.MessagingException;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserRepository repository;
    PasswordEncoder encoder;
    JavaMailSender mailSender;
    @Autowired
    EmailService emailService;
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

    @Override
    public void register(User user )
            throws UnsupportedEncodingException, MessagingException {
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
            emailService.sendUserMail(email, "Bake Your Life 烘焙材料網註冊驗證信件",user,"signupmail");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }


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
            emailService.sendUserMail(email, "Bake Your Life 烘焙材料網 重設您的密碼",user,"findpswmail");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
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
            emailService.sendUserMail(email, "Bake Your Life 烘焙材料網 重設您的密碼",user,"loginfindpswmail");
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

}

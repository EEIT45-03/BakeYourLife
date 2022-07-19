package eeit45.group3.bakeyourlife.user.service;

import eeit45.group3.bakeyourlife.user.dao.FarmerRepository;
import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Transactional
public class FarmerServiceImpl implements FarmerService {


    FarmerRepository farmerRepository;
    PasswordEncoder encoder;
    JavaMailSender mailSender;


    @Autowired
    public FarmerServiceImpl(FarmerRepository farmerRepository, PasswordEncoder encoder, JavaMailSender mailSender) {
        this.farmerRepository = farmerRepository;
        this.encoder = encoder;
        this.mailSender = mailSender;

    }

    @Override
    public Farmer save(Farmer farmer) {
        // 加密密碼
        farmer.setPassword(encoder.encode(farmer.getPassword()));
        return farmerRepository.save(farmer);
    }

    @Override
    public Farmer getCurrentFarmer(Authentication authentication) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        return userDetails.getFarmer();
    }

    @Override
    public void setCurrentFarmer(Authentication authentication, Farmer farmer) {
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        userDetails.setFarmer(farmer);
    }

    @Override
    public List<Farmer> findAll() {
        return farmerRepository.findAll();
    }

    @Override
    public Farmer findByFarmerId(Integer farmerId) {
        return farmerRepository.findById(farmerId).orElse(null);
    }

    @Override
    public Farmer findByUsername(String username) {
        return farmerRepository.findByUsername(username);
    }

    @Override
    public void deleteByFarmerId(Integer farmerId) {
        farmerRepository.deleteById(farmerId);
    }

    @Override
    public void updateFarmer(Farmer farmer) {
        // 修改的加密密碼改在controller
//        farmer.setPassword(encoder.encode(farmer.getPassword()));
        farmerRepository.save(farmer);

    }

    @Override
    public void register(Farmer farmer, String siteURL)
            throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = encoder.encode(farmer.getPassword());
        farmer.setPassword(encodedPassword);

        String randomCode = RandomString.make(64);
        farmer.setVerificationCode(randomCode);
        farmer.setEnabled(false);

        farmerRepository.save(farmer);

        sendVerificationEmail(farmer, siteURL);
    }

    @Override
    public void sendVerificationEmail(Farmer farmer, String siteURL)
            throws UnsupportedEncodingException, MessagingException {
        String toAddress = farmer.getEmail();
        String fromAddress = "bakeyourlifemail@gmail.com";
        String senderName = "Bake Your Life 烘焙材料網";
        String subject = "Bake Your Life 烘焙材料網小農廠商會員 " + farmer.getFarmerName() + " 註冊驗證信件";
        String content = "Dear [[name]],<br>"
                + "請以下點擊連結完成註冊:<br>"
                + "<h2><a href=\"[[URL]]\" target=\"_self\">點我完成註冊</a></h2>"
                + "謝謝您<br>";


        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", farmer.getFarmerName());
        String verifyURL = siteURL + "/farmerVerify?code=" + farmer.getVerificationCode();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }

    @Override
    public boolean verify(String verificationCode) {
        Farmer farmer = farmerRepository.findByVerificationCode(verificationCode);

        if (farmer == null || farmer.isEnabled()) {
            return false;
        } else {
            farmer.setVerificationCode(null);
            farmer.setEnabled(true);
            farmerRepository.save(farmer);

            return true;
        }
    }

    @Override
    public Long count() {
        return farmerRepository.count();
    }
}

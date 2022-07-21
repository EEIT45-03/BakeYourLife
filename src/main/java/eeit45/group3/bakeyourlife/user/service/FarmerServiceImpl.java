package eeit45.group3.bakeyourlife.user.service;

import eeit45.group3.bakeyourlife.email.service.EmailService;
import eeit45.group3.bakeyourlife.user.dao.FarmerRepository;
import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Transactional
public class FarmerServiceImpl implements FarmerService {


    FarmerRepository farmerRepository;
    PasswordEncoder encoder;
    JavaMailSender mailSender;
    @Autowired
    EmailService emailService;


    @Autowired
    public FarmerServiceImpl(FarmerRepository farmerRepository, PasswordEncoder encoder,JavaMailSender mailSender) {
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
    public Long count() {
        return farmerRepository.count();
    }


//---------------------------------------------------------------------------------
    @Override
    public void farmerResetPsw(Farmer farmer) {
        String randomCode = RandomString.make(64);
        farmer.setVerificationCode(randomCode);

        farmerRepository.save(farmer);
        sendFindPswEmail(farmer);
    }
    @Override
    public void sendFindPswEmail(Farmer farmer) {
        String email = farmer.getEmail();
        try {
            emailService.sendFarmerMail(email, "Bake Your Life 烘焙材料網 重設您的密碼",farmer,"farmerfindpswmail");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

//--------------------------------------------------------------------------------
    @Override
    public void register(Farmer farmer)
            throws UnsupportedEncodingException, MessagingException {
        String encodedPassword = encoder.encode(farmer.getPassword());
        farmer.setPassword(encodedPassword);

        String randomCode = RandomString.make(64);
        farmer.setVerificationCode(randomCode);
        farmer.setEnabled(false);

        farmerRepository.save(farmer);

        sendVerificationEmail(farmer);
    }

    @Override
    public void sendVerificationEmail(Farmer farmer)
            throws UnsupportedEncodingException, MessagingException {
        String email = farmer.getEmail();
        try {
            emailService.sendFarmerMail(email, "Bake Your Life 烘焙材料網 小農廠商註冊驗證信件",farmer,"farmersignupmail");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

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
    public boolean farmerpswverify(String verificationCode) {
        Farmer farmer = farmerRepository.findByVerificationCode(verificationCode);

        if (farmer == null) {
            return false;
        } else {
            farmer.setVerificationCode(null);
            farmerRepository.save(farmer);

            return true;
        }

    }
}

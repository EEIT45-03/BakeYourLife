package eeit45.group3.bakeyourlife.user.service;


import eeit45.group3.bakeyourlife.user.model.Farmer;
import org.springframework.security.core.Authentication;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface FarmerService {
    Farmer save(Farmer farmer);
    Farmer getCurrentFarmer(Authentication authentication);
    void setCurrentFarmer(Authentication authentication, Farmer farmer);



    List<Farmer> findAll();

    Farmer findByFarmerId(Integer farmerId);

    Farmer findByUsername(String username);

    void deleteByFarmerId(Integer farmerId);

    void updateFarmer(Farmer farmer);

    void register(Farmer farmer, String siteURL)throws UnsupportedEncodingException, MessagingException;
    void sendVerificationEmail(Farmer farmer, String siteURL)throws UnsupportedEncodingException, MessagingException;
    boolean verify(String verificationCode);

}

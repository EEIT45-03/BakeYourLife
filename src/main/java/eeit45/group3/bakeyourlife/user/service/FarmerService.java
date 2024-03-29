package eeit45.group3.bakeyourlife.user.service;

import eeit45.group3.bakeyourlife.user.model.Farmer;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.security.core.Authentication;

public interface FarmerService {
  Farmer save(Farmer farmer);

  Farmer getCurrentFarmer(Authentication authentication);

  void setCurrentFarmer(Authentication authentication, Farmer farmer);

  List<Farmer> findAll();

  Farmer findByFarmerId(Integer farmerId);

  Farmer findByUsername(String username);

  void deleteByFarmerId(Integer farmerId);

  void updateFarmer(Farmer farmer);

  Long count();

  void farmerResetPsw(Farmer farmer);

  void sendFindPswEmail(Farmer farmer);

  void register(Farmer farmer) throws UnsupportedEncodingException, MessagingException;

  void sendVerificationEmail(Farmer farmer) throws UnsupportedEncodingException, MessagingException;

  boolean verify(String verificationCode);

  boolean farmerpswverify(String verificationCode);
}

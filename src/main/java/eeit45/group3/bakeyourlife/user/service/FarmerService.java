package eeit45.group3.bakeyourlife.user.service;


import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.security.core.Authentication;

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

}

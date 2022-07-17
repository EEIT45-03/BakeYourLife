package eeit45.group3.bakeyourlife.user.service;


import eeit45.group3.bakeyourlife.user.model.Farmer;

import java.util.List;

public interface FarmerService {
    Farmer save(Farmer farmer);

    List<Farmer> findAll();

    Farmer findByFarmerId(Integer farmerId);

    Farmer findByUsername(String username);

    void deleteByFarmerId(Integer farmerId);

    void updateFarmer(Farmer farmer);

    Long count();

}

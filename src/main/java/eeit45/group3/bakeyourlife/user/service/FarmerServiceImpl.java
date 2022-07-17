package eeit45.group3.bakeyourlife.user.service;

import eeit45.group3.bakeyourlife.user.dao.FarmerRepository;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FarmerServiceImpl implements FarmerService {


    FarmerRepository farmerRepository;
    PasswordEncoder encoder;

    @Autowired
    public FarmerServiceImpl(FarmerRepository farmerRepository, PasswordEncoder encoder) {
        this.farmerRepository = farmerRepository;
        this.encoder = encoder;
    }

    @Override
    public Farmer save(Farmer farmer) {
        // 加密密碼
        farmer.setPassword(encoder.encode(farmer.getPassword()));
        return farmerRepository.save(farmer);
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
        // 加密密碼
        farmer.setPassword(encoder.encode(farmer.getPassword()));
        farmerRepository.save(farmer);

    }

    @Override
    public Long count() {
        return farmerRepository.count();
    }
}

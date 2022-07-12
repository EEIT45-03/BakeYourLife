package eeit45.group3.bakeyourlife.user.dao;

import eeit45.group3.bakeyourlife.user.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
    Farmer findByUsername(String username);

}

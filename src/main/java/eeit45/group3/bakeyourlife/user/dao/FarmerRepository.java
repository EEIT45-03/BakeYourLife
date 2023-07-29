package eeit45.group3.bakeyourlife.user.dao;

import eeit45.group3.bakeyourlife.user.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FarmerRepository extends JpaRepository<Farmer, Integer> {
  Farmer findByUsername(String username);

  @Query("SELECT f FROM Farmer f WHERE f.verificationCode = ?1")
  public Farmer findByVerificationCode(String code);
}

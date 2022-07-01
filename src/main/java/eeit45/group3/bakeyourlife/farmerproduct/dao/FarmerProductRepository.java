package eeit45.group3.bakeyourlife.farmerproduct.dao;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FarmerProductRepository extends JpaRepository<FarmerProductBean, Integer> {

    FarmerProductBean findByFarmerProductId(Integer farmerProductId);
}

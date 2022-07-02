package eeit45.group3.bakeyourlife.farmerproduct.dao;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductPic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FarmerProductPicRepository extends JpaRepository<FarmerProductPic, Integer> {

    FarmerProductPic findByPicId(Integer picId);

    List<FarmerProductPic> findAllByFarmerProductBean_FarmerProductId(Integer farmerProductId);

    void deleteFarmerProductPicsByFarmerProductBean_FarmerProductId(Integer farmerProductId);

}

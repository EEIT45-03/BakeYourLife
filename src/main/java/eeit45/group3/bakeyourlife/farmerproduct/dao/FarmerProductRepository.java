package eeit45.group3.bakeyourlife.farmerproduct.dao;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.utils.TypeAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FarmerProductRepository extends JpaRepository<FarmerProductBean, Integer> {

    FarmerProductBean findByFarmerProductId(Integer farmerProductId);

    List<FarmerProductBean> findByStateOrderByLaunchedTimeDesc(Integer state);

    List<FarmerProductBean> findByTypeAndStateOrderByLaunchedTimeDesc(String type, Integer state);

    @Query(nativeQuery = true, value = "Select type, count(type) AS 'value' from farmer_product group by type")
    List<TypeAmount> findTypeAmount();

}

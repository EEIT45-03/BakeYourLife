package eeit45.group3.bakeyourlife.order.dao;

import eeit45.group3.bakeyourlife.order.model.SalesRecord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRecordRepository extends JpaRepository<SalesRecord, Integer> {

  List<SalesRecord> findAllByFarmerId(Integer farmerId);
}

package eeit45.group3.bakeyourlife.order.dao;

import eeit45.group3.bakeyourlife.order.model.SalesRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRecordRepository extends JpaRepository<SalesRecord, Integer> {

    List<SalesRecord> findAllByFarmerId(Integer farmerId);

}

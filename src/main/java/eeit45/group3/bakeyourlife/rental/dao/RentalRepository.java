package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    public List<Rental> findAllByType(String type);
//    public List<Rental> findAllByTypeAndByLendTimeLessThan(String listType,Date LendTime);
}

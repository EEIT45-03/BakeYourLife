package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenueListRepository extends JpaRepository<VenueList, Integer> {

    public List<VenueList> findAllByRental(Rental rental);

    @Query("SELECT SUM(vl.price) FROM VenueList vl " +
            "WHERE vl.rental = :r ")
    public Long findPriceSumByRental(@Param("r") Rental rental);
}

package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.rental.utils.AvailableQuantity;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface VenueListRepository extends JpaRepository<VenueList, Integer> {

    public List<VenueList> findAllByRental(Rental rental);

//    Long findPriceSumByRental(Rental rental);

    @Query("SELECT SUM(vl.price) FROM VenueList vl " +
            "WHERE vl.rental = :r ")
    public Long findPriceSumByRental(@Param("r") Rental rental);

    @Query(value = "select vl.period as 'label', sum(vl.person) as 'value' from venue_list vl " +
                    "WHERE vl.rental_date = :date " +
                    "AND vl.fk_venue_id = :v  GROUP BY vl.period",
                    nativeQuery = true)
    public List<AvailableQuantity> findSumByVenueAndDatetime(@Param("v") Integer venue,
                                                             @Param("date") Date date);


}

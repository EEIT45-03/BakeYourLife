package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    public List<Rental> findAllByType(String type);

    @Query("SELECT t.rental FROM TackleList t " +
            "WHERE t.lendDate <= :lDate " +
            "AND t.endDate >= :eDate " +
            "Order By t.tackleListId asc ")
    public List<Rental> findAllByDateBetween(
                                     @Param("lDate") String lDate,
                                     @Param("eDate") String eDate);

//    @Query
//    public List<VenueList> findAllByTimeBetween();
}

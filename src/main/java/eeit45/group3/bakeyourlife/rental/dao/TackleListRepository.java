package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TackleListRepository extends JpaRepository<TackleList, Integer> {

  public List<TackleList> findAllByRental(Rental rental);

  @Query("SELECT SUM(tl.total) FROM TackleList tl WHERE tl.rental = :r ")
  public Long findPriceSumByRental(@Param("r") Rental rental);
}

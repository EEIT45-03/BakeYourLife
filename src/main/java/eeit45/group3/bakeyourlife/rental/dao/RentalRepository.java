package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.user.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

  public Rental findByRentalNo(String rentalNo);

  public List<Rental> findAllByType(String type);

  public List<Rental> findAllByRentalNoStartingWith(String rentalNo);

  public List<Rental> findAllByUser(User user);

  public List<Rental> findAllByUserAndRentalNoStartingWith(User user, String RentalNo);

  public List<Rental> findAllByTypeAndRentalNoStartingWith(String listType, String RentalNo);

  public List<Rental> findAllByUserAndType(User user, String listType);

  public List<Rental> findAllByUserAndTypeAndRentalNoStartingWith(
      User user, String listType, String rentalNo);

  @Query(
      "SELECT t.rental FROM TackleList t "
          + "WHERE t.lendDate <= :lDate "
          + "AND t.endDate >= :eDate "
          + "Order By t.tackleListId asc ")
  public List<Rental> findAllByDateBetween(
      @Param("lDate") String lDate, @Param("eDate") String eDate);

  public Rental findByUserAndStateAndType(User user, String state, String listType);

  public List<Rental> findAllByStateAndUser(String state, User user);

  @Query("Select Sum(total) FROM Rental")
  public Long findByRentalTotalSum();

  @Query("SELECT count(r) FROM Rental r")
  Long findByRentalCount();
}

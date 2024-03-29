package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.rental.utils.AvailableQuantity;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VenueListRepository extends JpaRepository<VenueList, Integer> {

  public List<VenueList> findAllByRental(Rental rental);

  public VenueList findByVenueListNo(String no);

  //    Long findPriceSumByRental(Rental rental);

  @Query("SELECT SUM(vl.price) FROM VenueList vl " + "WHERE vl.rental = :r ")
  public Long findPriceSumByRental(@Param("r") Rental rental);

  @Query(
      value =
          "select vl.period as 'label', sum(vl.person) as 'value' from venue_list vl "
              + "INNER JOIN (SELECT * FROM rental where state != '已退單') r ON vl.fk_rental_id = r.rental_id "
              + "WHERE vl.rental_date = :date "
              + "AND vl.fk_venue_id = :v  GROUP BY vl.period ",
      nativeQuery = true)
  public List<AvailableQuantity> findSumByVenueAndDatetime(
      @Param("v") Integer venue, @Param("date") Date date);

  public VenueList findByRentalAndVenueAndRentalDateAndPeriod(
      Rental rental, Venue venue, Date date, String period);

  @Query(
      value =
          "select SUM(vl.person) from venue_list vl INNER JOIN (SELECT * FROM rental where state != '已退單') r ON vl.fk_rental_id = r.rental_id",
      nativeQuery = true)
  public Long findByVenueListPersonSum();

  @Query(
      value =
          "SELECT sum(person) as 'value' ,sort as 'label' FROM venue v left join venue_sort vs ON v.fk_sort_id = vs.venue_sort_id join venue_list vl ON v.venue_id = vl.fk_venue_id group by sort",
      nativeQuery = true)
  public List<AvailableQuantity> findSortPersonSum();

  @Query(
      value =
          "select sum(vl.person) as 'value', v.venue_name as 'label' from venue_list vl join venue v on vl.fk_venue_id = v.venue_id group by v.venue_name ",
      nativeQuery = true)
  public List<AvailableQuantity> findVenuePersonSum();

  @Query(
      value =
          "select sum(vl.price) as 'value', v.venue_name as 'label' from venue_list vl join venue v on vl.fk_venue_id = v.venue_id group by v.venue_name ",
      nativeQuery = true)
  public List<AvailableQuantity> findVenuePriceSum();

  @Query(
      value =
          "select * from (select sum(vl.person) as 'value', v.venue_name as 'label' from venue_list vl join venue v on vl.fk_venue_id = v.venue_id group by v.venue_name) r where r.value = (select max(r1.value) from  ( select sum(vl.person) as 'value', v.venue_name as 'label' from venue_list vl join venue v on vl.fk_venue_id = v.venue_id group by v.venue_name ) r1)",
      nativeQuery = true)
  public AvailableQuantity findVenuePersonMax();
}

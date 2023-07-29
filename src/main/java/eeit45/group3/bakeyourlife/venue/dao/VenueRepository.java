package eeit45.group3.bakeyourlife.venue.dao;

import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.model.VenueSort;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VenueRepository extends JpaRepository<Venue, Integer> {

  public Venue findByVenueName(String venueName);

  @Query("SELECT v.venueName FROM Venue v ORDER BY v.venueName")
  public List<String> findAllVenueName();

  public List<Venue> findByOrderByVenueNameAsc();

  public List<Venue> findByVenueSort(VenueSort venueSort);

  public List<Venue> findAllByVenueNameAndVenueSort(String venueName, VenueSort venueSort);

  public List<Venue> findAllByVenueSort(VenueSort venueSort);

  public List<Venue> findByVenueSortNot(VenueSort venueSort);

  @Query(
      value =
          "SELECT v.*  FROM venue v "
              + "INNER JOIN (SELECT TOP (3) fk_venue_id, COUNT(fk_venue_id) sum FROM venue_list "
              + "GROUP BY fk_venue_id) vl on v.venue_id = vl.fk_venue_id "
              + "Order by vl.sum desc",
      nativeQuery = true)
  public List<Venue> findByVenueTopThree();
}

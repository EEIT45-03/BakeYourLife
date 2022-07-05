package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface VenueRepository extends JpaRepository<Venue, Integer> {
    public Venue findByVenueName(String venueName);

    @Query("SELECT v.venueName FROM Venue v")
    public List<String> findAllVenueName();


}

package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VenueRepository extends JpaRepository<Venue, Integer> {
    public Venue findByVenueName(String venueName);
}

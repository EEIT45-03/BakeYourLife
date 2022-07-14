package eeit45.group3.bakeyourlife.tackle.dao;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.model.TackleSort;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.model.VenueSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TackleRepository extends JpaRepository<Tackle, Integer> {

    public Tackle findByTackleName(String tackleName);

    public List<Tackle> findByTackleSort(TackleSort sort);

    public List<Tackle> findByTackleNameAndTackleSort(String tackleName, TackleSort tackleSort);

    public List<Tackle> findAllByTackleSort(TackleSort tackleSort);

    @Query("SELECT t.tackleName FROM Tackle t")
    public List<String> findAllTackleName();

}

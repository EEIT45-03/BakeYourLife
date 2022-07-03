package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Tackle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TackleRepository extends JpaRepository<Tackle, Integer> {

    public Tackle findByTackleName(String tackleName);

    @Query("SELECT t.tackleName FROM Tackle t")
    public List<String> findAllTackleName();

}

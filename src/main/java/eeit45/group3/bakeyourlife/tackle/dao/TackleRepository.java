package eeit45.group3.bakeyourlife.tackle.dao;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TackleRepository extends JpaRepository<Tackle, Integer> {

    public Tackle findByTackleName(String tackleName);

    public List<Tackle> findByTackleSort(String sort);

    public List<Tackle> findByTackleNameAndTackleSort(String tackleName, String sort);

    @Query("SELECT t.tackleName FROM Tackle t")
    public List<String> findAllTackleName();

}

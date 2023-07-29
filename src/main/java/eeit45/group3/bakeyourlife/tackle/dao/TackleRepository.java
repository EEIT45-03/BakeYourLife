package eeit45.group3.bakeyourlife.tackle.dao;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.model.TackleSort;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TackleRepository extends JpaRepository<Tackle, Integer> {

  public Tackle findByTackleName(String tackleName);

  public List<Tackle> findByTackleSort(TackleSort sort);

  public List<Tackle> findByTackleNameAndTackleSort(String tackleName, TackleSort tackleSort);

  public List<Tackle> findAllByTackleSort(TackleSort tackleSort);

  @Query("SELECT t.tackleName FROM Tackle t")
  public List<String> findAllTackleName();
}

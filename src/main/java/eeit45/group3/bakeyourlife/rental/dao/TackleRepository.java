package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Tackle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TackleRepository extends JpaRepository<Tackle, Integer> {

    public Tackle findByTackleName(String tackleName);

}

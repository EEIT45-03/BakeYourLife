package eeit45.group3.bakeyourlife.rental.dao;

import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TackleListRepository extends JpaRepository<TackleList, Integer> {

    public List<TackleList> findAllByRental(Rental rental);
}

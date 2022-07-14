package eeit45.group3.bakeyourlife.tackle.dao;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.model.TackleSort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TackleSortRepository extends JpaRepository<TackleSort, Integer> {

    public TackleSort findBySort(String sort);
}

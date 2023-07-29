package eeit45.group3.bakeyourlife.venue.dao;

import eeit45.group3.bakeyourlife.venue.model.VenueSort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueSortRepository extends JpaRepository<VenueSort, Integer> {

  public VenueSort findBySort(String sort);
}

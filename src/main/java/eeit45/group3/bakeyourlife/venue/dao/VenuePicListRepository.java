package eeit45.group3.bakeyourlife.venue.dao;

import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.model.VenuePicList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenuePicListRepository extends JpaRepository<VenuePicList, Integer> {

    @Query("SELECT COUNT(p) FROM VenuePicList p where p.venue = : v")
    public Integer findCountByVenue(@Param("v") Venue venue);

    public List<VenuePicList> findAllByVenue(Venue venue);
}

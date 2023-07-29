package eeit45.group3.bakeyourlife.venue.controller;

import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.model.VenueSort;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VenueUIController {

  VenueService venueService;

  @Autowired
  public VenueUIController(VenueService venueService) {
    this.venueService = venueService;
  }

  @GetMapping("/VenueSorts")
  public ResponseEntity<List<VenueSort>> getVenueSorts() {
    List<VenueSort> venueSorts = venueService.findAllVenueSort();
    return ResponseEntity.status(HttpStatus.OK).body(venueSorts);
  }

  @GetMapping("/Venues")
  public ResponseEntity<List<Venue>> getVenues() {
    List<Venue> venues = venueService.findAllVenue();
    return ResponseEntity.status(HttpStatus.OK).body(venues);
  }

  @GetMapping("/Venues/{sortId}")
  public ResponseEntity<List<Venue>> getVenuesBySort(@PathVariable Integer sortId) {
    List<Venue> venues = venueService.findAllByVenueSort(sortId);
    return ResponseEntity.status(HttpStatus.OK).body(venues);
  }

  @GetMapping("/Venues/Not/{sortId}")
  public ResponseEntity<List<Venue>> getVenuesBySortNot(@PathVariable Integer sortId) {
    List<Venue> venues = venueService.findAllByVenueSortNot(sortId);
    return ResponseEntity.status(HttpStatus.OK).body(venues);
  }

  @GetMapping("/checkVenueName")
  public ResponseEntity<List<String>> checkVenueName() {
    List<String> names = venueService.findAllVenueName();
    return ResponseEntity.status(HttpStatus.OK).body(names);
  }

  @GetMapping("/checkVenueName/{id}")
  public ResponseEntity<Map<String, Object>> checkVenueName1(@PathVariable Integer id) {
    Venue venue = venueService.findByVenueId(id);
    List<String> names = venueService.findAllVenueName();
    Map<String, Object> map = new HashMap<>();
    map.put("name", venue.getVenueName());
    map.put("names", names);
    return ResponseEntity.status(HttpStatus.OK).body(map);
  }
}

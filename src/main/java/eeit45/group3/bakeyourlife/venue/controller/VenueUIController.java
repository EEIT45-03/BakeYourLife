package eeit45.group3.bakeyourlife.venue.controller;

import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class VenueUIController {

    VenueService venueService;

    @Autowired
    public VenueUIController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping("/Venues")
    public ResponseEntity<List<Venue>> getVenues() {
        List<Venue> venues = venueService.findAllVenue();
        return ResponseEntity.status(HttpStatus.OK).body(venues);
    }

//    @GetMapping("/Venues/{package}")
//    public ResponseEntity<List<Venue>> getVenues1(@PathVariable Integer packageNo) {
//
//        List<Venue> venues = venueService.findAllVenue();
//        return ResponseEntity.status(HttpStatus.OK).body(venues);
//    }
}

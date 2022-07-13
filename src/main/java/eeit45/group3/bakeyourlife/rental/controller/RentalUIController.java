package eeit45.group3.bakeyourlife.rental.controller;


import eeit45.group3.bakeyourlife.rental.service.RentalService;
//import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.tackle.model.TackleSort;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.venue.dto.VenueTop3;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.model.VenueSort;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RentalUIController {

    RentalService rentalService;
    VenueService venueService;
    TackleService tackleService;

    @Autowired
    public RentalUIController(RentalService rentalService, VenueService venueService, TackleService tackleService) {
        this.rentalService = rentalService;
        this.venueService = venueService;
        this.tackleService = tackleService;
    }

    @GetMapping("/VenueSorts")
    public ResponseEntity<List<VenueSort>> getVenueSorts() {
        List<VenueSort> venueSorts = venueService.findAllVenueSort();
        return ResponseEntity.status(HttpStatus.OK).body(venueSorts);
    }

    @GetMapping("/TackleSorts")
    public ResponseEntity<List<TackleSort>> getTackleSorts() {
        List<TackleSort> tackleSorts = tackleService.findAllTackleSort();
        return ResponseEntity.status(HttpStatus.OK).body(tackleSorts);
    }

    @GetMapping("/TopThree/Venue")
    public ResponseEntity<List<Venue>> getVenueTopThree() {
        List<Venue> venues = venueService.findByVenueTopThree();
        return ResponseEntity.status(HttpStatus.OK).body(venues);
    }

}
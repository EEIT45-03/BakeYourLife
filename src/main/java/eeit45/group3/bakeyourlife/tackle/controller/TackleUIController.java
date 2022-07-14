package eeit45.group3.bakeyourlife.tackle.controller;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TackleUIController {

    TackleService tackleService;

    @Autowired
    public TackleUIController(TackleService tackleService) {
        this.tackleService = tackleService;
    }

    @GetMapping("/Tackles")
    public ResponseEntity<List<Tackle>> getVenueTopThree() {
        List<Tackle> tackles = tackleService.findAllTackle();
        return ResponseEntity.status(HttpStatus.OK).body(tackles);
    }
}

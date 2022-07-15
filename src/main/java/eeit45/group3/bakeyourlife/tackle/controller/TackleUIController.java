package eeit45.group3.bakeyourlife.tackle.controller;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.model.TackleSort;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class TackleUIController {

    TackleService tackleService;

    @Autowired
    public TackleUIController(TackleService tackleService) {
        this.tackleService = tackleService;
    }

    @GetMapping("/TackleSorts")
    public ResponseEntity<List<TackleSort>> getTackleSorts() {
        List<TackleSort> tackleSorts = tackleService.findAllTackleSort();
        return ResponseEntity.status(HttpStatus.OK).body(tackleSorts);
    }

    @GetMapping("/Tackles")
    public ResponseEntity<List<Tackle>> getVenueTopThree() {
        List<Tackle> tackles = tackleService.findAllTackle();
        return ResponseEntity.status(HttpStatus.OK).body(tackles);
    }

    @GetMapping("/Tackles/{sortId}")
    public ResponseEntity<List<Tackle>> getVenuesBySort(@PathVariable Integer sortId) {
        List<Tackle> tackles = tackleService.findAllByTackleSort(sortId);
        return ResponseEntity.status(HttpStatus.OK).body(tackles);
    }
}

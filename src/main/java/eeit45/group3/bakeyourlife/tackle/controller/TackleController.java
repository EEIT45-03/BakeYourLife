package eeit45.group3.bakeyourlife.tackle.controller;

import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Tackle")
public class TackleController {

    VenueService venueService;

    @Autowired
    public TackleController(VenueService venueService) {
        this.venueService = venueService;
    }

}

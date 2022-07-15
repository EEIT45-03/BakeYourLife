package eeit45.group3.bakeyourlife.venue.controller;


import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Venue")
public class VenueController {

    VenueService venueService;

    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @GetMapping("/")
    public String viewIndex(Model model){
        model.addAttribute("venues", venueService.findAllVenue());
        return "venue/Introduction";
    }
}

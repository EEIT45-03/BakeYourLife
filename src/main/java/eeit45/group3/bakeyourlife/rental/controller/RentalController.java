package eeit45.group3.bakeyourlife.rental.controller;

import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/Rental")
public class RentalController {

    private RentalService rentalService;

    private VenueService venueService;

    private TackleService tackleService;

    @Autowired
    public RentalController(RentalService rentalService, VenueService venueService, TackleService tackleService) {
        this.rentalService = rentalService;
        this.venueService = venueService;
        this.tackleService = tackleService;
    }

    @GetMapping("/")
    public String viewIndex(){
        return "/rental/Index";
    }

    @GetMapping("/Introduce/Venue/{id}")
    public String viewVenueCommodity(@PathVariable Integer id,
                                Model model) {
        model.addAttribute("venueBean", venueService.findByVenueId(id));
        return "VenueIntroduce";
    }

    @GetMapping("/Introduce/Tackle/{id}")
    public String viewTackleCommodity(@PathVariable Integer id,
                                     Model model) {
        model.addAttribute("tackleBean", tackleService.findByTackleId(id));
        return "TackleIntroduce";
    }


}

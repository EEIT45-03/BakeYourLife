package eeit45.group3.bakeyourlife.rental.controller;

import eeit45.group3.bakeyourlife.rental.dto.VenueRequest;
import eeit45.group3.bakeyourlife.rental.model.Venue;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/admin/Venue")
public class VenueController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/")
    public String viewIndex(Model model) {

        List<Venue> venues = null;

        venues = rentalService.findAllVenue();
        //設置給JSP使用
        model.addAttribute("venues", venues);
        return "/admin/rental/Venue";
    }


    @GetMapping("/CreateVenue")
    public String viewCreateVenue(Model model) {

        model.addAttribute("venue",new Venue());
        return "/admin/rental/CreateVenue";
    }

    @PostMapping("/CreateVenue")
    public String createVenue(@ModelAttribute("venue") Venue venue ) {
        rentalService.createVenue(venue);
        return "redirect:./";
    }



    @GetMapping("/UpdateVenue")
    public String viewUpdateVenue(@RequestParam Integer venueId, Model model) {
        VenueRequest venueRequest = new VenueRequest();
        Venue venue = null;
        if(venueId != null){
            venue = rentalService.findByVenueId(venueId);
        }
        if(venue != null){
            venueRequest.setVenueId(venue.getVenueId());
            venueRequest.setVenueName(venue.getVenueName());
            venueRequest.setPersonMax(venue.getPersonMax());

            model.addAttribute("venueRequest",venueRequest);
            return "/admin/rental/UpdateVenue";
        }
        return null;
    }


    @PostMapping("/UpdateVenue")
    public String updateVenue(@RequestParam Integer venueId, @ModelAttribute("venueRequest") VenueRequest venueRequest) {

        Venue venueDb = rentalService.findByVenueId(venueId);

        if(venueRequest.getVenueName() != null){
            venueDb.setVenueName(venueRequest.getVenueName());
        }
        if(venueRequest.getPersonMax() != null){
            venueDb.setPersonMax(venueRequest.getPersonMax());
        }

        rentalService.updateVenue(venueDb);
        return "redirect:./";
    }


    @RequestMapping("/DeleteVenue")
    public ResponseEntity<?> deleteVenue(@RequestParam Integer venueId) {
        rentalService.deleteVenue(venueId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

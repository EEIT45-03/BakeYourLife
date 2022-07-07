package eeit45.group3.bakeyourlife.rental.controller;

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
public class AdminVenueController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/")
    public String viewIndex(@RequestParam(value = "vName", required = false) String venueName,
                            Model model) {
        List<String> venueNames = rentalService.findAllVenueName();
        model.addAttribute("venueNames", venueNames);


        if( venueName != null && venueName.length()>0){
            model.addAttribute("venues", rentalService.findByVenueName(venueName));
        } else{
            model.addAttribute("venues", rentalService.findAllVenue());
        }
        //設置給JSP使用

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
        Venue venue = new Venue();
        if(venueId != null){
            venue = rentalService.findByVenueId(venueId);
        }
        if(venue != null){

            model.addAttribute("venueRequest",venue);
            return "/admin/rental/UpdateVenue";
        }
        return null;
    }


    @PostMapping("/UpdateVenue")
    public String updateVenue(@RequestParam Integer venueId, @ModelAttribute("venueRequest") Venue venue) {

        Venue venueDb = rentalService.findByVenueId(venueId);

        if(venue.getVenueName() != null){
            venueDb.setVenueName(venue.getVenueName());
        }
        if(venue.getPersonMax() != null){
            venueDb.setPersonMax(venue.getPersonMax());
        }
        if(venue.getHrPrice() != null){
            venueDb.setHrPrice(venue.getHrPrice());
        }
        if(venue.getNotes() != null){
            venueDb.setNotes(venue.getNotes());
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

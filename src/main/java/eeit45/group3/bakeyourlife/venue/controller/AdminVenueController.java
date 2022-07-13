package eeit45.group3.bakeyourlife.venue.controller;

import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static eeit45.group3.bakeyourlife.utils.ImgurService.updateByMultipartFile;

@Controller
@RequestMapping(path = "/admin/Venue")
public class AdminVenueController {

    @Autowired
    private VenueService venueService;


    @GetMapping("/")
    public String viewIndex(@RequestParam(value = "vName", required = false) String venueName,
                            Model model) {
        List<String> venueNames = venueService.findAllVenueName();
        model.addAttribute("venueNames", venueNames);


        if( venueName != null && venueName.length()>0){
            model.addAttribute("venues", venueService.findByVenueName(venueName));
        } else{
            model.addAttribute("venues", venueService.findAllVenue());
        }
        //設置給JSP使用

        return "/admin/venue/Venue";
    }


    @GetMapping("/CreateVenue")
    public String viewCreateVenue(Model model) {

        model.addAttribute("venue",new Venue());
        return "/admin/venue/CreateVenue";
    }

    @PostMapping("/CreateVenue")
    public String createVenue(@ModelAttribute("venue") Venue venue,
                              @RequestParam(value = "venueImage", required = false) MultipartFile file,
                              BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return "/admin/venue/Venue";
        }
        venue.setPicture(updateByMultipartFile(file).getLink());
        venueService.createVenue(venue);
        return "redirect:./";
    }



    @GetMapping("/UpdateVenue")
    public String viewUpdateVenue(@RequestParam Integer venueId, Model model) {
        Venue venue = new Venue();
        if(venueId != null){
            venue = venueService.findByVenueId(venueId);
        }
        if(venue != null){

            model.addAttribute("venueRequest",venue);
            return "/admin/venue/UpdateVenue";
        }
        return null;
    }


    @PostMapping("/UpdateVenue")
    public String updateVenue(@RequestParam Integer venueId,
                              @ModelAttribute("venueRequest") Venue venue,
                              @RequestParam(value = "venueImage", required = false) MultipartFile file,
                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return  "/admin/venue/Venue";
        }

        venue.setPicture(updateByMultipartFile(file).getLink());
        venueService.updateVenue(venue);
        return "redirect:./";
    }


    @RequestMapping("/DeleteVenue")
    public ResponseEntity<?> deleteVenue(@RequestParam Integer venueId) {
        venueService.deleteVenue(venueId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

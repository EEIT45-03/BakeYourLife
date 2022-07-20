package eeit45.group3.bakeyourlife.venue.controller;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.venue.dto.text;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.model.VenuePicList;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;

import static eeit45.group3.bakeyourlife.utils.ImgurService.updateByMultipartFile;

@Controller
@RequestMapping(path = "/admin/Venue")
public class AdminVenueController {

    @Autowired
    private VenueService venueService;


    @GetMapping("/")
    public String viewIndex(@RequestParam(value = "vName", required = false) String venueName,
                            @RequestParam(value = "vSort", required = false) String sort,
                            Model model) {
        model.addAttribute("venueNames", venueService.findAllVenueName());
        model.addAttribute("sorts", venueService.findAllVenueSort());

        if ((venueName!=null && venueName.length()>0) && (sort!=null && sort.length()>0)){
            //設置給JSP使用
            model.addAttribute("venues", venueService.findAllByVenueNameAndVenueSort(venueName, sort));
        } else if ((sort!=null && sort.length()>0)){
            //設置給JSP使用
            model.addAttribute("venues", venueService.findAllByVenueSort(sort));
        } else if(venueName!=null && venueName.length()>0) {
            //設置給JSP使用
            model.addAttribute("venues", venueService.findByVenueName(venueName));
        } else {
            //設置給JSP使用
            model.addAttribute("venues", venueService.findAllVenue());
        }

        //設置給JSP使用
        return "/admin/venue/Venue";
    }


    @GetMapping("/CreateVenue")
    public String viewCreateVenue(Model model) {
        model.addAttribute("sorts", venueService.findAllVenueSort());
        model.addAttribute("venue",new Venue());
        return "/admin/venue/CreateVenue";
    }

    @ResponseBody
    @RequestMapping(value = "/CreateVenue",method = RequestMethod.POST)
    public void createVenue(@RequestBody @Valid Map<String,Object> venue) {
        Venue venueDb = null;
        if (venue != null){
            venueDb = venueService.createVenue(venue);
        }
        if (venue.get("base64")!=null){
            venueService.createVenuePicList(venueDb,(List<String>)venue.get("base64"));
        }
    }



    @GetMapping("/UpdateVenue")
    public String viewUpdateVenue(@RequestParam Integer venueId, Model model) {
        model.addAttribute("sorts", venueService.findAllVenueSort());
        Venue venue = null;
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
                              @RequestParam(value = "venueImage", required = false) MultipartFile[] file,
                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return  "/admin/venue/Venue";
        }

//        venue.setPicture(updateByMultipartFile(file).getLink());
        venueService.updateVenue(venue);

        return "redirect:./";
    }


    @RequestMapping("/DeleteVenue")
    public ResponseEntity<?> deleteVenue(@RequestParam Integer venueId) {
        venueService.deleteVenue(venueId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

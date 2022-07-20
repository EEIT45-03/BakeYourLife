package eeit45.group3.bakeyourlife.rental.controller;


import eeit45.group3.bakeyourlife.rental.dto.VenueListRequest;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.rental.utils.AvailableQuantity;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.text.ParseException;
import java.util.Date;
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



//    @GetMapping("/TopThree/Venue")
//    public ResponseEntity<List<Venue>> getVenueTopThree() {
//        List<Venue> venues = venueService.findByVenueTopThree();
//        return ResponseEntity.status(HttpStatus.OK).body(venues);
//    }

    @GetMapping("/VenueSelect/{name}/{date}")
    public ResponseEntity<List<AvailableQuantity>> getVenueSelect(@PathVariable String name,
                                                                  @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
                                                 ){
        List<AvailableQuantity> list = rentalService.getVenueSelect(name,date);
        if(list != null){
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
        return null;
    }

    @GetMapping("/show/{id}/venuelist")
    public ResponseEntity<List<VenueList>> getShowVenuelist(@PathVariable Integer id){
        List<VenueList> lists = rentalService.findVenueListByFK_RentalId(id);
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }
    @GetMapping("/show/{id}/tacklelist")
    public ResponseEntity<List<TackleList>> getShowTacklelist(@PathVariable Integer id){
        List<TackleList> lists = rentalService.findTackleListByFK_RentalId(id);
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }

    @ResponseBody
    @RequestMapping(value = "/User/inertVenueList",method = RequestMethod.POST)
    public void insertVenueList(@RequestBody @Valid VenueListRequest venueListRequest,
                                Principal principal) throws ParseException {
        if (venueListRequest!=null){
           VenueList venueList = rentalService.createVenueList(venueListRequest,principal);
//           rentalService.updateRentalPic(venueList.getRental());
            Rental rental = venueList.getRental();
            Long sum = rentalService.findVenueListPriceSumByRental(rental);
            if(sum != null){
                rental.setTotal(sum.intValue());
            } else {
                rental.setTotal(0);
            }
            rentalService.updateRental(rental);
        }
//        return "{}";
    }

}
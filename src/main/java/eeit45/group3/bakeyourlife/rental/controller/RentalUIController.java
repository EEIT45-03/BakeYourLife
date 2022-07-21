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

    @GetMapping("User/rental/show/{id}/venuelist")
    public ResponseEntity<List<VenueList>> getShowVenuelist(@PathVariable Integer id){
        List<VenueList> lists = rentalService.findVenueListByFK_RentalId(id);
        return ResponseEntity.status(HttpStatus.OK).body(lists);
    }
    @GetMapping("User/rental/show/{id}/tacklelist")
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

//    @RequestMapping("User/rental/Rental/{rentalId}")
//    public ResponseEntity<List<VenueList>> findVenueListByRental(@RequestParam Integer rentalId) {
//        List<VenueList> lists = rentalService.findVenueListByFK_RentalId(rentalId);
//        return ResponseEntity.status(HttpStatus.OK).body(lists);
//    }
    @RequestMapping("User/rental/DeleteRental")
    public ResponseEntity<?> deleteRental(@RequestParam Integer rentalId) {
        rentalService.deleteRental(rentalId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "/User/rental/orderRental/{rentalId}",method = RequestMethod.POST)
    public ResponseEntity<Rental> orderRental(@PathVariable Integer rentalId) {
        Rental rental = rentalService.findByRentalId(rentalId);
        rental.setState("待付款");
        rental.setRentalDate(new Date());

        Rental r = rentalService.updateRental(rental);
        return ResponseEntity.status(HttpStatus.OK).body(r);
    }


    @GetMapping("/User/rental/UpdateVenueList")
    public String viewUpdateVenueList(@RequestParam Integer venueListId, Model model) {
        List<Venue> venues = null;
        VenueList venueList = null;
        if(venueListId != null) {
            venueList = rentalService.findByVenueListId(venueListId);
        }
        if(venueList != null) {
            venues = venueService.findByOrderByVenueNameAsc();
            model.addAttribute("venues",venues);
            model.addAttribute("venueListRequest", venueList);
            return "/rental/UpdateVenueList";
        }
        return null;
    }


    @PostMapping("/User/rental/UpdateVenueList")
    public String updateVenueList(@RequestParam Integer venueListId, @ModelAttribute("venueListRequest") VenueList venueList) {
        Rental rental = rentalService.findByRentalNo(venueList.getRental().getRentalNo());
        venueList.setRental(rental);
        rentalService.updateVenueList(venueList);

        Long sum = rentalService.findVenueListPriceSumByRental(rental);
        if(sum != null){
            rental.setTotal(sum.intValue());
        } else {
            rental.setTotal(0);
        }
        rentalService.updateRental(rental);

        return "redirect:./update/"+rental.getRentalId();
    }

    @RequestMapping("/User/rental/DeleteVenueList")
    public ResponseEntity<?> deleteVenueList(@RequestParam Integer venueListId) {
        VenueList venueList = rentalService.findByVenueListId(venueListId);
        Rental rental = venueList.getRental();

        rentalService.deleteVenueList(venueListId);

        Long sum = rentalService.findVenueListPriceSumByRental(rental);

        if(sum != null){
            rental.setTotal(sum.intValue());
        } else {
            rental.setTotal(0);
        }
        rentalService.updateRental(rental);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
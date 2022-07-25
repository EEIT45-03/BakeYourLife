package eeit45.group3.bakeyourlife.rental.controller;


import eeit45.group3.bakeyourlife.email.service.EmailService;
import eeit45.group3.bakeyourlife.email.service.EmailServiceImpl;
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

import javax.mail.MessagingException;
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

    EmailService emailService;

    @Autowired
    public RentalUIController(RentalService rentalService, VenueService venueService, TackleService tackleService, EmailService emailService) {
        this.rentalService = rentalService;
        this.venueService = venueService;
        this.tackleService = tackleService;
        this.emailService = emailService;
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

            Rental rental = venueList.getRental();
            Long sum = rentalService.findVenueListPriceSumByRental(rental);
            if(sum != null){
                rental.setTotal(sum.intValue());
            } else {
                rental.setTotal(0);
            }
            rentalService.updateRental(rental);
        }
    }

    @RequestMapping("User/rental/DeleteRental")
    public ResponseEntity<?> deleteRental(@RequestParam Integer rentalId) {
        Rental r = rentalService.findByRentalId(rentalId);
        r.setState("已退單");
        rentalService.updateRental(r);

        String email = r.getUser().getEmail();
        try {
            emailService.sendRentalMail(email, "[Bake Your Life 烘焙材料網] 租借單取消通知",r,"rentalCancel");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "/User/rental/orderRental/{rentalId}",method = RequestMethod.POST)
    public ResponseEntity<Rental> orderRental(@PathVariable Integer rentalId) {
        Rental rental = rentalService.findByRentalId(rentalId);
        rental.setState("待付款");
        rental.setRentalDate(new Date());
        Rental r = rentalService.updateRental(rental);
        String email = r.getUser().getEmail();
        if("場地".equals(r.getType())){
            try {
                emailService.sendRentalMail(email, "[Bake Your Life 烘焙材料網] 租借單下單成功通知",r,"rentaldown_v");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
//        } else if ("器具".equals(r.getType())) {
//            try {
//                emailService.sendRentalMail(email, "[Bake Your Life 烘焙材料網] 租借單下單成功通知",r,"rentaldown_t");
//            } catch (MessagingException e) {
//                throw new RuntimeException(e);
//            }
        }

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
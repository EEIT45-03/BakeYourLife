
package eeit45.group3.bakeyourlife.rental.controller;

import eeit45.group3.bakeyourlife.rental.dto.TackleListRequest;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.rental.utils.AvailableQuantity;
import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/Rental")
public class AdminRentalController {

    private RentalService rentalService;

    private VenueService venueService;

    private TackleService tackleService;

    private UserService userService;


    /*================================租借單=========================================*/

    @Autowired
    public AdminRentalController(RentalService rentalService, VenueService venueService, TackleService tackleService, UserService userService) {
        this.rentalService = rentalService;
        this.venueService = venueService;
        this.tackleService = tackleService;
        this.userService = userService;
    }



    @GetMapping("/")
    public String viewIndex(@RequestParam(value = "listType", required = false) String listType,
                            @RequestParam(value = "rNo", required = false) String rNo,
                            @RequestParam(value = "user1", required = false) String user1,
                            Model model) {


        List<Rental> rentals = null;

        List<String> select = new ArrayList<String>();
        if(listType != null && listType.length()>0){
            select.add(listType);
        } else{
            listType = null;
        }
        if(rNo != null && rNo.length()>0){
            select.add(rNo);
        }
        if(user1 != null && user1.length()>0){
            select.add(user1);
        }

        if(select.size() == 1){
            if(select.get(0) == listType){
                rentals = rentalService.findAllByType(listType);
            } else if (select.get(0) == rNo) {
                rentals = rentalService.findAllByRentalNoStartingWith(rNo);
            } else if (select.get(0) == user1){
                rentals = rentalService.findAllByUser(Integer.valueOf(user1));
            }
        } else if(select.size() == 2){
            if(listType == null || listType.length()<=0){
                rentals = rentalService.findAllByUserAndRentalNoStartingWith(Integer.valueOf(user1), rNo);
            } else if (rNo == null || rNo.length()<=0) {
                rentals = rentalService.findAllByUserAndType(Integer.valueOf(user1) ,listType);
            } else if (user1 == null || user1.length()<=0){
                rentals = rentalService.findAllByTypeAndRentalNoStartingWith(listType, rNo);
            }
        } else if (select.size() == 3) {
            rentals = rentalService.findAllByUserAndTypeAndRentalNoStartingWith(Integer.valueOf(user1),listType,rNo);
        } else {
            rentals = rentalService.findAllRental();
        }

        //設置給前端使用
        model.addAttribute("users", userService.findAll());
        model.addAttribute("rentals", rentals);
        return "admin/rental/Rental";
    }


    @GetMapping("/CreateRental")
    public String viewCreateRental(Model model) {
        Rental rental = rentalService.createRentalNoRequest();
        List<User> users = userService.findAll();

        //表單綁定用
        model.addAttribute("users",users);
        model.addAttribute("rental",rental);
        return "admin/rental/CreateRental";
    }

    @PostMapping("CreateRental")
    public String createRental(@ModelAttribute("rental") Rental rental ) {
        rentalService.updateProduceNo(rental.getRentalNo());
        rentalService.createRental(rental);
        return "redirect:./";
    }


    @GetMapping(path = {"/UpdateRental",})
    public String viewUpdateRental(@RequestParam Integer rentalId, Model model) {
        Rental rental = null;
        List<User> users = userService.findAll();

        if(rentalId != null) {
            rental = rentalService.findByRentalId(rentalId);
        }
        if(rental != null) {
            model.addAttribute("users",users);
            model.addAttribute("rentalRequest", rental);
            return "admin/rental/UpdateRental";
        }
        return null;
    }


    @PostMapping("/UpdateRental")
    public String updateRental(@RequestParam Integer rentalId, @ModelAttribute("rentalRequest") Rental rental) {
        rentalService.updateRental(rental);
        return "redirect:./";
    }

    @RequestMapping("/DeleteRental")
    public ResponseEntity<?> deleteRental(@RequestParam Integer rentalId) {
        rentalService.deleteRental(rentalId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /*================================器具清單=========================================*/


    @GetMapping("/CreateTackleList/{id}")
    public String viewCreateTackleList(@PathVariable Integer id, Model model) {

        Rental rental = null;
        List<Tackle> tackles = null;

        if(id != null) {
            rental = rentalService.findByRentalId(id);
        }
        if(rental != null) {
            TackleListRequest tackleListRequest = rentalService.createTackleListNoRequest(rental);
            tackles = tackleService.findAllTackle();
            model.addAttribute("tackles",tackles);
            model.addAttribute("tackleList", tackleListRequest);
            return "admin/rental/CreateTackleList";
        }
        return null;
    }

    @PostMapping("CreateTackleList")
    public String createTackleList(@RequestParam Integer FK_rentalId, @ModelAttribute("tackleList") TackleListRequest tackleList ) {
//        Rental rental = rentalService.findByRentalId(FK_rentalId);

        rentalService.updateProduceNo(tackleList.getTackleListNo());
        rentalService.createTackleList(tackleList);

//        Long sum = rentalService.findTackleListPriceSumByRental(rental);
//        if(sum != null){
//            rental.setTotal(sum.intValue());
//        }else{
//            rental.setTotal(0);
//        }
//        rentalService.updateRental(rental);
        return "redirect:./";
    }


    @GetMapping("/UpdateTackleList")
    public String viewUpdateTackleList(@RequestParam Integer tackleListId, Model model) {

        TackleList tackleList = null;

        if(tackleListId != null) {
            tackleList = rentalService.findByTackleListId(tackleListId);
        }
        if(tackleList != null) {

//            List<Tackle> tackles = tackleService.findAllTackle();
//            model.addAttribute("tackles",tackles);
            model.addAttribute("tackleListRequest", tackleList);
            return "admin/rental/UpdateTackleList";
        }
        return null;
    }


    @PostMapping("/UpdateTackleList")
    public String updateTackleList(@RequestParam Integer tackleListId, @ModelAttribute("rentalRequest") TackleList tackleList) {
//        Rental rental = rentalService.findByRentalNo(tackleList.getRental().getRentalNo());
//        tackleList.setRental(rental);

        rentalService.updateTackleList(tackleList);

//        Long sum = rentalService.findTackleListPriceSumByRental(rental);
//        if(sum != null){
//            rental.setTotal(sum.intValue());
//        }else{
//            rental.setTotal(0);
//        }
//        rentalService.updateRental(rental);

        return "redirect:./";
    }


    @RequestMapping("/DeleteTackleList")
    public ResponseEntity<?> deleteTackleList(@RequestParam Integer tackleListId) {
//        TackleList tackleList = rentalService.findByTackleListId(tackleListId);
//        Rental rental = tackleList.getRental();

        rentalService.deleteTackleList(tackleListId);

//        Long sum = rentalService.findTackleListPriceSumByRental(rental);
//        if(sum != null) {
//            rental.setTotal(sum.intValue());
//        } else {
//            rental.setTotal(0);
//        }
//
//        rentalService.updateRental(rental);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /*================================場地清單=========================================*/
    @GetMapping("/CreateVenueList")
    public String viewCreateVenueList(@RequestParam Integer FK_rentalId, Model model) {
        Rental rental = null;

        if(FK_rentalId != null) {
            rental = rentalService.findByRentalId(FK_rentalId);
        }
        if(rental != null) {
            VenueList venueList = rentalService.createVenueListNoRequest(rental);
            List<Venue> venues = venueService.findByOrderByVenueNameAsc();
            model.addAttribute("venues",venues);
            model.addAttribute("venueList", venueList);
            return "admin/rental/CreateVenueList";
        }
        return null;
    }

    @PostMapping("CreateVenueList")
    public String createVenueList(@RequestParam Integer FK_rentalId, @ModelAttribute("venueList") VenueList venueList ) {
        rentalService.updateProduceNo(venueList.getVenueListNo());
        Rental rental = rentalService.findByRentalId(FK_rentalId);
        venueList.setRental(rental);
        rentalService.createVenueList(venueList);

        Long sum = rentalService.findVenueListPriceSumByRental(rental);
        if(sum != null){
            rental.setTotal(sum.intValue());
        } else {
            rental.setTotal(0);
        }
        rentalService.updateRental(rental);
        return "redirect:./";
    }

    @GetMapping("/UpdateVenueList")
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
            return "admin/rental/UpdateVenueList";
        }
        return null;
    }


    @PostMapping("/UpdateVenueList")
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
        return "redirect:./";
    }


    @RequestMapping("/DeleteVenueList")
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

    @GetMapping("/RentalChart")
    public String viewAdminRentalSale(Model model) {
        Long sum = rentalService.findByRentalTotalSum();
        model.addAttribute( "sum", sum);
        Long count = rentalService.findByRentalCount();
        model.addAttribute( "count", count);
        AvailableQuantity count1 = rentalService.findVenuePersonMax();
        model.addAttribute( "count1", count1);
            return "admin/rental/RentalChart";
    }

}

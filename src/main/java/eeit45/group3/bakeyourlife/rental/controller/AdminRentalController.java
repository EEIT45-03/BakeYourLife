
package eeit45.group3.bakeyourlife.rental.controller;

import eeit45.group3.bakeyourlife.rental.dto.RentalRequest;
import eeit45.group3.bakeyourlife.rental.dto.TackleListRequest;
import eeit45.group3.bakeyourlife.rental.dto.VenueListRequest;
import eeit45.group3.bakeyourlife.rental.model.*;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/admin/Rental")
public class AdminRentalController {

    private RentalService rentalService;

    private UserService userService;


    /*================================租借單=========================================*/

    @Autowired
    public AdminRentalController(RentalService rentalService, UserService userService) {
        this.rentalService = rentalService;
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
        model.addAttribute("rentals", rentals);
        return "admin/rental/Rental";
    }


    @GetMapping("/CreateRental")
    public String viewCreateRental(Model model) {
        RentalRequest rentalRequest = rentalService.createRentalRequest();
        List<User> users = userService.findAll();

        //表單綁定用
        model.addAttribute("users",users);
        model.addAttribute("rental",rentalRequest);
        return "admin/rental/CreateRental";
    }

    @PostMapping("CreateRental")
    public String createRental(@ModelAttribute("rental") RentalRequest rentalRequest ) {
        rentalService.updateProduceNo(rentalRequest.getRentalNo());
        rentalService.createRental(rentalRequest);
        return "redirect:./";
    }


    @GetMapping("/UpdateRental")
    public String viewUpdateRental(@RequestParam Integer rentalId, Model model) {
        RentalRequest rentalRequest = new RentalRequest();
        Rental rental = null;
        List<User> users = userService.findAll();


        if(rentalId != null) {
            rental = rentalService.findByRentalId(rentalId);
        }
        if(rental != null) {
            rentalRequest.setRentalId(rentalId);
            rentalRequest.setRentalNo(rental.getRentalNo());
            rentalRequest.setListType(rental.getType());
            rentalRequest.setUserId(rental.getUser().getUserId());
            rentalRequest.setTotal(rental.getTotal());
            rentalRequest.setState(rental.getState());

            model.addAttribute("users",users);
            model.addAttribute("rentalRequest", rentalRequest);
            return "admin/rental/UpdateRental";
        }
        return null;
    }


    @PostMapping("/UpdateRental")
    public String updateRental(@RequestParam Integer rentalId, @ModelAttribute("rentalRequest") RentalRequest rentalRequest) {

        Rental rentalDb = rentalService.findByRentalId(rentalId);

        if(rentalRequest.getUserId() != null) {
            User user = userService.findByUserId(rentalRequest.getUserId());
            rentalDb.setUser(user);
        }
        if(rentalRequest.getTotal() != null) {
            rentalDb.setTotal(rentalRequest.getTotal());
        }
        if(rentalRequest.getState() != null) {
            rentalDb.setState(rentalRequest.getState());
        }
        rentalService.updateRental(rentalDb);

        return "redirect:./";
    }


    @RequestMapping("/DeleteRental")
    public ResponseEntity<?> deleteRental(@RequestParam Integer rentalId) {
        rentalService.deleteRental(rentalId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /*================================器具清單=========================================*/


    @GetMapping("/CreateTackleList")
    public String viewCreateTackleList(@RequestParam Integer FK_rentalId, Model model) {

        Rental rental = null;
        List<Tackle> tackles = null;

        if(FK_rentalId != null) {
            rental = rentalService.findByRentalId(FK_rentalId);
        }
        if(rental != null) {
            TackleListRequest tackleListRequest = rentalService.createTackleListRequest(rental);
            tackles = rentalService.findAllTackle();
            model.addAttribute("tackles",tackles);
            model.addAttribute("tackleList", tackleListRequest);
            return "admin/rental/CreateTackleList";
        }
        return null;
    }

    @PostMapping("CreateTackleList")
    public String createTackleList(@RequestParam Integer FK_rentalId, @ModelAttribute("tackleList") TackleListRequest tackleListRequest ) {
        rentalService.updateProduceNo(tackleListRequest.getTackleListNo());
        rentalService.createTackleList(FK_rentalId,tackleListRequest);
        Rental rental = rentalService.findByRentalId(FK_rentalId);
        Long sum = rentalService.findTackleListPriceSumByRental(rental);
        rental.setTotal(sum.intValue());
        rentalService.updateRental(rental);
        return "redirect:./";
    }


    @GetMapping("/UpdateTackleList")
    public String viewUpdateTackleList(@RequestParam Integer tackleListId, Model model) {
        TackleListRequest tackleListRequest = new TackleListRequest();

        List<Tackle> tackles = null;
        TackleList tackleList = null;

        if(tackleListId != null) {
            tackleList = rentalService.findByTackleListId(tackleListId);
        }
        if(tackleList != null) {
            tackleListRequest.setTackleListId(tackleList.getTackleListId());
            tackleListRequest.setTackleListNo(tackleList.getTackleListNo());
            tackleListRequest.setLendDate(tackleList.getLendDate());
            tackleListRequest.setEndDate(tackleList.getEndDate());
            tackleListRequest.setReturnDate(tackleList.getReturnDate());
            tackleListRequest.setQuantity(tackleList.getQuantity());
            tackleListRequest.setPrice(tackleList.getPrice());
            tackleListRequest.setTackleId(tackleList.getTackle().getTackleId());
            tackleListRequest.setRental(tackleList.getRental());

            tackles = rentalService.findAllTackle();
            model.addAttribute("tackles",tackles);
            model.addAttribute("tackleListRequest", tackleListRequest);
            return "admin/rental/UpdateTackleList";
        }
        return null;
    }


    @PostMapping("/UpdateTackleList")
    public String updateTackleList(@RequestParam Integer tackleListId, @ModelAttribute("rentalRequest") TackleListRequest tackleListRequest) {

        TackleList tackleListDb = rentalService.findByTackleListId(tackleListId);

        if(tackleListRequest.getTackleId() != null) {
            Tackle tackle = rentalService.findByTackleId(tackleListRequest.getTackleId());
            tackleListDb.setTackle(tackle);
        }
        if(tackleListRequest.getLendDate() != null) {
            tackleListDb.setLendDate(tackleListRequest.getLendDate());
        }
        if(tackleListRequest.getEndDate() != null) {
            tackleListDb.setEndDate(tackleListRequest.getEndDate());
        }
        if(tackleListRequest.getReturnDate() != null) {
            tackleListDb.setReturnDate(tackleListRequest.getReturnDate());
        }
        if(tackleListRequest.getQuantity() != null) {
            tackleListDb.setQuantity(tackleListRequest.getQuantity());
        }
        if(tackleListRequest.getPrice() != null) {
            tackleListDb.setPrice(tackleListRequest.getPrice());
        }
        rentalService.updateTackleList(tackleListDb);
        Long sum = rentalService.findTackleListPriceSumByRental(tackleListDb.getRental());
        Rental rental = rentalService.findByRentalId(tackleListDb.getRental().getRentalId());
        rental.setTotal(sum.intValue());
        rentalService.updateRental(rental);

        return "redirect:./";
    }


    @RequestMapping("/DeleteTackleList")
    public ResponseEntity<?> deleteTackleList(@RequestParam Integer tackleListId) {
        rentalService.deleteTackleList(tackleListId);
        TackleList tackleList = rentalService.findByTackleListId(tackleListId);
        Rental rental = tackleList.getRental();
        Long sum = rentalService.findVenueListPriceSumByRental(rental);
        rental.setTotal(sum.intValue());
        rentalService.updateRental(rental);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /*================================場地清單=========================================*/
    @GetMapping("/CreateVenueList")
    public String viewCreateVenueList(@RequestParam Integer FK_rentalId, Model model) {
        Rental rental = null;
        List<Venue> venues = null;
        if(FK_rentalId != null) {
            rental = rentalService.findByRentalId(FK_rentalId);
        }
        if(rental != null) {
            VenueListRequest venueListRequest = rentalService.createVenueListRequest(rental);
            venues = rentalService.findByOrderByVenueNameAsc();
            model.addAttribute("venues",venues);
            model.addAttribute("venueList", venueListRequest);
            return "admin/rental/CreateVenueList";
        }
        return null;
    }

    @PostMapping("CreateVenueList")
    public String createVenueList(@RequestParam Integer FK_rentalId, @ModelAttribute("venueList") VenueListRequest venueListRequest ) {
        rentalService.updateProduceNo(venueListRequest.getVenueListNo());
        rentalService.createVenueList(FK_rentalId,venueListRequest);
        Rental rental = rentalService.findByRentalId(FK_rentalId);
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
        VenueListRequest venueListRequest = new VenueListRequest();
        List<Venue> venues = null;
        VenueList venueList = null;
        if(venueListId != null) {
            venueList = rentalService.findByVenueListId(venueListId);
        }
        if(venueList != null) {
            venueListRequest.setVenueListId(venueList.getVenueListId());
            venueListRequest.setVenueListNo(venueList.getVenueListNo());
            venueListRequest.setLendTime(venueList.getLendTime());
            venueListRequest.setEndTime(venueList.getEndTime());
            venueListRequest.setIngredients(venueList.getIngredients());
            venueListRequest.setPerson(venueList.getPerson());
            venueListRequest.setPrice(venueList.getPrice());
            venueListRequest.setVenue(venueList.getVenue());
            venueListRequest.setRental(venueList.getRental());

            venues = rentalService.findByOrderByVenueNameAsc();
            model.addAttribute("venues",venues);
            model.addAttribute("venueListRequest", venueListRequest);
            return "admin/rental/UpdateVenueList";
        }
        return null;
    }


    @PostMapping("/UpdateVenueList")
    public String updateVenueList(@RequestParam Integer venueListId, @ModelAttribute("venueListRequest") VenueListRequest venueListRequest) {

        VenueList venueListDb = rentalService.findByVenueListId(venueListId);

        if(venueListRequest.getVenue().getVenueId() != null) {
            Venue venue = rentalService.findByVenueId(venueListRequest.getVenue().getVenueId());
            venueListDb.setVenue(venue);
        }
        if(venueListRequest.getLendTime() != null) {
            venueListDb.setLendTime(venueListRequest.getLendTime());
        }
        if(venueListRequest.getEndTime() != null) {
            venueListDb.setEndTime(venueListRequest.getEndTime());
        }
        if(venueListRequest.getIngredients() != null) {
            venueListDb.setIngredients(venueListRequest.getIngredients());
        }
        if(venueListRequest.getPerson() != null) {
            venueListDb.setPerson(venueListRequest.getPerson());
        }
        if(venueListRequest.getPrice() != null) {
            venueListDb.setPrice(venueListRequest.getPrice());
        }

        rentalService.updateVenueList(venueListDb);
        Rental rental = rentalService.findByRentalId(venueListDb.getRental().getRentalId());
        Long sum = rentalService.findVenueListPriceSumByRental(rental);
        rental.setTotal(sum.intValue());
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

//	@ModelAttribute
//	public void resource(Model m){
//		List<User> users = userService.findAll();
//		m.addAttribute("users",users);
//	}

}

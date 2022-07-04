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

import java.util.List;

@Controller
@RequestMapping(path = "/admin/Rental")
public class AdminRentalController {

    private RentalService rentalService;

    private UserService userService;

    @Autowired
    public AdminRentalController(RentalService rentalService, UserService userService) {
        this.rentalService = rentalService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String viewIndex(@RequestParam(value = "listType", required = false) String listType,
                            Model model) {

        List<Rental> rentals = null;
        System.out.println(listType);
        if (listType != null) {
            rentals = rentalService.findAllByType(listType);
        } else {
            rentals = rentalService.findAllRental();
        }

        //設置給JSP使用
        model.addAttribute("rentals", rentals);
        return "admin/rental/Rental";
    }

    /*================================租借單=========================================*/

    @GetMapping("/CreateRental")
    public String viewCreateRental(Model model) {
        List<User> users = userService.findAll();
        RentalRequest rentalRequest = new RentalRequest();
        rentalRequest.setTotal(0);
        //表單綁定用
        model.addAttribute("users", users);
        model.addAttribute("rental", rentalRequest);
        return "admin/rental/CreateRental";
    }

    @PostMapping("CreateRental")
    public String createRental(@ModelAttribute("rental") RentalRequest rentalRequest) {
        rentalService.createRental(rentalRequest);
        return "redirect:./";
    }


    @GetMapping("/UpdateRental")
    public String viewUpdateRental(@RequestParam Integer rentalId, Model model) {
        RentalRequest rentalRequest = new RentalRequest();
        Rental rental = null;
        List<User> users = userService.findAll();


        if (rentalId != null) {
            rental = rentalService.findByRentalId(rentalId);
        }
        if (rental != null) {
            rentalRequest.setRentalId(rental.getRentalId());
            rentalRequest.setRentalNo(rental.getRentalNo());
            rentalRequest.setListType(rental.getType());
            rentalRequest.setUserId(rental.getUser().getUserId());
            rentalRequest.setTotal(rental.getTotal());

            model.addAttribute("users", users);
            model.addAttribute("rentalRequest", rentalRequest);
            return "admin/rental/UpdateRental";
        }
        return null;
    }


    @PostMapping("/UpdateRental")
    public String updateRental(@RequestParam Integer rentalId, @ModelAttribute("rentalRequest") RentalRequest rentalRequest) {

        Rental rentalDb = rentalService.findByRentalId(rentalId);

        if (rentalRequest.getUserId() != null) {
            User user = userService.findByUserId(rentalRequest.getUserId());
            rentalDb.setUser(user);
        }
        if (rentalRequest.getTotal() != null) {
            rentalDb.setTotal(rentalRequest.getTotal());
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

        if (FK_rentalId != null) {
            rental = rentalService.findByRentalId(FK_rentalId);

        }
        if (rental != null) {
            tackles = rentalService.findAllTackle();
            model.addAttribute("tackles", tackles);
            model.addAttribute("tackleList", new TackleListRequest(rental));
            return "admin/rental/CreateTackleList";
        }
        return null;
    }

    @PostMapping("CreateTackleList")
    public String createTackleList(@RequestParam Integer FK_rentalId, @ModelAttribute("tackleList") TackleListRequest tackleListRequest) {
        rentalService.createTackleList(FK_rentalId, tackleListRequest);
        return "redirect:./";
    }


    @GetMapping("/UpdateTackleList")
    public String viewUpdateTackleList(@RequestParam Integer tackleListId, Model model) {
        TackleListRequest tackleListRequest = new TackleListRequest();

        List<Tackle> tackles = null;
        TackleList tackleList = null;

        if (tackleListId != null) {
            tackleList = rentalService.findByTackleListId(tackleListId);
        }
        if (tackleList != null) {
            tackleListRequest.setTackleListId(tackleList.getTackleListId());
            tackleListRequest.setTackleListNo(tackleList.getTackleListNo());
            tackleListRequest.setLendDate(tackleList.getLendDate());
            tackleListRequest.setEndDate(tackleList.getEndDate());
            tackleListRequest.setReturnDate(tackleList.getReturnDate());
            tackleListRequest.setQuantity(tackleList.getQuantity());
            tackleListRequest.setPrice(tackleList.getPrice());
            tackleListRequest.setState(tackleList.getState());
            tackleListRequest.setTackleId(tackleList.getTackle().getTackleId());
            tackleListRequest.setRental(tackleList.getRental());

            tackles = rentalService.findAllTackle();
            model.addAttribute("tackles", tackles);
            model.addAttribute("tackleListRequest", tackleListRequest);
            return "admin/rental/UpdateTackleList";
        }
        return null;
    }


    @PostMapping("/UpdateTackleList")
    public String updateTackleList(@RequestParam Integer tackleListId, @ModelAttribute("rentalRequest") TackleListRequest tackleListRequest) {

        TackleList tackleListDb = rentalService.findByTackleListId(tackleListId);

        if (tackleListRequest.getTackleId() != null) {
            Tackle tackle = rentalService.findByTackleId(tackleListRequest.getTackleId());
            tackleListDb.setTackle(tackle);
        }
        if (tackleListRequest.getLendDate() != null) {
            tackleListDb.setLendDate(tackleListRequest.getLendDate());
        }
        if (tackleListRequest.getEndDate() != null) {
            tackleListDb.setEndDate(tackleListRequest.getEndDate());
        }
        if (tackleListRequest.getReturnDate() != null) {
            tackleListDb.setReturnDate(tackleListRequest.getReturnDate());
        }
        if (tackleListRequest.getQuantity() != null) {
            tackleListDb.setQuantity(tackleListRequest.getQuantity());
        }
        if (tackleListRequest.getPrice() != null) {
            tackleListDb.setPrice(tackleListRequest.getPrice());
        }
        if (tackleListRequest.getState() != null) {
            tackleListDb.setState(tackleListRequest.getState());
        }
        rentalService.updateTackleList(tackleListDb);

        return "redirect:./";
    }


    @RequestMapping("/DeleteTackleList")
    public ResponseEntity<?> deleteTackleList(@RequestParam Integer tackleListId) {
        rentalService.deleteTackleList(tackleListId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /*================================場地清單=========================================*/
    @GetMapping("/CreateVenueList")
    public String viewCreateVenueList(@RequestParam Integer FK_rentalId, Model model) {
        Rental rental = null;
        List<Venue> venues = null;
        if (FK_rentalId != null) {
            rental = rentalService.findByRentalId(FK_rentalId);
        }
        if (rental != null) {
            venues = rentalService.findAllVenue();
            model.addAttribute("venues", venues);
            model.addAttribute("venueList", new VenueListRequest(rental));
            return "admin/rental/CreateVenueList";
        }
        return null;
    }

    @PostMapping("CreateVenueList")
    public String createVenueList(@RequestParam Integer FK_rentalId, @ModelAttribute("venueList") VenueListRequest venueListRequest) {
        rentalService.createVenueList(FK_rentalId, venueListRequest);
        return "redirect:./";
    }

    @GetMapping("/UpdateVenueList")
    public String viewUpdateVenueList(@RequestParam Integer venueListId, Model model) {
        VenueListRequest venueListRequest = new VenueListRequest();
        List<Venue> venues = null;
        VenueList venueList = null;
        if (venueListId != null) {
            venueList = rentalService.findByVenueListId(venueListId);
        }
        if (venueList != null) {
            venueListRequest.setVenueListId(venueList.getVenueListId());
            venueListRequest.setVenueListNo(venueList.getVenueListNo());
            venueListRequest.setLendTime(venueList.getLendTime());
            venueListRequest.setEndTime(venueList.getEndTime());
            venueListRequest.setIngredients(venueList.getIngredients());
            venueListRequest.setPerson(venueList.getPerson());
            venueListRequest.setPrice(venueList.getPrice());
            venueListRequest.setVenue(venueList.getVenue());
            venueListRequest.setRental(venueList.getRental());

            venues = rentalService.findAllVenue();
            model.addAttribute("venues", venues);
            model.addAttribute("venueListRequest", venueListRequest);
            return "admin/rental/UpdateVenueList";
        }
        return null;
    }


    @PostMapping("/UpdateVenueList")
    public String updateVenueList(@RequestParam Integer venueListId, @ModelAttribute("venueListRequest") VenueListRequest venueListRequest) {

        VenueList venueListDb = rentalService.findByVenueListId(venueListId);

        if (venueListRequest.getVenueId() != null) {
            Venue venue = rentalService.findByVenueId(venueListRequest.getVenueId());
            venueListDb.setVenue(venue);
        }
        if (venueListRequest.getLendTime() != null) {
            venueListDb.setLendTime(venueListRequest.getLendTime());
        }
        if (venueListRequest.getEndTime() != null) {
            venueListDb.setEndTime(venueListRequest.getEndTime());
        }
        if (venueListRequest.getIngredients() != null) {
            venueListDb.setIngredients(venueListRequest.getIngredients());
        }
        if (venueListRequest.getPerson() != null) {
            venueListDb.setPerson(venueListRequest.getPerson());
        }
        if (venueListRequest.getPrice() != null) {
            venueListDb.setPrice(venueListRequest.getPrice());
        }

        rentalService.updateVenueList(venueListDb);

        return "redirect:./";
    }


    @RequestMapping("/DeleteVenueList")
    public ResponseEntity<?> deleteVenueList(@RequestParam Integer venueListId) {
        rentalService.deleteVenueList(venueListId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

//	@ModelAttribute
//	public void resource(Model m){
//		List<User> users = userService.findAll();
//		m.addAttribute("users",users);
//	}
//
}

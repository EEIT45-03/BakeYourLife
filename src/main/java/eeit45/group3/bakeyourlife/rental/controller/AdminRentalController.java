package eeit45.group3.bakeyourlife.rental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eeit45.group3.bakeyourlife.rental.dto.RentalRequest;
import eeit45.group3.bakeyourlife.rental.dto.TackleListRequest;
import eeit45.group3.bakeyourlife.rental.dto.VenueListRequest;
import eeit45.group3.bakeyourlife.rental.model.Classroom;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.model.Tackle;
import eeit45.group3.bakeyourlife.rental.model.TackleList;
import eeit45.group3.bakeyourlife.rental.model.VenueList;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.user.model.User;

@Controller
@RequestMapping(path = "/Rental")
public class AdminRentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/")
    public String viewIndex(Model model) {

        List<Rental> rentals = null;

        rentals = rentalService.findAllByRental();
        //設置給JSP使用
        model.addAttribute("rentals", rentals);
        return "rental/Rental";
    }

    /*================================租借單=========================================*/

    @GetMapping("/CreateRental")
    public String viewCreateRental(Model model) {
        //表單綁定用
        model.addAttribute("rental", new RentalRequest());
        return "rental/CreateRental";
    }

    @PostMapping("CreateRental")
    public String createRental(@ModelAttribute("rental") RentalRequest rentalRequest) {
        rentalService.createRental(rentalRequest);
        return "redirect:./";
    }


    @GetMapping("/CreateTackleList")
    public String viewCreateTackleList(@RequestParam Integer FK_rentalId, Model model) {
        Rental rental = null;
        if (FK_rentalId != null) {
            rental = rentalService.findByRentalId(FK_rentalId);
        }
        if (rental != null) {
            model.addAttribute("tackleList", new TackleListRequest(rental));
            return "rental/CreateTackleList";
        }
        return null;
    }

    @PostMapping("CreateTackleList")
    public String createTackleList(@RequestParam Integer FK_rentalId, @ModelAttribute("tackleList") TackleListRequest tackleListRequest) {
        rentalService.createTackleList(FK_rentalId, tackleListRequest);
        return "redirect:./";
    }

    @GetMapping("/CreateVenueList")
    public String viewCreateVenueList(@RequestParam Integer FK_rentalId, Model model) {
        Rental rental = null;
        if (FK_rentalId != null) {
            rental = rentalService.findByRentalId(FK_rentalId);
        }
        if (rental != null) {
            model.addAttribute("venueList", new VenueListRequest(rental));
            return "rental/CreateVenueList";
        }
        return null;
    }

    @PostMapping("CreateVenueList")
    public String createVenueList(@RequestParam Integer FK_rentalId, @ModelAttribute("venueList") VenueListRequest venueListRequest) {
        rentalService.createVenueList(FK_rentalId, venueListRequest);
        return "redirect:./";
    }

    @GetMapping("/UpdateRental")
    public String viewUpdateRental(@RequestParam Integer rentalId, Model model) {
        RentalRequest rentalRequest = new RentalRequest();
        Rental rental = null;
        if (rentalId != null) {
            rental = rentalService.findByRentalId(rentalId);
        }
        if (rental != null) {
            rentalRequest.setUserId(rental.getUser().getUserId());
            rentalRequest.setTotal(rental.getTotal());

            model.addAttribute("rental", rental);
            model.addAttribute("rentalRequest", rentalRequest);
            return "rental/UpdateRental";
        }
        return null;
    }


    @PostMapping("/UpdateRental")
    public String updateRental(@RequestParam Integer rentalId, @ModelAttribute("rentalRequest") RentalRequest rentalRequest) {

        Rental rentalDb = rentalService.findByRentalId(rentalId);

        if (rentalRequest.getUserId() != null) {
            User user = rentalService.findByUserId(rentalRequest.getUserId());
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


    @GetMapping("/UpdateTackleList")
    public String viewUpdateTackleList(@RequestParam Integer tackleListId, Model model) {
        TackleListRequest tackleListRequest = new TackleListRequest();
        TackleList tackleList = null;
        if (tackleListId != null) {
            tackleList = rentalService.findByTackleListId(tackleListId);
        }
        if (tackleList != null) {
            tackleListRequest.setLendTime(tackleList.getLendTime());
            tackleListRequest.setReturnTime(tackleList.getReturnTime());
            tackleListRequest.setQuantity(tackleList.getQuantity());
            tackleListRequest.setPrice(tackleList.getPrice());
            tackleListRequest.setTackleName(tackleList.getTackle().getTackleName());


            model.addAttribute("tackleList", tackleList);
            model.addAttribute("tackleListRequest", tackleListRequest);
            return "rental/UpdateTackleList";
        }
        return null;
    }


    @PostMapping("/UpdateTackleList")
    public String updateTackleList(@RequestParam Integer tackleListId, @ModelAttribute("rentalRequest") TackleListRequest tackleListRequest) {

        TackleList tackleListDb = rentalService.findByTackleListId(tackleListId);

        if (tackleListRequest.getTackleName() != null) {
            Tackle tackle = rentalService.findByTackleName(tackleListRequest.getTackleName());
            tackleListDb.setTackle(tackle);
        }
        if (tackleListRequest.getLendTime() != null) {
            tackleListDb.setLendTime(tackleListRequest.getLendTime());
        }
        if (tackleListRequest.getReturnTime() != null) {
            tackleListDb.setReturnTime(tackleListRequest.getReturnTime());
        }
        if (tackleListRequest.getQuantity() != null) {
            tackleListDb.setQuantity(tackleListRequest.getQuantity());
        }
        if (tackleListRequest.getPrice() != null) {
            tackleListDb.setPrice(tackleListRequest.getPrice());
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

    @GetMapping("/UpdateVenueList")
    public String viewUpdateVenueList(@RequestParam Integer venueListId, Model model) {
        VenueListRequest venueListRequest = new VenueListRequest();
        VenueList venueList = null;
        if (venueListId != null) {
            venueList = rentalService.findByVenueListId(venueListId);
        }
        if (venueList != null) {
            venueListRequest.setLendTime(venueList.getLendTime());
            venueListRequest.setReturnTime(venueList.getReturnTime());
            venueListRequest.setPerson(venueList.getPerson());
            venueListRequest.setPrice(venueList.getPrice());
            venueListRequest.setClassName(venueList.getClassroom().getClassName());


            model.addAttribute("venueList", venueList);
            model.addAttribute("venueListRequest", venueListRequest);
            return "rental/UpdateVenueList";
        }
        return null;
    }


    @PostMapping("/UpdateVenueList")
    public String updateVenueList(@RequestParam Integer venueListId, @ModelAttribute("venueListRequest") VenueListRequest venueListRequest) {

        VenueList venueListDb = rentalService.findByVenueListId(venueListId);

        if (venueListRequest.getClassName() != null) {
            Classroom room = rentalService.findByClassName(venueListRequest.getClassName());
            venueListDb.setClassroom(room);
        }
        if (venueListRequest.getLendTime() != null) {
            venueListDb.setLendTime(venueListRequest.getLendTime());
        }
        if (venueListRequest.getReturnTime() != null) {
            venueListDb.setReturnTime(venueListRequest.getReturnTime());
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

}

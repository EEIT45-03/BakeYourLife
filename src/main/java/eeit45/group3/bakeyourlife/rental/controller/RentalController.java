package eeit45.group3.bakeyourlife.rental.controller;

import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping
//@RequestMapping(path = "/Rental")
public class RentalController {

    private RentalService rentalService;

    private VenueService venueService;

    private TackleService tackleService;

    private UserService userService;

    @Autowired
    public RentalController(RentalService rentalService, VenueService venueService, TackleService tackleService,UserService userService) {
        this.rentalService = rentalService;
        this.venueService = venueService;
        this.tackleService = tackleService;
        this.userService = userService;
    }

    @GetMapping("/Rental/")
    public String viewIndex(){
        return "/rental/Index";
    }

    @GetMapping("/Rental/Introduce/Venue/{id}")
    public String viewVenueCommodity(@PathVariable Integer id,
                                Model model) {
        model.addAttribute("venueBean", venueService.findByVenueId(id));
        return "/rental/VenueIntroduce";
    }

    @GetMapping("/Rental/Introduce/Tackle/{id}")
    public String viewTackleCommodity(@PathVariable Integer id,
                                     Model model) {
        model.addAttribute("tackleBean", tackleService.findByTackleId(id));
        return "/rental/TackleIntroduce";
    }

    @GetMapping("/Rental/Venue")
    public String viewRental() {
        return "/rental/RentalVenue";
    }

    @GetMapping("/Rental/Tackle")
    public String viewRTackle() {
        return "/rental/RentalTackle";
    }

    @GetMapping("/User/rental/")
    public String viewUserRentalAll(Model m, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        m.addAttribute("rentals", rentalService.findAllRentalByUser(user));
        return "/rental/MyRental";
    }

    @GetMapping("/User/rental/noorder")
    public String viewUserRentalNoorder(Model m,Principal principal) {
        User user = userService.findByUsername(principal.getName());
        m.addAttribute("rentals", rentalService.findAllByStateAndUser("未下單",user));
        return "/rental/MyRental";
    }


    @GetMapping("/User/rental/waitpay")
    public String viewUserRentalWaitpay(Model m,Principal principal) {
        User user = userService.findByUsername(principal.getName());
        m.addAttribute("rentals", rentalService.findAllByStateAndUser("待付款",user));
        return "/rental/MyRental";
    }

    @GetMapping("/User/rental/alreadypay")
    public String viewUserRentalAlreadypay(Model m,Principal principal) {
        User user = userService.findByUsername(principal.getName());
        m.addAttribute("rentals", rentalService.findAllByStateAndUser("已付款",user));
        return "/rental/MyRental";
    }

    @GetMapping("/User/rental/update/{id}")
    public String viewUserRentalUpdate(@PathVariable Integer id,
                                           Model m) {
       Rental rental = rentalService.findByRentalId(id);
        m.addAttribute("rental",rental);
        if ("場地".equals(rental.getType())){
            List<Venue> venues = venueService.findByOrderByVenueNameAsc();
            m.addAttribute("venues",venues);
            m.addAttribute("lists", rentalService.findVenueListByFK_RentalId(id));
        } else if ("器具".equals(rental.getType())){

            List<Tackle> tackles = tackleService.findAllTackle();
            m.addAttribute("tackles",tackles);
            m.addAttribute("lists", rentalService.findTackleListByFK_RentalId(id));
        }
        return "/rental/RentalUpdate";
    }
}

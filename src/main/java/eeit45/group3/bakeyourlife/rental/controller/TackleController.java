package eeit45.group3.bakeyourlife.rental.controller;

import eeit45.group3.bakeyourlife.rental.dto.TackleRequest;
import eeit45.group3.bakeyourlife.rental.model.Tackle;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(path = "/admin/Tackle")
public class TackleController {

    @Autowired
    private RentalService rentalService;

    @GetMapping("/")
    public String viewIndex(Model model) {

        List<Tackle> tackles = null;

        tackles = rentalService.findAllTackle();
        //設置給JSP使用
        model.addAttribute("tackles", tackles);
        return "/admin/rental/Tackle";
    }


    @GetMapping("/CreateTackle")
    public String viewCreateTackle(Model model) {

        model.addAttribute("tackle",new Tackle());
        return "/admin/rental/CreateTackle";
    }

    @PostMapping("/CreateTackle")
    public String createTackle(@ModelAttribute("tackle") Tackle tackle ) {
        rentalService.createTackle(tackle);
        return "redirect:./";
    }

    @GetMapping("/UpdateTackle")
    public String viewUpdateTackle(@RequestParam Integer tackleId, Model model) {
        Tackle tackle = null;
        TackleRequest tackleRequest = new TackleRequest();
        if(tackleId != null){
            tackle = rentalService.findByTackleId(tackleId);
        }
        if(tackle != null){
            tackleRequest.setTackleId(tackle.getTackleId());
            tackleRequest.setTackleName(tackle.getTackleName());
            tackleRequest.setProductModel(tackle.getProductModel());
            tackleRequest.setSpecification(tackle.getSpecification());
            tackleRequest.setDayPrice(tackle.getDayPrice());
            tackleRequest.setMax(tackle.getMax());

            model.addAttribute("tackleRequest",tackleRequest);
        }

        return "/admin/rental/UpdateTackle";
    }


    @PostMapping("/UpdateTackle")
    public String updateTackle(@RequestParam Integer tackleId, @ModelAttribute("tackleRequest") TackleRequest tackleRequest) {
        Tackle tackleDb = null;
        if(tackleId != null){
            tackleDb = rentalService.findByTackleId(tackleId);
        }
        if(tackleRequest.getTackleName() != null ){
            tackleDb.setTackleName(tackleRequest.getTackleName());
        }
        if(tackleRequest.getProductModel() != null){
            tackleDb.setProductModel(tackleRequest.getProductModel());
        }
        if(tackleRequest.getSpecification() != null){
            tackleDb.setSpecification(tackleRequest.getSpecification());
        }
        if(tackleRequest.getDayPrice() != null){
            tackleDb.setDayPrice(tackleRequest.getDayPrice());
        }
        if(tackleRequest.getMax() != null){
            tackleDb.setMax(tackleRequest.getMax());
        }
        rentalService.updateTackle(tackleDb);

        return "redirect:./";
    }


    @RequestMapping("/DeleteTackle")
    public ResponseEntity<?> deleteTackle(@RequestParam Integer tackleId) {
        rentalService.deleteTackle(tackleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
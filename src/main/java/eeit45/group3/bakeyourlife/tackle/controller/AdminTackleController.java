package eeit45.group3.bakeyourlife.tackle.controller;

import eeit45.group3.bakeyourlife.tackle.model.Tackle;
import eeit45.group3.bakeyourlife.tackle.service.TackleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static eeit45.group3.bakeyourlife.utils.ImgurService.updateByMultipartFile;


@Controller
@RequestMapping(path = "/admin/Tackle")
public class AdminTackleController {

    @Autowired
    private TackleService tackleService;

    @GetMapping("/")
    public String viewIndex(@RequestParam(value = "tName", required = false) String tackleName,
                            @RequestParam(value = "tSort", required = false) String sort,
                            Model model) {
        model.addAttribute("tackleNames", tackleService.findAllTackleName());
        model.addAttribute("sorts", tackleService.findAllTackleSort());


        if ((tackleName!=null && tackleName.length()>0) && (sort!=null && sort.length()>0)){
            //設置給JSP使用
            model.addAttribute("tackles", tackleService.findAllByTackleNameAndTackleSort(tackleName, sort));
        } else if ((sort!=null && sort.length()>0)){
            //設置給JSP使用
            model.addAttribute("tackles", tackleService.findAllByTackleSort(sort));
        } else if(tackleName!=null && tackleName.length()>0) {
            //設置給JSP使用
            model.addAttribute("tackles", tackleService.findByTackleName(tackleName));
        } else {
            //設置給JSP使用
            model.addAttribute("tackles", tackleService.findAllTackle());
        }
        return "/admin/tackle/Tackle";
    }


    @GetMapping("/CreateTackle")
    public String viewCreateTackle(Model model) {
        model.addAttribute("sorts", tackleService.findAllTackleSort());
        model.addAttribute("tackle",new Tackle());
        return "/admin/tackle/CreateTackle";
    }

    @PostMapping("/CreateTackle")
    public String createTackle(@ModelAttribute("tackle") Tackle tackle,
                               @RequestParam(value = "tackleImage", required = false) MultipartFile[] file,
                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return  "/admin/tackle/Tackle";
        }

//        tackle.setPicture(updateByMultipartFile(file).getLink());
        tackleService.createTackle(tackle);
        tackleService.createTacklePicList(tackle.getTackleName(),file);
        return "redirect:./";
    }

    @GetMapping("/UpdateTackle")
    public String viewUpdateTackle(@RequestParam Integer tackleId, Model model) {
        model.addAttribute("sorts", tackleService.findAllTackleSort());
        Tackle tackle = null;
        if(tackleId != null){
            tackle = tackleService.findByTackleId(tackleId);
        }
        if(tackle != null){

            model.addAttribute("tackleRequest",tackle);
        }

        return "/admin/tackle/UpdateTackle";
    }


    @PostMapping("/UpdateTackle")
    public String updateTackle(@RequestParam Integer tackleId,
                               @ModelAttribute("tackleRequest") Tackle tackle,
                               @RequestParam(value = "tackleImage", required = false) MultipartFile file,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return  "/admin/tackle/Tackle";
        }

//        tackle.setPicture(updateByMultipartFile(file).getLink());
        tackleService.updateTackle(tackle);
        return "redirect:./";
    }


    @RequestMapping("/DeleteTackle")
    public ResponseEntity<?> deleteTackle(@RequestParam Integer tackleId) {
        tackleService.deleteTackle(tackleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
package eeit45.group3.bakeyourlife;

import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("/admin")
    public String adminIndex(){
        return "admin/index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/default")
    public String redirect(HttpServletRequest request){
        if(request.isUserInRole("ROLE_ADMIN")){
        return "redirect:/admin";
        }
        return "redirect:/";
    }

    @GetMapping("/")
    public String index(){
        return "/index";
//        return "example/checkout";
    }

}

package eeit45.group3.bakeyourlife.user.controller;

import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.sql.Timestamp;

@Controller
public class UserControllerFront {

    UserService userService;

    @Autowired
    public UserControllerFront(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("SignUp")
    public String viewSignUp(Model model ) {
        model.addAttribute("user", new User());


        return "SignUp";
    }
    @PostMapping("SignUp")
    public String SignUp(User user) {
        MultipartFile productImage = user.getProductImage();
        if(productImage.getSize() == 0){
            String pic = "https://i.imgur.com/gEHJxsi.jpg";
            user.setImageUrl(pic);
        }else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            user.setImageUrl(link);
        }
//        ----------------------------------------------------------
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        user.setRegisterTime(ts);
        user.setAuthority("ROLE_USER");
        userService.save(user);
        return "redirect:login";
    }
    @PostMapping(value = "/CheckUser", produces = "application/json; charset = UTF-8")
    public @ResponseBody boolean checkUser(@RequestParam String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return true;
        }
        return false;
    }
}

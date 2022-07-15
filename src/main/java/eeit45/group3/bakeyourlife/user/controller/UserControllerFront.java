package eeit45.group3.bakeyourlife.user.controller;

import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.sql.Timestamp;

@Controller
public class UserControllerFront {

    UserService userService;

    CustomUserDetails customUserDetails;

    @Autowired
    PasswordEncoder encoder;

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
    @GetMapping("/User/UserData")
    public String viewUser(Principal principal, Model model) {
        if (principal != null) {
            User user = userService.findByUsername(principal.getName());
            if (user.getUserId() != null) {
                model.addAttribute("user", user);
                return "user/UserCenterUpdate";
            }
        }
        return "redirect:/login";
    }

    @PostMapping("/User/UserData")
    public String updateUser(Authentication authentication, @RequestParam(required = false)User password,User user) {

        User userDB = userService.getCurrentUser(authentication);
//        System.out.println("密碼正確:" + encoder.matches(user.getPassword(),userDB.getPassword()));
        MultipartFile productImage = user.getProductImage();
        if (productImage.getSize() == 0) {
            user.setImageUrl(userDB.getImageUrl());
        } else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            user.setImageUrl(link);
        }
//        System.out.println("----------------------------------------");
//        System.out.println(user.getPassword());
        if (user.getPassword() == null){
            user.setPassword(userDB.getPassword());
        }else {
            user.setPassword(encoder.encode(user.getPassword()));
        }

        user.setRegisterTime(userDB.getRegisterTime());
        user.setAuthority(userDB.getAuthority());
        user.setUserId(userDB.getUserId());
        userService.updateUser(user);
        userService.setCurrentUser(authentication,user);
        return "user/UserCenterUpdate";


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

package eeit45.group3.bakeyourlife.user.controller;

import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.sql.Timestamp;

@Controller
public class UserControllerFront {

    UserService userService;
    FarmerService farmerService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    public UserControllerFront(UserService userService,FarmerService farmerService) {

        this.userService = userService;
        this.farmerService = farmerService;

    }

    @GetMapping("SignUp")
    public String viewSignUp(Model model ) {
        model.addAttribute("user", new User());
        return "SignUp";
    }
    @PostMapping("SignUp")
    public String SignUp(Authentication authentication,User user) {
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

    @PostMapping("process_register")
    public String processRegister(User user, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
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
        userService.register(user, getSiteURL(request));
        return "user/register_success";
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (userService.verify(code)) {
            return "user/verify_success";
        } else {
            return "user/verify_fail";
        }
    }


    @GetMapping("FarmerSignUp")
    public String viewFarmerSignUp(Model model ) {
        model.addAttribute("farmer", new Farmer());
        return "FarmerSignUp";
    }
    @PostMapping("FarmerSignUp")
    public String FarmerSignUp(Farmer farmer) {
        MultipartFile productImage = farmer.getProductImage();
        if(productImage.getSize() == 0){
            String pic = "https://i.imgur.com/gEHJxsi.jpg";
            farmer.setImageUrl(pic);
        }else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            farmer.setImageUrl(link);
        }
//        ----------------------------------------------------------
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        farmer.setRegisterTime(ts);
        farmer.setAuthority("ROLE_FARMER");
        farmerService.save(farmer);
        return "redirect:login";
    }
    @PostMapping("process_farmerRegister")
    public String processRegister(Farmer farmer, HttpServletRequest request)
            throws UnsupportedEncodingException, MessagingException {
        MultipartFile productImage = farmer.getProductImage();
        if(productImage.getSize() == 0){
            String pic = "https://i.imgur.com/gEHJxsi.jpg";
            farmer.setImageUrl(pic);
        }else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            farmer.setImageUrl(link);
        }
//        ----------------------------------------------------------
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        farmer.setRegisterTime(ts);
        farmer.setAuthority("ROLE_FARMER");
        farmerService.register(farmer, getSiteURL(request));
        return "user/register_success";
    }
    @GetMapping("/farmerVerify")
    public String verifyFarmer(@Param("code") String code) {
        if (farmerService.verify(code)) {
            return "user/verify_success";
        } else {
            return "user/verify_fail";
        }
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
        Farmer farmer = farmerService.findByUsername(username);
        if (user == null && farmer == null) {
            return true;
        }
        return false;
    }
}

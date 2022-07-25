package eeit45.group3.bakeyourlife.user.controller;

import eeit45.group3.bakeyourlife.user.model.Farmer;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.FarmerService;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
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
    public UserControllerFront(UserService userService, FarmerService farmerService) {

        this.userService = userService;
        this.farmerService = farmerService;

    }

    @GetMapping("SignUp")
    public String viewSignUp(Model model) {
        model.addAttribute("user", new User());
        return "SignUp";
    }
//    @PostMapping("SignUp")
//    public String SignUp(Authentication authentication,User user) {
//        MultipartFile productImage = user.getProductImage();
//        if(productImage.getSize() == 0){
//            String pic = "https://i.imgur.com/gEHJxsi.jpg";
//            user.setImageUrl(pic);
//        }else {
//            String link = ImgurService.updateByMultipartFile(productImage).getLink();
//            user.setImageUrl(link);
//        }
////        ----------------------------------------------------------
//        Timestamp ts = new Timestamp(System.currentTimeMillis());
//        user.setRegisterTime(ts);
//        user.setAuthority("ROLE_USER");
//        userService.save(user);
//
//        return "redirect:login";
//    }

    @PostMapping("process_register")
    public String processRegister(User user)
            throws UnsupportedEncodingException, MessagingException {
        MultipartFile productImage = user.getProductImage();
        if (productImage.getSize() == 0) {
            String pic = "https://i.imgur.com/gEHJxsi.jpg";
            user.setImageUrl(pic);
        } else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            user.setImageUrl(link);
        }
//        ----------------------------------------------------------
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        user.setRegisterTime(ts);
        user.setAuthority("ROLE_USER");
        userService.register(user);
        return "user/register_success";
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
    public String viewFarmerSignUp(Model model) {
        model.addAttribute("farmer", new Farmer());
        return "FarmerSignUp";
    }

    //    @PostMapping("FarmerSignUp")
//    public String FarmerSignUp(Farmer farmer) {
//        MultipartFile productImage = farmer.getProductImage();
//        if(productImage.getSize() == 0){
//            String pic = "https://i.imgur.com/gEHJxsi.jpg";
//            farmer.setImageUrl(pic);
//        }else {
//            String link = ImgurService.updateByMultipartFile(productImage).getLink();
//            farmer.setImageUrl(link);
//        }
////        ----------------------------------------------------------
//        Timestamp ts = new Timestamp(System.currentTimeMillis());
//        farmer.setRegisterTime(ts);
//        farmer.setAuthority("ROLE_FARMER");
//        farmerService.save(farmer);
//        return "redirect:login";
//    }
    @PostMapping("process_farmerRegister")
    public String processRegister(Farmer farmer)
            throws UnsupportedEncodingException, MessagingException {
        MultipartFile productImage = farmer.getProductImage();
        if (productImage.getSize() == 0) {
            String pic = "https://i.imgur.com/gEHJxsi.jpg";
            farmer.setImageUrl(pic);
        } else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            farmer.setImageUrl(link);
        }
//        ----------------------------------------------------------
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        farmer.setRegisterTime(ts);
        farmer.setAuthority("ROLE_FARMER");
        farmerService.register(farmer);
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
    public String viewUser(Principal principal, Model model,Authentication authentication) {
            User user = userService.findByUsername(principal.getName());
            User userOAuth = userService.getCurrentOAuthUser(authentication);
        if (principal != null) {

            if (user != null) {
                model.addAttribute("user", user);
                return "user/UserCenterUpdate";
            } else {
                model.addAttribute("user", userOAuth);
                System.out.println(userOAuth);
                return "user/UserCenterUpdate";

            }

        }
            return "redirect:/login";
    }

    @PostMapping("/User/UserData")
    public String updateUser(Authentication authentication, User user) {

        User userDB = userService.getCurrentUser(authentication);
//        System.out.println("密碼正確:" + encoder.matches(user.getPassword(),userDB.getPassword()));
        MultipartFile productImage = user.getProductImage();
        if (productImage.getSize() == 0) {
            user.setImageUrl(userDB.getImageUrl());
        } else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            user.setImageUrl(link);
        }
//        @RequestParam(required = false)User password
//        if (user.getPassword() == null){
//            user.setPassword(userDB.getPassword());
//        }else {
//            user.setPassword(encoder.encode(user.getPassword()));
//        }
        user.setPassword(userDB.getPassword());
        user.setRegisterTime(userDB.getRegisterTime());
        user.setAuthority(userDB.getAuthority());
        user.setUserId(userDB.getUserId());
        user.setEnabled(userDB.isEnabled());
        userService.updateUser(user);
        userService.setCurrentUser(authentication, user);
        return "user/UserCenterUpdate";

    }

    @GetMapping("/User/Updatepsw")
    public String viewUpdatepsw(Principal principal, Model model,Authentication authentication) {
    User user = userService.findByUsername(principal.getName());
    User userOAuth = userService.getCurrentOAuthUser(authentication);
        if (principal != null) {

        if (user != null) {
            model.addAttribute("user", user);
            return "user/UserUpdatepsw";
        } else {
            model.addAttribute("user", userOAuth);
            System.out.println(userOAuth);
            return "user/UserUpdatepsw";

        }

    }
        return "redirect:/login";
}




    @PostMapping("/User/Updatepsw")
    public String updatepsw(Authentication authentication, User user) {

        User userDB = userService.getCurrentUser(authentication);
//        System.out.println("密碼正確:" + encoder.matches(user.getPassword(),userDB.getPassword()));
        boolean flag = encoder.matches(user.getPassword(), userDB.getPassword());

        if (!flag) {
            return "user/Updatepsw_fail";
        }
        user.setPassword(encoder.encode(user.getNewPassword()));
        user.setUserId(userDB.getUserId());
        user.setImageUrl(userDB.getImageUrl());
        user.setUsername(userDB.getUsername());
        user.setFullName(userDB.getFullName());
        user.setEmail(userDB.getEmail());
        user.setPhone(userDB.getPhone());
        user.setBirth(userDB.getBirth());
        user.setGender(userDB.getGender());
        user.setAddress(userDB.getAddress());
        user.setRegisterTime(userDB.getRegisterTime());
        user.setAuthority(userDB.getAuthority());
        user.setEnabled(userDB.isEnabled());
        userService.updateUser(user);
        return "user/Updatepsw_success";

    }

    //-------------------------------------------------------------------------
    @GetMapping("/User/Findpsw")
    public String viewFindpsw() {
        return "user/UserFindpsw";
    }

    @GetMapping("/User/process_findpsw")
    public String processFindpsw(Principal principal) {
        if (principal != null) {
            User user = userService.findByUsername(principal.getName());
            userService.resetpsw(user);
//            userService.sendfindpswEmail(user);
            return "user/pswReset_start";
        }
        return "redirect:/login";
    }

    @GetMapping("/pswVerify")
    public String pswVerify(@Param("code") String code, Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        if (userService.pswverify(code)) {
            return "user/pswverify_success";
        } else {
            return "user/pswverify_fail";
        }
    }

    @PostMapping("pswReset")
    public String pswReset(Authentication authentication, User user) {
        User userDB = userService.getCurrentUser(authentication);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setUserId(userDB.getUserId());
        user.setImageUrl(userDB.getImageUrl());
        user.setUsername(userDB.getUsername());
        user.setFullName(userDB.getFullName());
        user.setEmail(userDB.getEmail());
        user.setPhone(userDB.getPhone());
        user.setBirth(userDB.getBirth());
        user.setGender(userDB.getGender());
        user.setAddress(userDB.getAddress());
        user.setRegisterTime(userDB.getRegisterTime());
        user.setAuthority(userDB.getAuthority());
        user.setEnabled(userDB.isEnabled());
        userService.updateUser(user);


        return "user/pswReset_success";
    }

    //-----------------------------------------------------------------------------
    @GetMapping("/LoginFindPsw")
    public String viewLoginFindPsw() {
        return "user/login_find_psw";
    }


    @GetMapping("/process_loginFindPsw")
    public String process_loginFindPsw(User user) {
        User userDB = userService.findByEmail(user.getEmail());
        if (userDB.getEmail()!=null) {
            userService.loginresetpsw(userDB);
            return "user/pswReset_start";
        }
            return "redirect:/login";
    }
    @GetMapping("/loginpswVerify")
    public String pswVerify(@Param("code") String code, @Param("email") String email, Model model) {
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);

        if (userService.pswverify(code)) {
            return "user/loginpswverify_success";
        } else {
            return "user/pswverify_fail";
        }
    }
    @PostMapping("loginpswReset")
    public String pswReset(User user) {
        User userDB = userService.findByEmail(user.getEmail());
        user.setPassword(encoder.encode(user.getPassword()));
        user.setUserId(userDB.getUserId());
        user.setImageUrl(userDB.getImageUrl());
        user.setUsername(userDB.getUsername());
        user.setFullName(userDB.getFullName());
        user.setEmail(userDB.getEmail());
        user.setPhone(userDB.getPhone());
        user.setBirth(userDB.getBirth());
        user.setGender(userDB.getGender());
        user.setAddress(userDB.getAddress());
        user.setRegisterTime(userDB.getRegisterTime());
        user.setAuthority(userDB.getAuthority());
        user.setEnabled(userDB.isEnabled());
        userService.updateUser(user);


        return "user/pswReset_success";
    }


    //--------------------------------------------------------------------------------
    @PostMapping(value = "/CheckUser", produces = "application/json; charset = UTF-8")
    public @ResponseBody boolean checkUser(@RequestParam String username) {
        User user = userService.findByUsername(username);
        Farmer farmer = farmerService.findByUsername(username);
        if (user == null && farmer == null) {
            return true;
        }
        return false;
    }
//    private String getSiteURL(HttpServletRequest request) {
//        String siteURL = request.getRequestURL().toString();
//        return siteURL.replace(request.getServletPath(), "");
//    }
}

package eeit45.group3.bakeyourlife.user.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/admin/User")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;

    }

    @GetMapping("/")
    public String viewIndex(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/user/User";
    }

    @GetMapping("CreateUser")
    public String viewCreateUser(Model model) {
        model.addAttribute("user",new User());

        return "admin/user/CreateUser";
    }

    @PostMapping("CreateUser")
    public String createUser(User user) {
        MultipartFile productImage = user.getProductImage();
        if(productImage.getSize() == 0){
        String pic = "https://i.imgur.com/gEHJxsi.jpg";
            user.setImageUrl(pic);
        }else {
        String link = ImgurService.updateByMultipartFile(productImage).getLink();
            user.setImageUrl(link);
        }
//        --------------------------------------------------------------
        String fullname = user.getFullName();
        user.setFullName("管理員-"+fullname);
//        ----------------------------------------------------------
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        user.setRegisterTime(ts);
        user.setAuthority("ROLE_ADMIN");
        userService.save(user);
        return "redirect:./";
    }

    @GetMapping("/UpdateUser")
    public String viewUpdateUser(@RequestParam("userId") Integer userId, Model model) {
        User user = userService.findByUserId(userId);
        model.addAttribute("user", user);

        return "admin/user/UpdateUser";

    }

    @PostMapping("/UpdateUser")
    public String updateUser(@RequestParam("userId")Integer userId, User user) {

        User userDB = userService.findByUserId(userId);
        MultipartFile productImage = user.getProductImage();
        if(productImage.getSize() == 0){
            user.setImageUrl(userDB.getImageUrl());
        }else {
            String link = ImgurService.updateByMultipartFile(productImage).getLink();
            user.setImageUrl(link);
        }
        user.setRegisterTime(userDB.getRegisterTime());
        user.setAuthority(userDB.getAuthority());
        userService.updateUser(user);
        return "redirect:./";
    }

    @RequestMapping("DeleteUser")
    public String deleteUser(@RequestParam Integer userId) {
        userService.deleteByUserId(userId);
        return "redirect:./";

    }

    @PostMapping(value = "/CheckUser", produces = "application/json; charset = UTF-8")
    public @ResponseBody boolean checkUser(@RequestParam String username) {
        User user = userService.findByUsername(username);
        return user == null;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        // java.util.Date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        dateFormat.setLenient(false);
        CustomDateEditor ce = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, ce);
        // java.sql.Date
        DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat2.setLenient(false);
        CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true);
        binder.registerCustomEditor(java.sql.Date.class, ce2);
    }
}



package eeit45.group3.bakeyourlife.user.controller;

import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;

@Controller
public class UserControllerFront {

    UserService userService;

    @Autowired
    public UserControllerFront(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("SignUp")
    public String viewSignUp(Model model) {
        model.addAttribute("user", new User());

        return "SignUp";
    }
    @PostMapping("SignUp")
    public String SignUp(User user) {

        SerialBlob blob = null;
        try {
            MultipartFile productImage = user.getProductImage();
            InputStream is = productImage.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] b = new byte[8192];
            int len = 0;
            while ((len = is.read(b)) != -1) {
                baos.write(b, 0, len);
            }
            blob = new SerialBlob(baos.toByteArray());
            user.setFileName(productImage.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
        }
        user.setUserImage(blob);
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

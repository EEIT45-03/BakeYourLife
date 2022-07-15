package eeit45.group3.bakeyourlife.course.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.model.Register;
import eeit45.group3.bakeyourlife.course.service.CourseService;
import eeit45.group3.bakeyourlife.course.service.ProductService;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class UserCourseController {

    private CourseService courseService;
    private ProductService productService;
    private UserService userService;
    @Autowired
    public UserCourseController(CourseService courseService, ProductService productService, UserService userService) {
        this.courseService = courseService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/Course")
    public String viewIndex(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "course/courseIndex";
    }

    @GetMapping(path = "/Course/CourseDetails")
    public String selectByProductId(@RequestParam(required = false) Long id,Model model) {
        Product product = null;
        if(id != null){
            product = productService.selectProductById(id);
        }
        model.addAttribute("product", product);
        return "course/CourseDetails";
    }

    @GetMapping(path = "/Course/CreateRegister")
    public String viewCreateRegister(Model model) {
        model.addAttribute("register", new Register());
        return "course/CourseRegister";
    }
    @PostMapping("/Course/CreateRegister")
    public String createRegister(@ModelAttribute("register") Register register, BindingResult result) {
        courseService.createRegister(register);
        return "redirect:./";
    }

    @RequestMapping(value = "/Course/CreateRegisterWithId", method = RequestMethod.GET)
    public String viewCreateRegisterWithId(@RequestParam("id") Integer openCourse, Model model,
                                           Authentication authentication) {
        Course course = courseService.findById(openCourse).orElse(null);
        if(authentication == null){
            return "redirect:/login";
        } else{
            User user = userService.getCurrentUser(authentication);
            Register register = new Register();
            register.setCourse(course);
            register.setUser(user);
            model.addAttribute("user",user);
            model.addAttribute("course",course);
            model.addAttribute("register2", register);
            return "course/CourseRegisterWithId";
        }
    }
    @RequestMapping(value = "/Course/CreateRegisterWithId", method = RequestMethod.POST)
    public String createRegisterWithId(@ModelAttribute("register2") Register register, BindingResult result) {
        courseService.createRegisterWithId(register);
        return "redirect:./";
    }

    @GetMapping("/Course")
    public String viewRegisterByUser(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "course/courseIndex";
    }

}

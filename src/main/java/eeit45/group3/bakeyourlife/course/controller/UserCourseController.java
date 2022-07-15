package eeit45.group3.bakeyourlife.course.controller;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.model.Register;
import eeit45.group3.bakeyourlife.course.service.CourseService;
import eeit45.group3.bakeyourlife.course.service.ProductService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/Course/CourseDetails/{id}")
//    public String selectByProductId(@PathVariable("id") Long id){
//        productService.selectProductById(id);
//        return"";
//    }
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

    @GetMapping(path = "/Course/CreateRegisterWithId")
    public String viewCreateRegisterWithId(@RequestParam("id") Integer openCourse, Model model,
                                           Authentication authentication) {
        Course course = courseService.findById(openCourse).orElse(null);
        User user = userService.getCurrentUser(authentication);
        model.addAttribute("user",user);
        model.addAttribute("course",course);
        model.addAttribute("register", new Register());
        return "course/CourseRegisterWithId";
    }
    @PostMapping("/Course/CreateRegisterWithId")
    public String createRegisterWithId(@ModelAttribute("register") Register register, BindingResult result) {
        courseService.createRegister(register);
        return "redirect:./";
    }



}

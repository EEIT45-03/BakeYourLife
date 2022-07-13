package eeit45.group3.bakeyourlife.course.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.model.Register;
import eeit45.group3.bakeyourlife.course.service.CourseService;
import eeit45.group3.bakeyourlife.course.service.ProductService;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class UserCourseController {

    private CourseService courseService;
    private ProductService productService;
    @Autowired
    public UserCourseController(CourseService courseService, ProductService productService) {
        this.courseService = courseService;
        this.productService = productService;
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
        return "course/CourseCheckOut";
    }

}

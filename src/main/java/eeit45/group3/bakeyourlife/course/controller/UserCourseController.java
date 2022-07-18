package eeit45.group3.bakeyourlife.course.controller;

import eeit45.group3.bakeyourlife.article.model.Article;
import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.model.Register;
//import eeit45.group3.bakeyourlife.course.model.Result;
import eeit45.group3.bakeyourlife.course.service.CourseService;
import eeit45.group3.bakeyourlife.course.service.ProductService;
import eeit45.group3.bakeyourlife.email.service.EmailService;
import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.user.model.CustomUserDetails;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import eeit45.group3.bakeyourlife.utils.Image;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class UserCourseController {

    private CourseService courseService;
    private ProductService productService;
    private UserService userService;
    private EmailService emailService;
    @Autowired
    public UserCourseController(CourseService courseService, ProductService productService, UserService userService, EmailService emailService) {
        this.courseService = courseService;
        this.productService = productService;
        this.userService = userService;
        this.emailService = emailService;
    }
    //------------------------------查看-------------------------------------------
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
    //--------------------報名相關--------------------------------------------------------------------
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

    //提交報名表
    @RequestMapping(value = "/User/Course/CreateRegisterWithId", method = RequestMethod.GET)
    public String viewCreateRegisterWithId(@RequestParam("id") Integer openCourse, Model model,
                                           Authentication authentication) {
        Course course = courseService.findById(openCourse).orElse(null);
//        if(authentication == null){
//            return "redirect:/login";
//        } else{
            User user = userService.getCurrentUser(authentication);
            Register register = new Register();
            register.setCourse(course);
            register.setUser(user);
            model.addAttribute("user",user);
            model.addAttribute("course",course);
            model.addAttribute("register2", register);
            return "course/CourseRegisterWithId";
//        }
    }
    @RequestMapping(value = "/User/Course/CreateRegisterWithId", method = RequestMethod.POST)
    public String createRegisterWithId(@ModelAttribute("register2") Register register, BindingResult result) throws MessagingException {
        courseService.createRegisterWithId(register);
        return "redirect:./UserRegister";
    }
    //查看報名
    @GetMapping("/User/Course/UserRegister")
    public String viewRegisterByUser(Authentication authentication, Model model) {
        if(authentication == null){
            return "redirect:/login";
        }
            User user = userService.getCurrentUser(authentication);
            List<Register> userRegister = courseService.findRegisterByUser(user);
            model.addAttribute("userRegister", userRegister);
            return "course/RegisterDetails";
    }
    //取消報名
    @PutMapping("/Course/{registerId}/{state}")
    public ResponseEntity<?> cancelRegister(@PathVariable Integer registerId, @PathVariable Integer state) {
        Register register = null;
        if(registerId !=null) {
          register =  courseService.findByRegisterId(registerId).orElse(null);
        }
        register.setState(state);//0報名成功 變成 1審核中
        courseService.updateRegisterState(register);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

//    //學員上傳結果
//    @GetMapping("/User/Course/AddResult")
//    public String showAddProduct(Model model) {
//        //表單綁定用
//        model.addAttribute("product",new Result());
//        return "/course/CreateResult";
//    }
//
//    @RequestMapping(value = "/User/Course/AddResult", method = RequestMethod.POST)
//    public String saveProduct(
//            @ModelAttribute Product product
//    )
//    {
//        Image image = ImgurService.updateByMultipartFile(product.getFile());
//        image.getLink();
//        System.out.println("圖片連結: " + image.getLink());
//        productService.saveProductToDB(image.getLink(), product.getName(), product.getDescription(), product.getSummary(), product.getPrice());
//        return "redirect:./listProducts";
//    }


}

package eeit45.group3.bakeyourlife.course.controller;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.model.Register;
// import eeit45.group3.bakeyourlife.course.model.Result;
import eeit45.group3.bakeyourlife.course.model.StudentResult;
import eeit45.group3.bakeyourlife.course.service.CourseService;
import eeit45.group3.bakeyourlife.course.service.ProductService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import java.util.List;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserCourseController {

  private CourseService courseService;
  private ProductService productService;
  private UserService userService;
  //    private EmailService emailService;
  @Autowired
  public UserCourseController(
      CourseService courseService, ProductService productService, UserService userService) {
    this.courseService = courseService;
    this.productService = productService;
    this.userService = userService;
    //        this.emailService = emailService;
  }
  // ------------------------------查看-------------------------------------------
  @GetMapping("/Course")
  public String viewIndex(Model model) {
    List<Product> products = productService.getAllProduct();
    model.addAttribute("products", products);
    return "course/courseIndex";
  }

  @GetMapping(path = "/Course/CourseDetails")
  public String selectByProductId(@RequestParam(required = false) Long id, Model model) {
    Product product = null;
    List<StudentResult> studentResultList = null;
    if (id != null) {
      product = productService.selectProductById(id);
      studentResultList = courseService.findStudentReslutByProduct(id);
    }
    model.addAttribute("product", product);
    model.addAttribute("studentResultList", studentResultList);
    model.addAttribute("total", studentResultList.size());
    return "course/CourseDetails";
  }
  // --------------------報名相關--------------------------------------------------------------------
  @GetMapping(path = "/Course/CreateRegister")
  public String viewCreateRegister(Model model) {
    model.addAttribute("register", new Register());
    return "course/CourseRegister";
  }

  @PostMapping("/Course/CreateRegister")
  public String createRegister(
      @ModelAttribute("register") Register register, BindingResult result) {
    courseService.createRegister(register);
    return "redirect:./";
  }

  // 提交報名表
  @RequestMapping(value = "/User/Course/CreateRegisterWithId", method = RequestMethod.GET)
  public String viewCreateRegisterWithId(
      @RequestParam("id") Integer openCourse, Model model, Authentication authentication) {
    Course course = courseService.findById(openCourse).orElse(null);
    //        if(authentication == null){
    //            return "redirect:/login";
    //        } else{
    User user = userService.getCurrentUser(authentication);
    Register register = new Register();
    register.setCourse(course);
    register.setUser(user);
    model.addAttribute("user", user);
    model.addAttribute("course", course);
    model.addAttribute("register2", register);
    return "course/CourseRegisterWithId";
    //        }
  }

  @RequestMapping(value = "/User/Course/CreateRegisterWithId", method = RequestMethod.POST)
  public String createRegisterWithId(
      @ModelAttribute("register2") Register register, BindingResult result)
      throws MessagingException {
    courseService.createRegisterWithId(register);
    return "redirect:./UserRegister";
  }
  // 查看報名
  @GetMapping("/User/Course/UserRegister")
  public String viewRegisterByUser(Authentication authentication, Model model) {
    if (authentication == null) {
      return "redirect:/login";
    }
    User user = userService.getCurrentUser(authentication);
    List<Register> userRegister = courseService.findRegisterByUser(user);
    model.addAttribute("userRegister", userRegister);
    return "course/RegisterDetails";
  }
  // 取消報名
  @PutMapping("/Course/{registerId}/{state}")
  public ResponseEntity<?> cancelRegister(
      @PathVariable Integer registerId, @PathVariable Integer state) {
    Register register = null;
    if (registerId != null) {
      register = courseService.findByRegisterId(registerId).orElse(null);
    }
    register.setState(state); // 0報名成功 變成 1審核中
    courseService.updateRegisterState(register);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/Course2/{registerId}/{state}")
  public String cancelRegisterEmail(@PathVariable Integer registerId, @PathVariable Integer state) {
    Register register = null;
    System.out.println(registerId);
    System.out.println(state);
    System.out.println("----------------------------------------------------------");
    if (registerId != null) {
      register = courseService.findByRegisterId(registerId).orElse(null);
      //            System.out.println(register.getState());
      if (register.getState() == 4 || register == null) {
        //                model.addAttribute("register", register);
        return "course/errorState";
      }
    }

    register.setState(state); // 0報名成功 變成 1審核中
    courseService.updateRegisterState(register);
    return "redirect:/User/Course/UserRegister";

    //        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  // 學員上傳結果
  @GetMapping("/User/Course/AddResult")
  public String viewCreateResult(
      @RequestParam(value = "fk_productId", required = false) Long fk_productId, Model model) {
    Product product = null;
    StudentResult studentResult = null;
    if (fk_productId != null) {
      product = productService.selectProductById(fk_productId);
    }
    if (product != null) {
      studentResult = new StudentResult();
      studentResult.setProduct(product);
    }
    // 表單綁定用
    model.addAttribute("studentResult", studentResult);
    return "course/CreateStudentResult";
  }

  @PostMapping("/User/Course/AddResult")
  public String createResult(
      @RequestParam(value = "fk_productId") Long fk_productId,
      @ModelAttribute StudentResult studentResult,
      Authentication authentication) {
    User user = userService.getCurrentUser(authentication);
    studentResult.setUser(user);
    Product product = productService.selectProductById(fk_productId);
    studentResult.setProduct(product);
    courseService.createStudentResult(studentResult);
    return "redirect:/";
  }

  // 學生作品
  @GetMapping("/Course/StudentResult")
  public String viewIndexStudentResult(Model model) {
    List<StudentResult> studentResultList = courseService.findAllStudentResult();
    model.addAttribute("studentResultList", studentResultList);
    return "course/studentResultList";
  }

  // 學生作品ByProduct
  @GetMapping("/Course/StudentResultByProduct")
  public String viewIndexStudentResultByProduct(@RequestParam Long productId, Model model) {
    List<StudentResult> studentResultList = courseService.findStudentReslutByProduct(productId);
    //        List<StudentResult> studentResultList = courseService.findAllStudentResult();
    model.addAttribute("studentResultList", studentResultList);
    return "course/studentResultList";
  }
}

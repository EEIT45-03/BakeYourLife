package eeit45.group3.bakeyourlife;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @GetMapping("/admin")
  public String adminIndex() {
    return "admin/index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/default")
  public String redirect(HttpServletRequest request) {
    if (request.isUserInRole("ROLE_ADMIN")) {
      return "redirect:/admin";
    } else if (request.isUserInRole("ROLE_FARMER")) {
      return "redirect:/FarmerProductSupplier/";
    } else if (request.isUserInRole("ROLE_USER")) {
      return "redirect:/";
    }
    return "redirect:/";
  }

  @GetMapping("/")
  public String index() {
    return "index";
    //        return "example/checkout";
  }

  @RequestMapping("/welcome")
  public String welcome() {
    return "welcome";
  }
}

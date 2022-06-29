package eeit45.group3.bakeyourlife.user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;

@Controller
@RequestMapping(path = "/admin/User")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String viewIndex(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "user/User";
	}

	@GetMapping("CreateUser")
	public String viewCreateUser() {
		return "user/CreateUser";
	}

	@PostMapping("CreateUser")
	public String createUser(User user) {
		userService.save(user);
		return "redirect:./";
	}

	@GetMapping("/update/{userId}")
	public String viewUpdateUser(@PathVariable("userId") Integer userId, Model model) {
		User user = userService.findByUserId(userId);
		model.addAttribute(user);
		return "user/UpdateUser";

	}

	@PostMapping("/update/{userId}")
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:../";
	}

	@RequestMapping("DeleteUser")
	public String deleteUser(@RequestParam Integer userId) {
		userService.deleteByUserId(userId);
		return "redirect:./";

	}

	@PostMapping(value = "/CheckUser", produces = "application/json; charset = UTF-8")
	public @ResponseBody boolean checkUser(@RequestParam String userName) {
		User user = userService.findByUserName(userName);
		if (user == null) {
			return true;
		}
		return false;
	}
	@GetMapping("/logUser")
	public ResponseEntity<?> getAuth(Principal principal){
		return ResponseEntity.status(HttpStatus.OK).body(principal.getName());
	}

}

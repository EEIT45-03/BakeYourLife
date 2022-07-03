package eeit45.group3.bakeyourlife.course.controller;

import java.util.List;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/admin/Course")
public class OpenCourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public String viewIndex(Model model) {
		
		List<Course> courses = courseService.findAll();

		//設置給jsp使用
		model.addAttribute("courses", courses);
		return "admin/course/Course";
	}
	
	@GetMapping("/CreateCourse")
	public String viewCreateCourse(Model model) {
		//表單綁定用
		model.addAttribute("course",new Course());
		return "admin/course/CreateCourse";
	}
	
	@PostMapping("/CreateCourse")
	public String createOrder(@ModelAttribute("course") Course course, BindingResult result ) {

		courseService.createCourse(course);
		return "redirect:./";
	}


	@RequestMapping("DeleteCourse")
	public String deleteCourse(@RequestParam Integer openCourse) {
		courseService.deleteById(openCourse);
		return "redirect:./";
	}
	
	@GetMapping("/UpdateCourse/{openCourse}")
	public String viewUpdateCourse(@PathVariable Integer openCourse,Model model) {

		Course course = courseService.findById(openCourse).orElse(null);

			model.addAttribute("course",course);
			return "admin/course/UpdateCourse";

	}
	
	@PostMapping("/UpdateCourse/{openCourse}")
	public String updateOrder(Course course) {

		courseService.updateCourse(course);
		return "redirect:../";
	}
}

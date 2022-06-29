package eeit45.group3.bakeyourlife.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import eeit45.group3.bakeyourlife.course.main.Course;
import eeit45.group3.bakeyourlife.course.main.CourseService;

@Controller
@RequestMapping(path = "/Course")
public class OpenCourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public String viewIndex(Model model) {
		
		List<Course> courses = courseService.findAll();
		//設置給jsp使用
		model.addAttribute("courses", courses);
		return "course/Course";
	}
	
	@GetMapping("/CreateCourse")
	public String viewCreateCourse(Model model) {
		//表單綁定用
		model.addAttribute("course",new Course());
		return "course/CreateCourse";
	}
	
	@PostMapping("/CreateCourse")
	public String createOrder(@ModelAttribute("course") Course course, BindingResult result ) {
		
		courseService.createCourse(course);
		return "redirect:./";
	}
	
	@RequestMapping("CourseDelete")
	public String deleteCourse(@RequestParam Integer openCourse) {
		courseService.deleteCourse(openCourse);
		return "redirect:./";
	}
	
	@GetMapping("/UpdateCourse")
	public String viewUpdateCourse(@RequestParam Integer openCourse,Model model) {
		
		Course course = null;
		
			course = courseService.findCourseById(openCourse).orElse(null);

			model.addAttribute("course",course);
			return "course/UpdateCourse";
		
		
	}
	
	@PostMapping("UpdateCourse")
	public String updateOrder(Course course) {
//		Course course =courseService.findCourseById(openCourse).orElse(null);
//		course = courseService.findCourseById(openCourse).orElse(null);
		
		courseService.updateCourse(course);
		return "redirect:./";
	}
}

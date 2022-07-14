package eeit45.group3.bakeyourlife.course.controller;

import java.util.List;
import java.util.Optional;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.CourseTime;
import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.model.Register;
import eeit45.group3.bakeyourlife.course.service.CourseService;
import eeit45.group3.bakeyourlife.rental.dto.TackleListRequest;
import eeit45.group3.bakeyourlife.rental.model.Rental;
import eeit45.group3.bakeyourlife.utils.Image;
import eeit45.group3.bakeyourlife.utils.ImgurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthTabbedPaneUI;


@Controller
@RequestMapping(path = "/admin/Course")
public class AdminCourseController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/")
	public String viewIndex(Model model) {

		List<Course> courses = courseService.findAll();
		model.addAttribute("courses", courses);
		return "admin/course/Course";
	}

	@GetMapping("/CreateCourse")
	public String viewCreateCourse(Model model) {
		model.addAttribute("course", new Course());
		return "admin/course/CreateCourse";
	}

	@PostMapping("/CreateCourse")
	public String createOrder(@ModelAttribute("course") Course course, BindingResult result) {

		courseService.createCourse(course);
		return "redirect:./";
	}


	@RequestMapping("DeleteCourse")
	public String deleteCourse(@RequestParam Integer openCourse) {
		courseService.deleteById(openCourse);
		return "redirect:./";
	}

	@GetMapping("/UpdateCourse/{openCourse}")
	public String viewUpdateCourse(@PathVariable Integer openCourse, Model model) {

		Course course = courseService.findById(openCourse).orElse(null);
		model.addAttribute("course", course);
		return "admin/course/UpdateCourse";

	}

	@PostMapping("/UpdateCourse/{openCourse}")
	public String updateCourse(Course course) {
		courseService.updateCourse(course);
		return "redirect:../";
	}

	//--------CourseTime Controller-------------------------------------------------------------------
	@GetMapping("/CreateCourseTime")
	public String viewCreateCtime(@RequestParam Integer FK_opCourseId, Model model) {

//		Optional<Course> course = null;
		CourseTime courseTime = null;
		Course course = null;
		if (FK_opCourseId != null) {
		course = courseService.findById(FK_opCourseId).orElse(null);
		}
		if (course != null) {
			courseTime = new CourseTime();
			courseTime.setCourse(course);
			//表單綁定用
//			model.addAttribute("course", course);
			model.addAttribute("courseTime", courseTime);
			return "/admin/course/CreateCtime";
		}
		return null;
	}

	@PostMapping("CreateCourseTime")
	public String createCreateCtime(@RequestParam(value = "FK_courseId") Integer FK_opCourseId, @ModelAttribute("courseTime") CourseTime courseTime ) {
//		rentalService.updateProduceNo(tackleListRequest.getTackleListNo());

		Course course = courseService.findById(FK_opCourseId).orElse(null);
		courseTime.setCourse(course);
		courseService.createCourseTime(courseTime);

		return "redirect:./";
	}

	@RequestMapping("DeleteCourseTime")
	public ResponseEntity<?> deleteCtime(@RequestParam Integer ctimeId) {
		courseService.deleteByCtId(ctimeId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	//--------Register Controller-------------------------------------------------------------------
	@GetMapping("/Register")
	public String viewRegisterIndex(Model model) {

		List<Register> registers = courseService.findAllRegister();
		model.addAttribute("registers", registers);
		return "admin/course/CourseRegister";
	}

	@RequestMapping("DeleteRegister")
	public ResponseEntity<?> deleteRegisterById(@RequestParam Integer registerId) {
		courseService.deleteByRegisterId(registerId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/CreateRegister")
	public String viewCreateRegister(Model model) {
		model.addAttribute("register", new Register());
		return "admin/course/CreateCregister";
	}

	@PostMapping("/CreateRegister")
	public String createRegister(@ModelAttribute("register") Register register, BindingResult result) {
		courseService.createRegister(register);
		return "redirect:./Register";
	}

	@GetMapping("/UpdateRegister")
	public String viewUpdateUpdateRegister(@RequestParam Integer registerId, Model model) {
		Register register = courseService.findByRegisterId(registerId).orElse(null);
		model.addAttribute("register", register);
		return "admin/course/UpdateCregister";
	}
//	@PostMapping("/UpdateRegister")
//	public String updateUpdateRegister(Register register) {
//		courseService.updateRegister(register);
//		return "redirect:../";
//	}
	@PostMapping(value = "/UpdateRegister")
	public String saveProduct(@ModelAttribute Register register	)
	{
	courseService.updateRegister(register.getRegisterId(),register.getAttendance(), register.getState(), register.getTotalPrice());
	return "redirect:./Register";
	}

}

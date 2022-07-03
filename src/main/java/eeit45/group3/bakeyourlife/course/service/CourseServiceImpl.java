package eeit45.group3.bakeyourlife.course.service;


import eeit45.group3.bakeyourlife.course.model.Course;
//import eeit45.group3.bakeyourlife.course.model.CourseType;
import eeit45.group3.bakeyourlife.course.repository.CourseRepository;
//import eeit45.group3.bakeyourlife.course.repository.CourseTypeRepository;



import eeit45.group3.bakeyourlife.rental.model.Venue;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {


	CourseRepository courseRepository;

	RentalService rentalService;

//	CourseTypeRepository courseTypeRepository;

	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository, RentalService rentalService) {
		this.courseRepository = courseRepository;
		this.rentalService = rentalService;
	}

	@Override
	public List<Course> findAll() {

		return courseRepository.findAll();

	}

//
//	@Override
//	public List<CourseType> findAllByType() {
//		return courseTypeRepository.findAll();
//	}


	@Override
	public Optional<Course> findById(Integer openCourse) {

		return courseRepository.findById(openCourse);
	}

	@Override
	@Transactional
	public void deleteById(Integer openCourse) {

		courseRepository.deleteById(openCourse);
	}

	@Override
	@Transactional
	public void updateCourse(Course course) {
		Course courseDb = courseRepository.findById(course.getOpenCourse()).orElse(null);
		if(courseDb == null){
			throw new RuntimeException("沒有找到要更新的課程");
		}
		courseRepository.save(course);

}


	@Transactional
	public void createCourse(Course course) {
		Venue venue = rentalService.findByVenueId(course.getRoomId());
		course.setRoom(venue);
		courseRepository.save(course);

	}

}

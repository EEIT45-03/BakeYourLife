package eeit45.group3.bakeyourlife.course.service;


import eeit45.group3.bakeyourlife.course.model.Course;
//import eeit45.group3.bakeyourlife.course.model.CourseType;
import eeit45.group3.bakeyourlife.course.model.CourseType;
import eeit45.group3.bakeyourlife.course.repository.CourseRepository;
//import eeit45.group3.bakeyourlife.course.repository.CourseTypeRepository;


import eeit45.group3.bakeyourlife.course.repository.CourseTypeRepository;
import eeit45.group3.bakeyourlife.venue.model.Venue;
import eeit45.group3.bakeyourlife.rental.service.RentalService;
import eeit45.group3.bakeyourlife.venue.service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CourseServiceImpl implements CourseService {

	CourseRepository courseRepository;

	VenueService venueService;

	CourseTypeRepository courseTypeRepository;

	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository, VenueService venueService, CourseTypeRepository courseTypeRepository) {
		this.courseRepository = courseRepository;
		this.venueService = venueService;
		this.courseTypeRepository = courseTypeRepository;
	}
	//--------Course課程-----------
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

//	@Override
//	public List<Course> findAllByType(Integer courseId) {
////		return courseRepository.findAllByType(courseId);
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
		Venue venue = venueService.findByVenueId(course.getRoomId());
		course.setRoom(venue);
		courseRepository.save(course);

	}

	//--------CourseType課程代號-----------
	@Override
	public List<CourseType> findAllCt() {
		return courseTypeRepository.findAll();
	}

	@Override
	public Optional<CourseType> findByCtId(Integer courseId) {
		return courseTypeRepository.findById(courseId);
	}

	@Override
	public void deleteByCtId(Integer courseId) {courseTypeRepository.deleteById(courseId);}

	@Override
	public void updateCourseType(CourseType courseType) {

		CourseType courseTypeDb = courseTypeRepository.findById(courseType.getCourseId()).orElse(null);
		if(courseTypeDb == null){
			throw new RuntimeException("沒有找到要更新的課程代碼");
		}courseTypeRepository.save(courseType);
	}

	@Override
	public void createCourseType(CourseType courseType) { courseTypeRepository.save(courseType);	}



}

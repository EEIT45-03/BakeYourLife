package eeit45.group3.bakeyourlife.course.service;


import eeit45.group3.bakeyourlife.course.model.Course;
//import eeit45.group3.bakeyourlife.course.model.CourseType;
import eeit45.group3.bakeyourlife.course.model.CourseTime;
import eeit45.group3.bakeyourlife.course.model.CourseType;
import eeit45.group3.bakeyourlife.course.repository.CourseRepository;
//import eeit45.group3.bakeyourlife.course.repository.CourseTypeRepository;


import eeit45.group3.bakeyourlife.course.repository.CourseTimeRepository;
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

	CourseTimeRepository courseTimeRepository;

	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository, VenueService venueService, CourseTimeRepository courseTimeRepository) {
		this.courseRepository = courseRepository;
		this.venueService = venueService;
		this.courseTimeRepository = courseTimeRepository;
	}
	//--------Course課程-----------
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

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

	//--------CourseTime課程代號-----------
	@Override
	public List<CourseTime> findAllCtime() {
		return courseTimeRepository.findAll();
	}

	@Override
	public Optional<CourseTime> findByCtId(Integer ctimeId) {
		return courseTimeRepository.findById(ctimeId);
	}

	@Override
	@Transactional
	public void deleteByCtId(Integer ctimeId) {courseTimeRepository.deleteById(ctimeId);}

	@Override
	@Transactional
	public void updateCourseTime(CourseTime courseTime) {

		CourseTime courseTimeDb = courseTimeRepository.findById(courseTime.getCtimeId()).orElse(null);
		if(courseTimeDb == null){
			throw new RuntimeException("沒有找到要更新的課程代碼");
		}courseTimeRepository.save(courseTime);
	}

	@Override
	@Transactional
	public void createCourseTime(CourseTime courseTime) { courseTimeRepository.save(courseTime);	}




}

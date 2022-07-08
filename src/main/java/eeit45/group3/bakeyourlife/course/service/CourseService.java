package eeit45.group3.bakeyourlife.course.service;


import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.CourseType;
//import eeit45.group3.bakeyourlife.course.model.CourseType;

import java.util.List;
import java.util.Optional;


public interface CourseService {

		//--------Course課程-----------
		//查詢所有開課資料
		List<Course> findAll();
		//查詢所有課程類型
//		List<Course> findAllByType(Integer courseId);
		//用PK找
		Optional<Course> findById(Integer openCourse);
		//用開課編號刪除課程
		void deleteById(Integer openCourse);
		//更新課程
		void updateCourse(Course Course);
		
		//建立課程
		void createCourse(Course Course);

		//--------CourseType課程代號-----------

		//查詢所有開課資料
		List<CourseType> findAllCt();
		//查詢所有課程類型
	//		List<Course> findAllByType(Integer courseId);
		//用PK找
		Optional<CourseType> findByCtId(Integer courseId);
		//用開課編號刪除課程
		void deleteByCtId(Integer courseId);
		//更新課程
		void updateCourseType(CourseType courseType);

		//建立課程
		void createCourseType(CourseType courseType);

}

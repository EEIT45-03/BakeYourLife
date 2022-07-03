package eeit45.group3.bakeyourlife.course.service;


import eeit45.group3.bakeyourlife.course.model.Course;
//import eeit45.group3.bakeyourlife.course.model.CourseType;

import java.util.List;
import java.util.Optional;


public interface CourseService {
	

		//查詢所有開課資料
		List<Course> findAll();

		//查詢所有課程類型
//		List<CourseType> findAllByType();
		
		//用PK找

		Optional<Course> findById(Integer openCourse);

		//用開課編號刪除課程
		void deleteById(Integer openCourse);


//		void deleteCourse(Integer openCourse);

		//更新課程
		void updateCourse(Course Course);
		
		//建立課程
		void createCourse(Course Course);



}

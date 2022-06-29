package eeit45.group3.bakeyourlife.course.main;

import java.util.*;


public interface CourseDao {
	
	//新增
	//void save(Course eeit45.group3.bakeyourlife.course);
	
	//查詢
	List<Course> findAll();
	
	//查詢ID
	Optional<Course> findById(Integer OpenCourse);
	
	//刪除
	void deleteById(Integer OpenCourse);
	
	//更新訂單
	void updateCourse(Course course);
		
	//建立訂單
	void createCourse(Course course);
		
	
}

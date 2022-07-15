package eeit45.group3.bakeyourlife.course.service;


import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.CourseTime;
import eeit45.group3.bakeyourlife.course.model.Register;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.security.core.Authentication;

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
		void updateCourse(Course course);
		
		//建立課程
		void createCourse(Course course);

		//--------CourseTime課程代號-----------

		//查詢所有開課資料
		List<CourseTime> findAllCtime();

		//用PK找
		Optional<CourseTime> findByCtId(Integer ctimeId);
		//用開課編號刪除課程
		void deleteByCtId(Integer courseId);
		//更新課程
		void updateCourseTime(CourseTime courseTime);

		//建立課程
		void createCourseTime(CourseTime courseTime);

		//-----Register--------
		List<Register> findAllRegister();
		List<Register> findRegisterByUser(User user);
		Optional<Register> findByRegisterId(Integer registerId);
		void deleteByRegisterId(Integer registerId);

	    void updateRegister(Integer registerId,Integer attendance,Integer state, Integer totalPrice);
		void createRegister(Register register);
		void createRegisterWithId(Register register);

//		void addAttendanceToOpCourse(Course course);

}

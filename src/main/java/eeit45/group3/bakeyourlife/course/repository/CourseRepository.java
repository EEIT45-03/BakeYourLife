package eeit45.group3.bakeyourlife.course.repository;

import eeit45.group3.bakeyourlife.course.model.Course;
//import eeit45.group3.bakeyourlife.course.model.CourseType;
import eeit45.group3.bakeyourlife.course.model.CourseType;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
//    List<Course> findAllByType(Integer courseId);

}

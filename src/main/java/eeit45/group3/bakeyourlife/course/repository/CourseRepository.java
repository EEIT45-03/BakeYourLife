package eeit45.group3.bakeyourlife.course.repository;

import eeit45.group3.bakeyourlife.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
  //    List<Course> findAllByType(Integer courseId);

}

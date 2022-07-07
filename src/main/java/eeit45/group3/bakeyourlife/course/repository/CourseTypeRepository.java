package eeit45.group3.bakeyourlife.course.repository;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.CourseType;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CourseTypeRepository extends JpaRepository<CourseType, Integer> {

    //查詢所有課程類型


}

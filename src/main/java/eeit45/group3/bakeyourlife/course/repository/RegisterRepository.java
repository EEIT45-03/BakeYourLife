package eeit45.group3.bakeyourlife.course.repository;

import eeit45.group3.bakeyourlife.course.model.Course;
import eeit45.group3.bakeyourlife.course.model.Register;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
    List<Register> findByUser(User user);

    @Query( value = "SELECT sum(r.attendance) FROM course_register r WHERE r.fk_op_course = :course",
            nativeQuery = true)
    Integer getSumAttendanceByCourse (@Param("course") Course course);
    @Query( value = "SELECT sum(attendance) FROM course_register group by course",
            nativeQuery = true)
    List<Register> getSumAttendanceByCourse();
}

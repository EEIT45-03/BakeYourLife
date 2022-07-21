package eeit45.group3.bakeyourlife.course.repository;

import eeit45.group3.bakeyourlife.course.model.Product;
import eeit45.group3.bakeyourlife.course.model.StudentResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface StudentResultRepository extends JpaRepository<StudentResult,Integer> {
    //在課程頁面，顯示學生作品
    List<StudentResult> findByProductId(Long product_id);
}

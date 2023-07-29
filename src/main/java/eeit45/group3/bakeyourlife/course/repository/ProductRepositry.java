package eeit45.group3.bakeyourlife.course.repository;

import eeit45.group3.bakeyourlife.course.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Long> {

  List<Product> findByName(String name);
}

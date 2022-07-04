package eeit45.group3.bakeyourlife.farmerproduct.dao;

import eeit45.group3.bakeyourlife.farmerproduct.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer> {
    ProductComment findByProductCommentId(Integer productCommentId);
}

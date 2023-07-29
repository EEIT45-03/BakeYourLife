package eeit45.group3.bakeyourlife.productcomment.dao;

import eeit45.group3.bakeyourlife.productcomment.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer> {
  ProductComment findByProductCommentId(Integer productCommentId);
}

package eeit45.group3.bakeyourlife.productcomment.service;

import eeit45.group3.bakeyourlife.productcomment.model.ProductComment;

import java.util.List;

public interface ProductCommentService {

    ProductComment findById(Integer productCommentId);

    List<ProductComment> findAll();

    ProductComment create(ProductComment productComment);

    void update(ProductComment productComment);

    void delete(Integer productCommentId);

    boolean existsById(Integer productCommentId);
}

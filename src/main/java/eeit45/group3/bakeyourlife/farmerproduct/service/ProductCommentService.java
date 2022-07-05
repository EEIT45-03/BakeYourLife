package eeit45.group3.bakeyourlife.farmerproduct.service;

import eeit45.group3.bakeyourlife.farmerproduct.model.ProductComment;

import java.util.List;

public interface ProductCommentService {

    ProductComment findById(Integer productCommentId);

    List<ProductComment> findAll();

    ProductComment create(ProductComment productComment);

    void update(ProductComment productComment);

    void delete(Integer productCommentId);

    boolean existsById(Integer productCommentId);
}

package eeit45.group3.bakeyourlife.productcomment.service;


import eeit45.group3.bakeyourlife.productcomment.dao.ProductCommentRepository;
import eeit45.group3.bakeyourlife.productcomment.model.ProductComment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductCommentServiceImpl implements ProductCommentService {

    private ProductCommentRepository productCommentRepository;

    public ProductCommentServiceImpl(ProductCommentRepository productCommentRepository) {
        this.productCommentRepository = productCommentRepository;
    }

    @Override
    public ProductComment findById(Integer productCommentId) {
        return productCommentRepository.findByProductCommentId(productCommentId);
    }

    @Override
    public List<ProductComment> findAll() {
        return productCommentRepository.findAll();
    }

    @Override
    @Transactional
    public ProductComment create(ProductComment productComment) {
        return productCommentRepository.save(productComment);
    }

    @Override
    @Transactional
    public void update(ProductComment productComment) {
        ProductComment productCommentDb = productCommentRepository.findByProductCommentId(productComment.getProductCommentId());
        if (productCommentDb != null) {
            productCommentRepository.save(productComment);
        }
    }


    @Override
    @Transactional
    public void delete(Integer productCommentId) {
        productCommentRepository.deleteById(productCommentId);
    }

    public boolean existsById(Integer productCommentId) {
        return productCommentRepository.existsById(productCommentId);
    }
}

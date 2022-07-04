package eeit45.group3.bakeyourlife.farmerproduct.controller;


import eeit45.group3.bakeyourlife.farmerproduct.model.ProductComment;
import eeit45.group3.bakeyourlife.farmerproduct.service.ProductCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductCommentController {

    ProductCommentService productCommentService;

    //@Autowired
    public ProductCommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    @GetMapping("/ProductComments")
    public ResponseEntity<List<ProductComment>> getComments() {
        List<ProductComment> productComments = productCommentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productComments);
    }

    @PostMapping("/ProductComments")
    public ResponseEntity<ProductComment> createComment(@RequestBody @Valid ProductComment productComment) {
        ProductComment productCommentDb = productCommentService.create(productComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCommentDb);
    }

    @PutMapping("/ProductComments/{id}")
    public ResponseEntity<ProductComment> updateCoupon(@PathVariable Integer id,
                                                       @RequestBody @Valid ProductComment productComment) {

        if (!productCommentService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productComment.setProductCommentId(id);
        productCommentService.update(productComment);

        return ResponseEntity.status(HttpStatus.OK).body(productComment);
    }

    @DeleteMapping("/ProductComments/{id}")
    public ResponseEntity<?> deleteCoupon(@PathVariable Integer id) {
        productCommentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

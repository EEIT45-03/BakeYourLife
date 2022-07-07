package eeit45.group3.bakeyourlife.farmerproduct.controller;


import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.model.ProductComment;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.farmerproduct.service.ProductCommentService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class ProductCommentController {

    ProductCommentService productCommentService;
    UserService userService;
    FarmerProductService farmerProductService;

    //@Autowired


    public ProductCommentController(ProductCommentService productCommentService, UserService userService, FarmerProductService farmerProductService) {
        this.productCommentService = productCommentService;
        this.userService = userService;
        this.farmerProductService = farmerProductService;
    }

    @GetMapping("/ProductComments")
    public ResponseEntity<List<ProductComment>> getComments() {
        List<ProductComment> productCommentList = productCommentService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productCommentList);
    }

    @PostMapping("/ProductComments/{userid}/{productid}")
    public ResponseEntity<ProductComment> createComment(@PathVariable Integer userid, @PathVariable Integer productid, @RequestBody @Valid ProductComment productComment) {

        User user = userService.findByUserId(userid);
        FarmerProductBean farmerProductBean = farmerProductService.findByFarmerProductId(productid);
        if (user != null && farmerProductBean != null) {
            productComment.setUser(user);
            productComment.setFarmerProductBean(farmerProductBean);
        }
        Date date = new Date();
        productComment.setTime(date);
        ProductComment productCommentDb = productCommentService.create(productComment);
        return ResponseEntity.status(HttpStatus.CREATED).body(productCommentDb);
    }

    @PutMapping("/ProductComments/{id}")
    public ResponseEntity<ProductComment> updateComment(@PathVariable Integer id,
                                                        @RequestBody @Valid ProductComment productComment) {

        if (!productCommentService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        ProductComment productCommentDb = productCommentService.findById(id);
        productCommentDb.setStar(productComment.getStar());
        productCommentDb.setCommentContent(productComment.getCommentContent());
        productCommentDb.setTime(new Date());

        productComment.setProductCommentId(id);
        productCommentService.update(productCommentDb);


//        ProductComment productCommentDb = productCommentService.findById(id);
        FarmerProductBean farmerProductBeanDb = productCommentDb.getFarmerProductBean();
        farmerProductBeanDb.getProductCommentList().remove(productCommentDb);
        farmerProductService.update(farmerProductBeanDb);


        return ResponseEntity.status(HttpStatus.OK).body(productCommentDb);
    }

    @DeleteMapping("/ProductComments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id) {
        productCommentService.delete(id);
        ProductComment productCommentDb = productCommentService.findById(id);
        FarmerProductBean farmerProductBeanDb = productCommentDb.getFarmerProductBean();
        farmerProductBeanDb.getProductCommentList().remove(productCommentDb);
        farmerProductService.update(farmerProductBeanDb);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

package eeit45.group3.bakeyourlife.productcomment.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.productcomment.model.ProductComment;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.productcomment.service.ProductCommentService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class AdminProductCommentController {

    ProductCommentService productCommentService;
    FarmerProductService farmerProductService;
    UserService userService;

    public AdminProductCommentController(ProductCommentService productCommentService, FarmerProductService farmerProductService, UserService userService) {
        this.productCommentService = productCommentService;
        this.farmerProductService = farmerProductService;
        this.userService = userService;
    }

    @GetMapping("/admin/ProductComment/")
    public String index(Model model) {
        List<ProductComment> productCommentList = productCommentService.findAll();
        model.addAttribute(productCommentList);
        return "admin/productcomment/ProductComment";
    }

//    @GetMapping("/admin/ProductComment/CreateProductComment")
//    public String createProductComment(Model model) {
//        List<FarmerProductBean> farmerProductBeanList = farmerProductService.findAll();
//        List<User> userList = userService.findAll();
//        model.addAttribute(farmerProductBeanList);
//        model.addAttribute(userList);
//
//        return "admin/productcomment/CreateProductComment";
//    }

    @GetMapping("/admin/ProductComment/UpdateProductComment")
    public String updateProductComment(@RequestParam Integer productCommentId, Model model) {
        ProductComment productComment = null;
        if (productCommentId != null) {
            productComment = productCommentService.findById(productCommentId);
        }
        model.addAttribute(productComment);

        return "admin/productcomment/UpdateProductComment";
    }
}

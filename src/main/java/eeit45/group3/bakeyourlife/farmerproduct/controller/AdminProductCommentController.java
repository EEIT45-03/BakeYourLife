package eeit45.group3.bakeyourlife.farmerproduct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminProductCommentController {

    @GetMapping("/admin/ProductComment/")
    public String index() {
        return "admin/productcomment/ProductComment";
    }

    @GetMapping("/admin/ProductComment/CreateProductComment")
    public String createProductComment() {
        return "admin/productcomment/CreateProductComment";
    }

    @GetMapping("/admin/ProductComment/UpdateProductComment")
    public String updateProductComment() {
        return "admin/productcomment/UpdateProductComment";
    }
}

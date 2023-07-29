package eeit45.group3.bakeyourlife.productcomment.controller;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import eeit45.group3.bakeyourlife.productcomment.model.ProductComment;
import eeit45.group3.bakeyourlife.productcomment.service.ProductCommentService;
import eeit45.group3.bakeyourlife.user.service.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductCommentController {

  ProductCommentService productCommentService;
  UserService userService;
  FarmerProductService farmerProductService;

  GoodService goodService;

  public ProductCommentController(
      ProductCommentService productCommentService,
      UserService userService,
      FarmerProductService farmerProductService,
      GoodService goodService) {
    this.productCommentService = productCommentService;
    this.userService = userService;
    this.farmerProductService = farmerProductService;
    this.goodService = goodService;
  }

  @GetMapping("/ProductComments")
  public ResponseEntity<List<ProductComment>> getComments() {
    List<ProductComment> productCommentList = productCommentService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(productCommentList);
  }

  //    @PostMapping("/ProductComments/{userid}/{productid}")
  //    public ResponseEntity<ProductComment> createComment(@PathVariable Integer userid,
  // @PathVariable Integer productid, @RequestBody @Valid ProductComment productComment) {
  //
  //        User user = userService.findByUserId(userid);
  //        FarmerProductBean farmerProductBean =
  // farmerProductService.findByFarmerProductId(productid);
  //        if (user != null && farmerProductBean != null) {
  //            productComment.setUser(user);
  //            productComment.setFarmerProductBean(farmerProductBean);
  //        }
  //        Date date = new Date();
  //        productComment.setTime(date);
  //        ProductComment productCommentDb = productCommentService.create(productComment);
  //        return ResponseEntity.status(HttpStatus.CREATED).body(productCommentDb);
  //    }

  @PutMapping("/ProductComments/{id}")
  public ResponseEntity<ProductComment> updateComment(
      @PathVariable Integer id, @RequestBody ProductComment productComment) {

    if (!productCommentService.existsById(id)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    ProductComment productCommentDb = productCommentService.findById(id);
    productCommentDb.setStar(productComment.getStar());
    productCommentDb.setCommentContent(productComment.getCommentContent());
    productCommentDb.setTime(new Date());

    productComment.setProductCommentId(id);
    productCommentService.update(productCommentDb);

    FarmerProductBean farmerProductBeanDb = productCommentDb.getFarmerProductBean();
    Goods goodsDb = productCommentDb.getGoods();
    if (farmerProductBeanDb != null) {
      farmerProductBeanDb.getProductCommentList().remove(productCommentDb);
      farmerProductService.update(farmerProductBeanDb);
    }
    if (goodsDb != null) {
      goodsDb.getProductCommentList().remove(productCommentDb);
      goodService.updateGoods(goodsDb);
    }

    return ResponseEntity.status(HttpStatus.OK).body(productCommentDb);
  }

  @DeleteMapping("/ProductComments/{id}")
  public ResponseEntity<?> deleteComment(@PathVariable Integer id) {

    ProductComment productCommentDb = productCommentService.findById(id);
    productCommentService.delete(id);

    FarmerProductBean farmerProductBeanDb = productCommentDb.getFarmerProductBean();
    Goods goodsDb = productCommentDb.getGoods();
    if (farmerProductBeanDb != null) {
      farmerProductBeanDb.getProductCommentList().remove(productCommentDb);
      farmerProductService.update(farmerProductBeanDb);
    }
    if (goodsDb != null) {
      goodsDb.getProductCommentList().remove(productCommentDb);
      goodService.updateGoods(goodsDb);
    }
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}

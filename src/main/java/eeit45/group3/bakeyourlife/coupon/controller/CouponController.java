package eeit45.group3.bakeyourlife.coupon.controller;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.coupon.service.CouponService;
import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CouponController {

  private CouponService couponService;
  private OrderService orderService;

  @Autowired
  public CouponController(CouponService couponService, OrderService orderService) {
    this.couponService = couponService;
    this.orderService = orderService;
  }

  @GetMapping("/Coupons")
  public ResponseEntity<List<Coupon>> getCoupons() {
    List<Coupon> coupons = couponService.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(coupons);
  }

  @PostMapping("/Coupons")
  public ResponseEntity<Coupon> createCoupon(@RequestBody @Valid Coupon coupon) {
    Coupon couponDb = couponService.createCoupon(coupon);
    return ResponseEntity.status(HttpStatus.CREATED).body(couponDb);
  }

  @PutMapping("/Coupons/{code}")
  public ResponseEntity<Coupon> updateCoupon(
      @PathVariable String code, @RequestBody @Valid Coupon coupon) {
    //        Coupon couponDb = couponService.findById(code).orElse(null);
    // 回傳是否存在，存在回傳true，反相
    if (!couponService.existsById(code)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    coupon.setCode(code);
    couponService.updateCoupon(coupon);

    Coupon couponDb = couponService.findById(code).orElse(null);
    return ResponseEntity.status(HttpStatus.OK).body(couponDb);
  }

  @DeleteMapping("/Coupons/{code}")
  public ResponseEntity<?> deleteCoupon(@PathVariable String code) {
    couponService.deleteCoupon(code);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @GetMapping("/Coupons/{code}")
  public ResponseEntity<Coupon> getCoupon(@PathVariable String code) {
    Coupon coupon = couponService.findById(code).orElse(null);
    if (coupon == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(coupon);
  }

  @GetMapping("/Coupons{code}/Orders")
  public ResponseEntity<List<Order>> getOrdersByCouponCode(@PathVariable String code) {
    List<Order> list = orderService.findAllByCouponCode(code);
    return ResponseEntity.status(HttpStatus.OK).body(list);
  }
}

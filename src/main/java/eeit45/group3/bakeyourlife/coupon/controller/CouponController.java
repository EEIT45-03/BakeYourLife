package eeit45.group3.bakeyourlife.coupon.controller;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CouponController {

    private CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @GetMapping("/Coupons")
    public ResponseEntity<List<Coupon>> getCoupons(){
        List<Coupon> coupons = couponService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(coupons);
    }

    @PostMapping("/Coupons")
    public ResponseEntity<Coupon> createCoupon( @RequestBody @Valid Coupon coupon ){
        Coupon couponDb = couponService.createCoupon(coupon);
        return ResponseEntity.status(HttpStatus.CREATED).body(couponDb);
    }

    @PutMapping("/Coupons/{code}")
    public ResponseEntity<Coupon> updateCoupon(@PathVariable String code,
                                               @RequestBody @Valid Coupon coupon){
        Coupon couponDb = couponService.findById(code).orElse(null);
        if(couponDb==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        coupon.setCode(code);
        couponService.updateCoupon(coupon);

        couponDb = couponService.findById(code).orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(couponDb);
    }

    @DeleteMapping("/Coupons/{code}")
    public ResponseEntity<?> deleteCoupon(@PathVariable String code){
        couponService.deleteCoupon(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}

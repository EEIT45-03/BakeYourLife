package eeit45.group3.bakeyourlife.coupon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminCouponController {

    @GetMapping("/admin/Coupon/")
    public String index(){
        return "admin/coupon/Coupon";
    }

    @GetMapping("/admin/Coupon/CreateCoupon")
    public String createCoupon(){
        return "admin/coupon/CreateCoupon";
    }
}

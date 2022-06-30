package eeit45.group3.bakeyourlife.coupon.controller;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

    @GetMapping("/admin/Coupon/UpdateCoupon")
    public String updateCoupon() {
        return "admin/coupon/UpdateCoupon";
    }

}

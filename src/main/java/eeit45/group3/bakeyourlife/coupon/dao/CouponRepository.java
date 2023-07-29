package eeit45.group3.bakeyourlife.coupon.dao;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository<T extends Coupon> extends JpaRepository<Coupon, String> {}

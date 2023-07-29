package eeit45.group3.bakeyourlife.coupon.service;

import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.user.model.User;
import java.util.List;
import java.util.Optional;

public interface CouponService {
  Coupon createCoupon(Coupon coupon);

  void updateCoupon(Coupon coupon);

  void deleteCoupon(String code);

  boolean isUsedCoupon(User user, String code);

  List<Coupon> findAll();

  Optional<Coupon> findById(String code);

  boolean existsById(String code);
}

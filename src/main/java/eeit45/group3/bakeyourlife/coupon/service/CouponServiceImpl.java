package eeit45.group3.bakeyourlife.coupon.service;

import eeit45.group3.bakeyourlife.coupon.dao.CouponRepository;
import eeit45.group3.bakeyourlife.coupon.model.Coupon;
import eeit45.group3.bakeyourlife.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CouponServiceImpl implements CouponService{

    private CouponRepository<Coupon> repository;

    @Autowired
    public CouponServiceImpl(CouponRepository repository) {
        this.repository = repository;
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        boolean exists = repository.existsById(coupon.getCode());
        if(exists){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"這個優惠卷代碼已存在");
        }
        return repository.save(coupon);
    }

    @Override
    public void updateCoupon(Coupon coupon) {
        Coupon couponDb = repository.findById(coupon.getCode()).orElse(null);
        if(couponDb!=null){
            repository.save(coupon);
        }
    }

    @Override
    public void deleteCoupon(String code) {
        repository.deleteById(code);
    }

    @Override
    public boolean isUsedCoupon(User user, String code) {
        return false;
    }

    @Override
    public List<Coupon> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Coupon> findById(String code) {
        return repository.findById(code);
    }

    @Override
    public boolean existsById(String code) {
        return repository.existsById(code);
    }
}

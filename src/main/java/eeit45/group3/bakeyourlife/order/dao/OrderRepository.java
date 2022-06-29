package eeit45.group3.bakeyourlife.order.dao;

import eeit45.group3.bakeyourlife.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    
    List<Order> findAllByOrderDateBetween(Date orderDateStart, Date orderDateEnd);

    Optional<Order> findByOrderNo(String orderNo);

}

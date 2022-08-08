package eeit45.group3.bakeyourlife.order.dao;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    Set<OrderItem> findByOrder(Order order);
}

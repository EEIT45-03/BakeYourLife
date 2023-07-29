package eeit45.group3.bakeyourlife.order.dao;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
  Set<OrderItem> findByOrder(Order order);
}

package uz.pdp.AvtoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.AvtoTicket.entity.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.Address;
import uz.pdp.AutoTicket.entity.Order;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:41
 */
public interface OrderRepository extends JpaRepository<Order, Long>, Repository {

    @Query("SELECT o FROM Order o WHERE o.id = :id AND o.isDeleted = FALSE")
    Optional<Order> findByIdCustom(Long id);

    @Query("SELECT o FROM Order o WHERE  o.isDeleted = FALSE")
    Optional<List<Order>> findAllCustom();

    @Modifying
    @Query("UPDATE Order o SET o.isDeleted = TRUE WHERE o.id = :id")
    void deleteByIdCustom(Long id);

}

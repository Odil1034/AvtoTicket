package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.Address;
import uz.pdp.AutoTicket.entity.Bus;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 03/09/2025 10:41
 */
public interface BusRepository extends JpaRepository<Bus, Long>, Repository {

    @Query("SELECT b FROM Bus b WHERE b.id = :id AND b.isDeleted = FALSE")
    Optional<Bus> findByIdCustom(Long id);

    @Query("SELECT b FROM Bus b WHERE  b.isDeleted = FALSE")
    Optional<List<Bus>> findAllCustom();

    @Modifying
    @Query("UPDATE Bus b SET b.isDeleted = TRUE WHERE b.id = :id")
    void deleteByIdCustom(Long id);

}

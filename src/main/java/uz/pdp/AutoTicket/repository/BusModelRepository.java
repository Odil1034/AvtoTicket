package uz.pdp.AutoTicket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.AutoTicket.entity.Address;
import uz.pdp.AutoTicket.entity.BusModel;

import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 02/09/2025 21:47
 */
public interface BusModelRepository extends JpaRepository<Address, Long>, Repository {

    @Query("SELECT bm FROM BusModel bm WHERE bm.id = :id AND bm.isDeleted = FALSE")
    Optional<BusModel> findByIdCustom(Long id);

    @Query("SELECT bm FROM BusModel bm WHERE  bm.isDeleted = FALSE")
    Optional<List<BusModel>> findAllCustom();

    @Modifying
    @Query("UPDATE BusModel bm SET bm.isDeleted = TRUE WHERE bm.id = :id")
    void deleteByIdCustom(Long id);

}

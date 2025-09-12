package uz.pdp.avtoticket.repository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import uz.pdp.avtoticket.entity.BusModel;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

/**
 * @author Baxriddinov Odiljon
 * @since 02/09/2025 21:47
 */
public interface BusModelRepository extends JpaRepository<BusModel, Long>, Repository {

    @Query("SELECT bm FROM BusModel bm WHERE bm.id = :id AND bm.isDeleted = FALSE")
    Optional<BusModel> findByIdCustom(Long id);

    @Query("SELECT bm FROM BusModel bm WHERE  bm.isDeleted = FALSE")
    List<BusModel> findAllCustom();

    @Modifying
    @Query("UPDATE BusModel bm SET bm.isDeleted = TRUE WHERE bm.id = :id")
    void deleteByIdCustom(Long id);

    boolean existsByName(@NotNull @NotBlank String name);

    @Query("SELECT bm FROM BusModel bm WHERE bm.name = :name AND bm.isDeleted = FALSE")
    List<BusModel> findBusModelsByName(String name);

    @Query("SELECT b.model FROM Bus b GROUP BY b.model ORDER BY COUNT(b) DESC")
    BusModel findMostUsedModel();
}
